package ccc.ccc2012;

import java.util.*;

public class J5S4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int coinCount = scanner.nextInt();
            if (coinCount == 0) return;

            int[] coins = new int[coinCount];
            int lastValue = -1;
            boolean isSorted = true;
            for (int i = 0; i < coinCount; i++) {
                int value = scanner.nextInt();
                coins[i] = value;
                if (!isSorted) continue;

                if (value < lastValue) isSorted = false;
                else lastValue = value;
            }

            if (isSorted) {
                System.out.println("0");
                continue;
            }

            MoveFinder finder = new MoveFinder();
            int moves = finder.computeMinimumMoves(coins);
            System.out.println(moves == -1 ? "IMPOSSIBLE" : moves);
        }
    }

    private static class MoveFinder {
        private final Queue<List<Deque<Integer>>> lineUpQueue = new LinkedList<>();
        private final Set<List<Deque<Integer>>> previousLineUps = new HashSet<>();

        public int computeMinimumMoves(int[] coins) {
            reset();

            List<Deque<Integer>> initialLineUp = new ArrayList<>();
            for (int coin : coins) {
                Deque<Integer> deque = new LinkedList<>();
                deque.add(coin);
                initialLineUp.add(deque);
            }

            lineUpQueue.add(initialLineUp);
            previousLineUps.add(initialLineUp);

            int moves = 1;
            while (!lineUpQueue.isEmpty()) {
                int levelBreadth = lineUpQueue.size();
                while (levelBreadth-- > 0) {
                    List<Deque<Integer>> lineUp = lineUpQueue.poll();
                    for (int i = 0; i < lineUp.size(); i++) {
                        boolean ok = tryMove(lineUp, i, i + 1) || tryMove(lineUp, i, i - 1);
                        if (ok) return moves;
                    }
                }

                ++moves;
            }

            return -1;
        }

        private boolean tryMove(List<Deque<Integer>> lineUp, int fromIndex, int toIndex) {
            if (toIndex >= lineUp.size() || toIndex < 0) return false;

            // Check that the value to add is not larger than the top value of the stack.
            Deque<Integer> oldStack = lineUp.get(fromIndex);
            if (oldStack.isEmpty()) return false;
            int toAdd = oldStack.getFirst();

            Deque<Integer> targetStack = lineUp.get(toIndex);
            if (!targetStack.isEmpty() && toAdd > targetStack.getFirst()) return false;

            // Deep clone the line-up as we don't want to mutate the original instance.
            List<Deque<Integer>> lineUpClone = new ArrayList<>(lineUp.size());
            for (Deque<Integer> stack : lineUp) lineUpClone.add(new LinkedList<>(stack));
            lineUpClone.get(fromIndex).removeFirst();
            lineUpClone.get(toIndex).addFirst(toAdd);

            if (previousLineUps.contains(lineUpClone)) return false;

            int lastValue = 0;
            boolean isSorted = true;
            for (Deque<Integer> stack : lineUpClone) {
                if (stack.size() != 1) {
                    isSorted = false;
                    break;
                }
                int value = stack.getFirst();
                if (value < lastValue) {
                    isSorted = false;
                    break;
                }
                lastValue = value;
            }
            if (isSorted) return true;

            lineUpQueue.add(lineUpClone);
            previousLineUps.add(lineUpClone);
            return false;
        }

        private void reset() {
            lineUpQueue.clear();
            previousLineUps.clear();
        }
    }
}
