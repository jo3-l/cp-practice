package ccc2019;

import java.util.*;
import java.util.stream.Collectors;

public class J5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TrieNode rootNode = new TrieNode(false, null);
        TrieNode backwardsRootNode = new TrieNode(false, null);
        for (int ruleNumber = 1; ruleNumber <= 3; ruleNumber++) {
            String[] parts = scanner.nextLine().split(" ");
            String originalSequence = parts[0];
            String finalSequence = parts[1];

            TrieNode.linkRuleToNode(new Rule(originalSequence, finalSequence, ruleNumber), rootNode);
            TrieNode.linkRuleToNode(new Rule(finalSequence, originalSequence, ruleNumber), backwardsRootNode);
        }

        String[] parts = scanner.nextLine().split(" ");
        int stepsToTake = Integer.parseInt(parts[0]);
        String originalSequence = parts[1];
        String resultingSequence = parts[2];

        if (stepsToTake == 1) {
            List<RuleMatch> history = getSubstitutionHistories(originalSequence, stepsToTake, rootNode)
                    .stream()
                    .filter(v -> v.get(v.size() - 1).resultingSequence.equals(resultingSequence))
                    .findFirst()
                    .get();

            for (RuleMatch match : history) System.out.println(match.toString(false));
        }

        // Meet in the middle, split work in half.
        int forwardSteps = Math.floorDiv(stepsToTake, 2);
        int reverseSteps = stepsToTake - forwardSteps;

        Queue<List<RuleMatch>> frontHistories = getSubstitutionHistories(originalSequence, forwardSteps, rootNode);
        Set<String> frontResultingSequences = frontHistories
                .stream()
                .map(history -> history.get(history.size() - 1).resultingSequence)
                .collect(Collectors.toCollection(HashSet::new));

        List<RuleMatch> backHistory = getSubstitutionHistories(resultingSequence, reverseSteps, backwardsRootNode)
                .stream()
                .filter(history -> frontResultingSequences.contains(history.get(history.size() - 1).resultingSequence))
                .findFirst()
                .get();

        String middleResultingSequence = backHistory.get(backHistory.size() - 1).resultingSequence;
        List<RuleMatch> matchingFrontHistory = frontHistories
                .stream()
                .filter(v -> {
                    String finalSequence = v.get(v.size() - 1).resultingSequence;
                    return finalSequence.equals(middleResultingSequence);
                })
                .findFirst()
                .get();

        for (RuleMatch match : matchingFrontHistory) System.out.println(match.toString(false));
        for (int i = backHistory.size() - 1; i >= 0; i--) System.out.println(backHistory.get(i).toString(true));
    }

    private static Queue<List<RuleMatch>> getSubstitutionHistories(String originalSequence, int stepsToTake, TrieNode rootNode) {
        Queue<List<RuleMatch>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());

        int stepsTaken = 0;
        while (!queue.isEmpty()) {
            if (stepsTaken == stepsToTake) return queue;

            // Process all nodes at the current level before moving on.
            int levelBreadth = queue.size();
            while (levelBreadth-- > 0) {
                List<RuleMatch> history = queue.poll();
                String sequence = history.isEmpty()
                        ? originalSequence
                        : history.get(history.size() - 1).resultingSequence;

                LinkedList<TrieNode> matchingTrieNodes = new LinkedList<>();
                for (int i = 0; i < sequence.length(); i++) {
                    CharacterType c = CharacterType.from(sequence.charAt(i));
                    boolean wasNewNodeAdded = false;

                    TrieNode adjacentNode = rootNode.getAdjacentNode(c);
                    if (adjacentNode != null) {
                        for (Rule rule : adjacentNode.applicableRules) {
                            RuleMatch ruleMatch = createRuleMatch(rule, sequence, i);

                            // Clone as we don't want to mutate the original history.
                            List<RuleMatch> historyClone = new ArrayList<>(history);
                            historyClone.add(ruleMatch);
                            queue.offer(historyClone);
                        }

                        if (!adjacentNode.isLeaf()) {
                            matchingTrieNodes.offerFirst(adjacentNode);
                            wasNewNodeAdded = true;
                        }
                    }

                    // Continue matching trie nodes from previous iterations. Remember to skip the first element
                    // if we added a new node, we don't want to match it twice.
                    ListIterator<TrieNode> it = matchingTrieNodes.listIterator(wasNewNodeAdded ? 1 : 0);
                    while (it.hasNext()) {
                        TrieNode node = it.next();
                        adjacentNode = node.getAdjacentNode(c);
                        if (adjacentNode == null) {
                            it.remove();
                            continue;
                        }

                        for (Rule rule : adjacentNode.applicableRules) {
                            RuleMatch ruleMatch = createRuleMatch(rule, sequence, i);
                            // Again, clone the history so our changes don't affect the original instance.
                            List<RuleMatch> historyClone = new ArrayList<>(history);
                            historyClone.add(ruleMatch);
                            queue.offer(historyClone);
                        }

                        if (adjacentNode.isLeaf()) {
                            // Done matching this node, so remove it.
                            it.remove();
                        } else {
                            // Replace old trie node with the new one which has advanced 1 position.
                            it.set(adjacentNode);
                        }
                    }
                }
            }

            ++stepsTaken;
        }

        throw new IllegalStateException();
    }

    private static RuleMatch createRuleMatch(Rule rule, String str, int endIndex) {
        int startIndex = endIndex - rule.originalSequence.length() + 1;
        return new RuleMatch(rule, str, startIndex);
    }

    private enum CharacterType {
        A,
        B;

        public static CharacterType from(int codepoint) {
            switch (codepoint) {
                case 'A':
                    return CharacterType.A;
                case 'B':
                    return CharacterType.B;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    private static class RuleMatch {
        private final String originalSequence;
        private final String resultingSequence;
        private final int startIndex;
        private final int ruleNumber;

        public RuleMatch(Rule rule, String originalSequence, int startIndex) {
            this.originalSequence = originalSequence;
            this.startIndex = startIndex;
            resultingSequence = rule.applyTo(originalSequence, startIndex);
            ruleNumber = rule.ruleNumber;
        }

        public String toString(boolean reverse) {
            // +1 since question wants position to be 1-based.
            return ruleNumber + " " + (startIndex + 1) + " " + (reverse ? originalSequence : resultingSequence);
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
            return str.substring(0, startIndex) + finalSequence + str.substring(startIndex + originalSequence.length());
        }
    }

    private static class TrieNode {
        public final boolean hasRule;
        public final List<Rule> applicableRules;
        private final EnumMap<CharacterType, TrieNode> adjacentNodes = new EnumMap<>(CharacterType.class);

        public TrieNode(boolean hasRule, List<Rule> rules) {
            applicableRules = rules == null ? new ArrayList<>() : rules;
            this.hasRule = hasRule;
        }

        public static void linkRuleToNode(Rule rule, TrieNode node) {
            TrieNode currentNode = node;
            for (int i = 0; i < rule.originalSequence.length(); i++) {
                TrieNode newNode;
                // If it's the last character in the sequence...
                if (i == rule.originalSequence.length() - 1) {
                    List<Rule> ruleList = new ArrayList<>();
                    ruleList.add(rule);
                    // Create a leaf node.
                    newNode = new TrieNode(true, ruleList);
                } else {
                    newNode = new TrieNode(false, null);
                }

                CharacterType c = CharacterType.from(rule.originalSequence.charAt(i));
                currentNode = currentNode.link(c, newNode);
            }
        }

        public TrieNode link(CharacterType c, TrieNode node) {
            return adjacentNodes.merge(c, node, (oldNode, newNode) -> {
                TrieNode mergedNode = new TrieNode(oldNode.hasRule || newNode.hasRule, oldNode.applicableRules);
                mergedNode.applicableRules.addAll(newNode.applicableRules);

                mergedNode.adjacentNodes.putAll(oldNode.adjacentNodes);
                for (Map.Entry<CharacterType, TrieNode> entry : node.adjacentNodes.entrySet())
                    mergedNode.link(entry.getKey(), entry.getValue());
                return mergedNode;
            });
        }

        public TrieNode getAdjacentNode(CharacterType c) {
            return adjacentNodes.get(c);
        }

        public boolean isLeaf() {
            return adjacentNodes.isEmpty();
        }
    }
}
