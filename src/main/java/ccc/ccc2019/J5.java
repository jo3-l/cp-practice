package ccc.ccc2019;

import java.util.*;

public class J5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Rule[] rules = new Rule[3];
        Rule[] reversedRules = new Rule[3];

        for (int ruleNumber = 1; ruleNumber <= 3; ruleNumber++) {
            String[] parts = scanner.nextLine().split(" ");
            String originalSequence = parts[0];
            String finalSequence = parts[1];

            Rule rule = new Rule(originalSequence, finalSequence, ruleNumber);
            rules[ruleNumber - 1] = rule;

            Rule reversedRule = new Rule(finalSequence, originalSequence, ruleNumber);
            reversedRules[ruleNumber - 1] = reversedRule;
        }

        TrieNode rootNode = new TrieNode();
        buildTrie(rootNode, rules);
        constructLinks(rootNode);

        TrieNode reversedRootNode = new TrieNode();
        buildTrie(reversedRootNode, reversedRules);
        constructLinks(reversedRootNode);

        String[] parts = scanner.nextLine().split(" ");
        int stepsToTake = Integer.parseInt(parts[0]);
        String originalSequence = parts[1];
        String wantedSequence = parts[2];

        if (stepsToTake == 1) {
            List<RuleMatch> history = null;
            for (List<RuleMatch> possibleHistory : getSubstitutionHistories(originalSequence, stepsToTake, rootNode)) {
                String resultingSequence = possibleHistory.get(possibleHistory.size() - 1).resultingSequence;
                if (resultingSequence.equals(wantedSequence)) {
                    history = possibleHistory;
                    break;
                }
            }

            for (RuleMatch match : history) System.out.println(match.toString(false));
        }

        // Meet in the middle - find resulting sequences from doing half the work, then move backwards and stop once
        // the resulting sequence is one from earlier.
        int steps = stepsToTake >> 1;
        int reverseSteps = stepsToTake - steps;

        Map<String, List<RuleMatch>> histories = new HashMap<>();
        for (List<RuleMatch> possibleHistory : getSubstitutionHistories(originalSequence, steps, rootNode)) {
            String resultingSequence = possibleHistory.get(possibleHistory.size() - 1).resultingSequence;
            histories.put(resultingSequence, possibleHistory);
        }

        List<RuleMatch> reverseHistory = null;
        List<RuleMatch> history = null;

        Queue<List<RuleMatch>> queue = new ArrayDeque<>();
        queue.add(new ArrayList<>());

        int stepsTaken = 0;
        outer: while (!queue.isEmpty()) {
            boolean isFinal = stepsTaken + 1 == reverseSteps;

            int size = queue.size();
            while (size-- > 0) {
                List<RuleMatch> hs = queue.poll();
                String sequence = hs.isEmpty() ? originalSequence : hs.get(hs.size() - 1).resultingSequence;

                TrieNode parentNode = reversedRootNode;
                for (int i = 0; i < sequence.length(); i++) {
                    CharacterType charType = CharacterType.from(sequence.charAt(i));

                    TrieNode childNode = parentNode.children.get(charType);
                    if (childNode == null) {
                        while (parentNode != reversedRootNode && !parentNode.children.containsKey(charType)) parentNode = parentNode.suffixLink;
                        if (parentNode.children.containsKey(charType)) --i;
                    } else {
                        parentNode = childNode;

                        if (parentNode.rule != null) {
                            RuleMatch ruleMatch = createRuleMatch(parentNode.rule, sequence, i);
                            List<RuleMatch> clone = new ArrayList<>(hs);
                            clone.add(ruleMatch);

                            if (isFinal) {
                                List<RuleMatch> forwardHistory = histories.get(ruleMatch.resultingSequence);
                                if (forwardHistory != null) {
                                    reverseHistory = clone;
                                    history = forwardHistory;
                                    break outer;
                                }
                            }

                            queue.offer(clone);
                        }

                        TrieNode linkedNode = parentNode.outputLink;
                        while (linkedNode != null) {
                            RuleMatch ruleMatch = createRuleMatch(linkedNode.rule, sequence, i);
                            List<RuleMatch> clone = new ArrayList<>(hs);
                            clone.add(ruleMatch);

                            if (isFinal) {
                                List<RuleMatch> forwardHistory = histories.get(ruleMatch.resultingSequence);
                                if (forwardHistory != null) {
                                    reverseHistory = clone;
                                    history = forwardHistory;
                                    break outer;
                                }
                            }

                            queue.offer(clone);

                            linkedNode = linkedNode.outputLink;
                        }
                    }
                }
            }
        }

        for (RuleMatch match : history) System.out.println(match.toString(false));
        for (int i = reverseHistory.size() - 1; i >= 0; i--) System.out.println(reverseHistory.get(i).toString(true));
    }

    private static Queue<List<RuleMatch>> getSubstitutionHistories(String originalSequence, int stepsToTake, TrieNode rootNode) {
        Queue<List<RuleMatch>> queue = new ArrayDeque<>();
        queue.add(new ArrayList<>());

        int stepsTaken = 0;
        while (!queue.isEmpty()) {
            if (stepsTaken == stepsToTake) return queue;

            int size = queue.size();
            while (size-- > 0) {
                List<RuleMatch> history = queue.poll();
                String sequence = history.isEmpty() ? originalSequence : history.get(history.size() - 1).resultingSequence;

                TrieNode parentNode = rootNode;
                for (int i = 0; i < sequence.length(); i++) {
                    CharacterType charType = CharacterType.from(sequence.charAt(i));

                    TrieNode childNode = parentNode.children.get(charType);
                    if (childNode == null) {
                        while (parentNode != rootNode && !parentNode.children.containsKey(charType)) parentNode = parentNode.suffixLink;
                        if (parentNode.children.containsKey(charType)) --i;
                    } else {
                        parentNode = childNode;

                        if (parentNode.rule != null) {
                            RuleMatch ruleMatch = createRuleMatch(parentNode.rule, sequence, i);
                            List<RuleMatch> clone = new ArrayList<>(history);
                            clone.add(ruleMatch);
                            queue.offer(clone);
                        }

                        TrieNode linkedNode = parentNode.outputLink;
                        while (linkedNode != null) {
                            RuleMatch ruleMatch = createRuleMatch(linkedNode.rule, sequence, i);
                            List<RuleMatch> clone = new ArrayList<>(history);
                            clone.add(ruleMatch);
                            queue.offer(clone);

                            linkedNode = linkedNode.outputLink;
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

    private static void buildTrie(TrieNode root, Rule[] rules) {
        for (Rule rule : rules) {
            TrieNode node = root;
            for (int i = 0; i < rule.originalSequence.length(); i++) {
                CharacterType charType = CharacterType.from(rule.originalSequence.charAt(i));

                TrieNode childNode = node.children.get(charType);
                if (childNode == null) {
                    TrieNode newChild = new TrieNode();
                    node.children.put(charType, newChild);
                    node = newChild;
                } else {
                    node = childNode;
                }
            }

            node.rule = rule;
        }
    }

    private static void constructLinks(TrieNode root) {
        root.suffixLink = root;

        Queue<TrieNode> queue = new ArrayDeque<>();
        for (TrieNode childNode : root.children.values()) {
            childNode.suffixLink = root;
            queue.add(childNode);
        }

        while (!queue.isEmpty()) {
            TrieNode parentNode = queue.poll();
            for (EnumMap.Entry<CharacterType, TrieNode> entry : parentNode.children.entrySet()) {
                CharacterType key = entry.getKey();
                TrieNode node = entry.getValue();

                while (node != root && !node.children.containsKey(key)) node = node.suffixLink;

                TrieNode toLink = node.children.get(key);
                if (toLink == null) entry.getValue().suffixLink = root;
                else entry.getValue().suffixLink = toLink;

                queue.add(entry.getValue());
            }

            if (parentNode.suffixLink.rule == null) parentNode.outputLink = parentNode.suffixLink.outputLink;
            else parentNode.outputLink = parentNode.suffixLink;
        }
    }

    private static class TrieNode {
        public final EnumMap<CharacterType, TrieNode> children = new EnumMap<>(CharacterType.class);
        public TrieNode outputLink;
        public TrieNode suffixLink;
        public Rule rule;
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
}
