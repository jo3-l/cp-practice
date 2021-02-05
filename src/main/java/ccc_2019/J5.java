package ccc_2019;

import java.util.*;

// This solution seems to work fine but only gets 7/15 points, TLEing on other batches. Help is appreciated!
public class J5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TrieNode rootNode = new TrieNode(false, null);

        for (int n = 0; n < 3; n++) {
            String[] parts = scanner.nextLine().split(" ");
            String originalSequence = parts[0];
            String finalSequence = parts[1];

            Rule rule = new Rule(originalSequence, finalSequence, n + 1); // Rule number is 1-based.

            TrieNode.linkRuleToNode(rule, rootNode);
        }

        String[] parts = scanner.nextLine().split(" ");
        int stepsToTake = Integer.parseInt(parts[0]);
        String originalSequence = parts[1];
        String finalSequence = parts[2];

        SequenceFinder finder = new SequenceFinder(stepsToTake, finalSequence, rootNode);
        List<RuleMatch> history = finder.getRuleHistory(originalSequence);
        if (history == null) {
            System.out.println("Didn't find a sequence of substitutions that matched the given criteria. This should never happen!");
            return;
        }

        for (RuleMatch match : history) System.out.println(match.toString());
    }

    private static class SequenceFinder {
        private final int stepsToTake;
        private final String finalSequence;
        private final TrieNode rootNode;
        private final List<RuleMatch> history = new ArrayList<>();

        public SequenceFinder(int stepsToTake, String finalSequence, TrieNode rootNode) {
            this.stepsToTake = stepsToTake;
            this.finalSequence = finalSequence;
            this.rootNode = rootNode;
        }

        public List<RuleMatch> getRuleHistory(String sequence) {
            // Edge cases
            int stepsTaken = history.size();
            if (sequence.equals(finalSequence) && stepsTaken == stepsToTake) return history;
            if (stepsTaken >= stepsToTake) return null;

            // List of nodes that are in the middle of being matched currently
            LinkedList<TrieNode> matchingNodes = new LinkedList<>();

            // Loop over the string and run a depth-first recursive search over possible substitutions we can perform
            for (int i = 0; i < sequence.length(); i++) {
                char c = sequence.charAt(i);
                int startIteratingAt = 0;

                // See if there's a substitution rule that starts with the current character
                TrieNode adjacentNode = rootNode.getAdjacentNode(c);
                if (adjacentNode != null) {
                    // If there are rules on this node, then apply them to the current string and recursively find rules which can be applied to that new string
                    for (Rule rule : adjacentNode.applicableRules) {
                        RuleMatch ruleMatch = createRuleMatch(rule, sequence, i);
                        // Add this match to the history
                        history.add(ruleMatch);
                        // See if we can obtain a valid result using the new string
                        List<RuleMatch> resultingHistory = getRuleHistory(ruleMatch.resultingSequence);
                        // If we didn't get a valid result, remove the match from the history
                        if (resultingHistory == null) history.remove(history.size() - 1);
                            // If we did get a valid result, bubble it upwards
                        else return history;
                    }

                    if (!adjacentNode.isLeaf()) {
                        matchingNodes.addFirst(adjacentNode);
                        startIteratingAt = 1; // Skip iterating over the node we just added.
                    }
                }

                // Now continue matching the nodes from previous iterations
                ListIterator<TrieNode> iter = matchingNodes.listIterator(startIteratingAt);
                while (iter.hasNext()) {
                    TrieNode node = iter.next();
                    adjacentNode = node.getAdjacentNode(c);
                    if (adjacentNode != null) {
                        // Similar steps as that above
                        for (Rule rule : adjacentNode.applicableRules) {
                            RuleMatch ruleMatch = createRuleMatch(rule, sequence, i);
                            history.add(ruleMatch);
                            List<RuleMatch> resultingHistory = getRuleHistory(ruleMatch.resultingSequence);
                            if (resultingHistory == null) history.remove(history.size() - 1);
                            else return history;
                        }

                        if (adjacentNode.isLeaf()) iter.remove(); // Done with this node for now, so remove it.
                        else iter.set(adjacentNode); // Otherwise, set it to the adjacent node (advancing 1 position).
                    } else {
                        iter.remove(); // Unable to find an adjacent node, so remove it.
                    }
                }
            }

            return null;
        }

        private RuleMatch createRuleMatch(Rule rule, String str, int endIndex) {
            int startIndex = endIndex - rule.originalSequence.length() + 1;
            return new RuleMatch(rule, str, startIndex);
        }
    }

    private static class RuleMatch {
        private final String resultingSequence;
        private final int startPosition;
        private final int ruleNumber;

        public RuleMatch(Rule rule, String sequence, int startIndex) {
            this.resultingSequence = rule.applyTo(sequence, startIndex);
            this.startPosition = startIndex + 1; // Question asks for the position to be 1-based.
            this.ruleNumber = rule.ruleNumber;
        }

        @Override
        public String toString() {
            return ruleNumber + " " + startPosition + " " + resultingSequence;
        }
    }

    private static class Rule {
        public final String originalSequence;
        public final String finalSequence;
        public final int ruleNumber;

        public Rule(String originalSequence, String finalSequence, int ruleNumber) {
            this.originalSequence = originalSequence;
            this.finalSequence = finalSequence;
            this.ruleNumber = ruleNumber;
        }

        public String applyTo(String str, int startIndex) {
            String startSubstr = str.substring(0, startIndex);
            String endSubstr = str.substring(startIndex + originalSequence.length());
            return startSubstr + finalSequence + endSubstr;
        }
    }

    private static class TrieNode {
        public final boolean hasRule;
        public final List<Rule> applicableRules;
        private final Map<Character, TrieNode> adjacentNodes = new HashMap<>();

        public TrieNode(boolean hasRule, List<Rule> rules) {
            this.applicableRules = rules == null ? new ArrayList<>() : rules;
            this.hasRule = hasRule;
        }

        public static void linkRuleToNode(Rule rule, TrieNode node) {
            TrieNode currentNode = node;
            // Add this string to the trie.
            for (int i = 0; i < rule.originalSequence.length(); i++) {
                TrieNode newNode = i == rule.originalSequence.length() - 1
                        ? new TrieNode(true, new ArrayList<>(Collections.singletonList(rule))) // Last character of this stirng, so construct a leaf node.
                        : new TrieNode(false, null);

                // Connect this node to the last one, and then set the new node to the current node.
                currentNode = currentNode.link(rule.originalSequence.charAt(i), newNode);
            }
        }

        public TrieNode link(char c, TrieNode node) {
            return adjacentNodes.merge(c, node, (oldNode, __) -> {
                // Merge the old node's applicable rules with the new node's.
                TrieNode newNode = new TrieNode(oldNode.hasRule || node.hasRule, oldNode.applicableRules);
                newNode.applicableRules.addAll(node.applicableRules);

                // Merge the old node's adjacent nodes with the new node's.
                newNode.adjacentNodes.putAll(oldNode.adjacentNodes);
                for (Map.Entry<Character, TrieNode> entry : node.adjacentNodes.entrySet())
                    newNode.link(entry.getKey(), entry.getValue());

                return newNode;
            });
        }

        public TrieNode getAdjacentNode(char c) {
            return adjacentNodes.get(c);
        }

        public boolean isLeaf() {
            return hasRule && adjacentNodes.isEmpty();
        }
    }
}