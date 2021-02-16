package ccc2010;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class J5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startX = scanner.nextInt() - 1; // 1-based -> 0-based
        int startY = scanner.nextInt() - 1;
        int endX = scanner.nextInt() - 1;
        int endY = scanner.nextInt() - 1;

        if (startX == endX && startY == endY) {
            System.out.println("0");
            return;
        }

        PathFinder finder = new PathFinder(endX, endY);
        System.out.println(finder.findShortestPath(startX, startY));
    }

    private static class PathFinder {
        private final boolean[][] board = new boolean[8][8];
        private final Queue<Square> queuedMoves = new LinkedList<>();
        private final int endX;
        private final int endY;

        public PathFinder(int endX, int endY) {
            this.endX = endX;
            this.endY = endY;
        }

        public int findShortestPath(int startX, int startY) {
            queueMove(startX, startY);

            int movesMade = 1;
            while (!queuedMoves.isEmpty()) {
                int levelBreadth = queuedMoves.size();
                while (levelBreadth-- > 0) {
                    Square pair = queuedMoves.poll();

                    int x = pair.x;
                    int y = pair.y;

                    if (
                            queueMove(x - 1,  y + 2)
                            || queueMove(x + 1, y + 2)
                            || queueMove(x + 2, y + 1)
                            || queueMove(x + 2, y - 1)
                            || queueMove(x + 1, y - 2)
                            || queueMove(x - 1, y - 2)
                            || queueMove(x - 2, y - 1)
                            || queueMove(x - 2, y + 1)
                    ) return movesMade;
                }

                ++movesMade;
            }

            throw new AssertionError("Did not find path.");
        }

        private boolean queueMove(int x, int y) {
            if (x >= 8 || x < 0 || y >= 8 || y < 0 || board[x][y]) return false;
            if (x == endX && y == endY) return true;

            queuedMoves.add(new Square(x, y));
            board[x][y] = true;
            return false;
        }

        private static class Square {
            public final int x;
            public final int y;

            public Square(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
    }
}
