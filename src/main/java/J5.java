import java.util.*;

public class J5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TrieNode rootNode = new TrieNode(false, null);
        for (int i = 0; i < 3; i++) {
            String[] parts = scanner.nextLine().split(" ");
            String original = parts[0];
            String substitution = parts[1];

            SubstitutionRule rule = new SubstitutionRule(original, substitution, i + 1);
            TrieNode curNode = rootNode;
            for (int j = 0; j < original.length(); j++) {
                TrieNode newNode;
                // Last character, new node should be a leaf.
                List<SubstitutionRule> rules = new ArrayList<>();
                rules.add(rule);
                if (j == original.length() - 1) newNode = new TrieNode(true, rules);
                else newNode = new TrieNode(false, new ArrayList<>());

                curNode = curNode.addCharacter(original.charAt(j), newNode);
            }
        }

        String[] parts = scanner.nextLine().split(" ");
        int targetSteps = Integer.parseInt(parts[0]);
        String originalStr = parts[1];
        String endStr = parts[2];

        SequenceFinder finder = new SequenceFinder(targetSteps, endStr, rootNode);
        List<SubstitutionRuleMatch> sequence = finder.findSequence(originalStr, new ArrayList<>());
        if (sequence == null) {
            System.out.println("found none");
            return;
        }
        sequence.stream().map(SubstitutionRuleMatch::toString).forEach(System.out::println);
    }

    private static class SequenceFinder {
        private final int targetSteps;
        private final String endStr;
        private final TrieNode rootNode;

        private SequenceFinder(int targetSteps, String endStr, TrieNode rootNode) {
            this.targetSteps = targetSteps;
            this.endStr = endStr;
            this.rootNode = rootNode;
        }

        public List<SubstitutionRuleMatch> findSequence(String currentStr, List<SubstitutionRuleMatch> history) {
            int stepsTaken = history.size();
            if (currentStr.equals(endStr) && stepsTaken == targetSteps) return history;
            if (stepsTaken >= targetSteps) return null;

            LinkedList<TrieNode> matchingNodes = new LinkedList<>();

            TrieNode toAdd = null;
            for (int i = 0; i < currentStr.length(); i++) {
                char curChar = currentStr.charAt(i);
                TrieNode childNode = rootNode.getChild(curChar);
                if (childNode != null) {
                    if (childNode.isLeaf) {
                        for (SubstitutionRule rule : childNode.rules) {
                            List<SubstitutionRuleMatch> resultSequence = emitMatch(rule, currentStr, i, history);
                            if (resultSequence != null) return resultSequence;
                        }
                    }
                    if (!childNode.isEnd()) toAdd = childNode;
                }

                ListIterator<TrieNode> iter = matchingNodes.listIterator();
                while (iter.hasNext()) {
                    TrieNode matchingNode = iter.next();
                    TrieNode matchingChildNode = matchingNode.getChild(curChar);
                    if (matchingChildNode != null) {
                        if (matchingChildNode.isLeaf) {
                            for (SubstitutionRule rule : matchingChildNode.rules) {
                                List<SubstitutionRuleMatch> resultSequence = emitMatch(rule, currentStr, i, history);
                                if (resultSequence != null) return resultSequence;
                            }
                        }
                        if (matchingChildNode.isEnd()) iter.remove();
                        else iter.set(matchingChildNode);
                    } else {
                        iter.remove();
                    }
                }
                if (toAdd != null) matchingNodes.add(toAdd);
            }
            return null;
        }

        private List<SubstitutionRuleMatch> emitMatch(SubstitutionRule rule, String str, int endIndex, List<SubstitutionRuleMatch> history) {
            int startIndex = endIndex - rule.originalStr.length() + 1;
            SubstitutionRuleMatch match = new SubstitutionRuleMatch(rule, str, startIndex);
            List<SubstitutionRuleMatch> historyClone = new ArrayList<>(history);
            historyClone.add(match);
            return findSequence(match.resultingSequence, historyClone);
        }
    }

    private static class SubstitutionRuleMatch {
        public final String resultingSequence;
        public final int startPosition;
        public final int ruleNumber;

        public SubstitutionRuleMatch(SubstitutionRule rule, String originalStr, int startIndex) {
            resultingSequence = rule.applyTo(originalStr, startIndex);
            startPosition = startIndex + 1; // 1-based instead of 0-based.
            ruleNumber = rule.ruleNumber;
        }

        @Override
        public String toString() {
            return ruleNumber + " " + startPosition + " " + resultingSequence;
        }
    }

    private static class SubstitutionRule {
        public final String originalStr;
        public final String replacementStr;
        public final int ruleNumber;

        private SubstitutionRule(String originalStr, String replacementStr, int ruleNumber) {
            this.originalStr = originalStr;
            this.replacementStr = replacementStr;
            this.ruleNumber = ruleNumber;
        }

        public String applyTo(String str, int startIndex) {
            return str.substring(0, startIndex) + replacementStr + str.substring(startIndex + originalStr.length());
        }
    }

    private static class TrieNode {
        public final boolean isLeaf;
        public final List<SubstitutionRule> rules;
        private final Map<Character, TrieNode> children = new HashMap<>();

        public TrieNode(boolean isLeaf, List<SubstitutionRule> rules) {
            this.isLeaf = isLeaf;
            this.rules = rules;
        }

        public TrieNode addCharacter(char character, TrieNode node) {
            return children.merge(character, node, (prevNode, newNode) -> {
                List<SubstitutionRule> rules = new ArrayList<>(prevNode.rules);
                rules.addAll(newNode.rules);
                TrieNode mergedNode = new TrieNode(prevNode.isLeaf || newNode.isLeaf, rules);
                mergedNode.children.putAll(node.children);
                mergedNode.children.putAll(prevNode.children);
                return mergedNode;
            });
        }

        public TrieNode getChild(char character) {
            return children.get(character);
        }

        public boolean isEnd() {
            return this.isLeaf && this.children.isEmpty();
        }
    }
}
