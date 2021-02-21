package ccc2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class J5 {
    private static final int END_ROOM_TOKEN = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rowCount = Integer.parseInt(reader.readLine());
        int columnCount = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[rowCount][columnCount];
        StringBuilder buffer = new StringBuilder();

        for (int rowNumber = 0; rowNumber < rowCount; rowNumber++) {
            int[] row = matrix[rowNumber];
            for (int columnNumber = 0; columnNumber < columnCount; columnNumber++) {
                for (int c = reader.read(); c != ' ' && c != '\n' && c != -1; c = reader.read()) {
                    buffer.append((char) c);
                }
                row[columnNumber] = Integer.parseInt(buffer.toString());
                buffer.setLength(0);
            }
        }

        matrix[rowCount - 1][columnCount - 1] = END_ROOM_TOKEN;

        PathFinder finder = new PathFinder();
        System.out.println(finder.canReachEnd(matrix, rowCount, columnCount) ? "yes" : "no");
    }

    private static class PathFinder {
        private final Queue<Integer> queuedValues = new LinkedList<>();
        private final Set<Integer> visitedValues = new HashSet<>();

        public boolean canReachEnd(int[][] matrix, int rowCount, int columnCount) {
            reset();

            int initialValue = matrix[0][0];
            queuedValues.add(initialValue);
            visitedValues.add(initialValue);

            while (!queuedValues.isEmpty()) {
                int value = queuedValues.poll();

                int lowerBound = (int) Math.ceil((float) value / Math.max(rowCount, columnCount));
                for (int row = lowerBound; row <= rowCount; row++) {
                    if (value % row != 0) continue;
                    int column = value / row;
                    if (column > columnCount) continue;
                    if (tryMove(matrix[row - 1][column - 1])) return true;

                    if (row != column && column <= rowCount && row <= columnCount) {
                        if (tryMove(matrix[column - 1][row - 1])) return true;
                    }
                }
            }

            return false;
        }

        private boolean tryMove(int value) {
            if (value == END_ROOM_TOKEN) return true;
            if (visitedValues.contains(value)) return false;

            visitedValues.add(value);
            queuedValues.add(value);
            return false;
        }

        private void reset() {
            queuedValues.clear();
            visitedValues.clear();
        }
    }
}
