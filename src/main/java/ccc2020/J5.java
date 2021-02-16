package ccc2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class J5 {
    public static final int END_ROOM_TOKEN = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maxRows = Integer.parseInt(reader.readLine());
        int maxColumns = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[maxRows][maxColumns];
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < maxRows; i++) {
            int[] row = matrix[i];
            outer:
            for (int j = 0; j < maxColumns; j++) {
                while (true) {
                    int c = reader.read();
                    switch (c) {
                        case ' ':
                        case '\n':
                        case -1:
                            row[j] = Integer.parseInt(buffer.toString());
                            buffer.setLength(0);
                            continue outer;
                        default:
                            buffer.append((char) c);
                            break;
                    }
                }
            }
        }

        // Monkey-patch the end cell to use our special token so we can easily differentiate it.
        matrix[maxRows - 1][maxColumns - 1] = END_ROOM_TOKEN;
        PathFinder finder = new PathFinder(matrix[0][0], matrix, maxRows, maxColumns);
        System.out.println(finder.canEscape() ? "yes" : "no");
    }

    private static class PathFinder {
        private final int[][] matrix;
        private final int maxRows;
        private final int maxColumns;
        private final Queue<Integer> queuedValues = new LinkedList<>();
        private final Set<Integer> visitedValues = new HashSet<>();

        private PathFinder(int initialValue, int[][] matrix, int maxRows, int maxColumns) {
            this.matrix = matrix;
            this.maxRows = maxRows;
            this.maxColumns = maxColumns;

            queuedValues.add(initialValue);
        }

        // canEscape reports whether we can escape out of the room. It uses a breadth-first search internally.
        public boolean canEscape() {
            while (!queuedValues.isEmpty()) {
                int value = queuedValues.poll();

                // These lower and upper bounds ensure that we handle all possible values but not too many.
                // These can likely be tweaked further so we iterate over even less values, but in any case this solution
                // still gets full points, so it's whatever.
                int lowerBound = (int) Math.ceil((float) value / Math.max(maxRows, maxColumns));
                int upperBound = maxRows + 1;
                for (int possibleRow = lowerBound; possibleRow < upperBound; possibleRow++) {
                    // If the row isn't a divisor of the value, that means that there's no corresponding column, so we
                    // can simply skip over this one.
                    if (value % possibleRow != 0) continue;
                    int matchingColumn = value / possibleRow;
                    // Ignore if the column is out of range.
                    if (matchingColumn > maxColumns) continue;
                    if (queueMove(possibleRow - 1, matchingColumn - 1)) return true;

                    // Check if we can reverse the column and row values (5 * 2 = 10, but so is 2 * 5).
                    if (possibleRow != matchingColumn) {
                        // Ignore if either of the values are out of range.
                        if (matchingColumn > maxRows || possibleRow > maxColumns) continue;
                        if (queueMove(matchingColumn - 1, possibleRow - 1)) return true;
                    }
                }
            }

            return false;
        }

        // queueMove queues a move to the square at the given row and column. It returns whether the square was the end square.
        private boolean queueMove(int row, int column) {
            int value = matrix[row][column];
            if (value == END_ROOM_TOKEN) return true;
            // If we've already visited this value, no need to visit it again.
            if (visitedValues.contains(value)) return false;

            visitedValues.add(value);
            queuedValues.add(value);
            return false;
        }
    }
}
