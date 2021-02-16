package ccc2018;

import java.util.Scanner;

// Drawing a quick visualization allows solving this question quite easily:
//
// 1 2 3 (0 degree turn)       7 4 1 (90 degree turn)
// 4 5 6                       8 5 2
// 7 8 9                       9 6 3
//
// 9 8 7 (180 degree turn)     3 6 9 (270 degree turn)
// 6 5 4                       2 5 8
// 3 2 1                       1 5 8
//
// Looking carefully, we can see that the sort order of the top edge and the leftmost edge can determine the angle it
// was rotated. For example, if the top edge is sorted in ascending order and the leftmost edge is also sorted in
// ascending order, only the 0 degree turn fits this criteria. If the top edge is sorted in ascending order and the
// leftmost edge is sorted in descending order, only the 270 degree turn fits this criteria, and so on.
//
// This applies to all tables, not just the contrived example above: if we read the question specification carefully,
// we can see that all assumptions we make for this specific example hold for all possible tables meeting the criteria
// given. For example, the top edge of the original table must be sorted, the leftmost edge must be sorted, etc.
public class J4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tableSize = scanner.nextInt();
        int[][] table = new int[tableSize][tableSize];

        scanner.skip("\n");
        for (int i = 0; i < tableSize; i++) {
            int[] row = table[i];
            for (int j = 0; j < tableSize; j++) row[j] = scanner.nextInt();
        }

        SortOrder firstRowOrder = inferSortOrder(table[0][0], table[0][1]);
        SortOrder firstColumnOrder = inferSortOrder(table[0][0], table[1][0]);
        if (firstRowOrder == SortOrder.ASC) {
            // If the first row is ascending, then it was either not rotated (0 degrees) or rotated 270 degrees.
            // If it was not rotated, then the first column should also be ascending.
            // If it was rotated 270 degrees, the first column should be descending.
            if (firstColumnOrder == SortOrder.ASC) System.out.println(displayOriginalTable(table, tableSize, 0));
            else System.out.println(displayOriginalTable(table, tableSize, 270));
            return;
        }

        // If the sort order for the first row was descending, then the table was rotated either 90 or 180 degrees.
        // Again, check the first column. If the first column was ascending, then it was rotated 90 degrees. Otherwise, it was rotated 180 degrees.
        if (firstColumnOrder == SortOrder.ASC) System.out.println(displayOriginalTable(table, tableSize, 90));
        else System.out.println(displayOriginalTable(table, tableSize, 180));
    }

    // degreesRotated is the degrees the original table was rotated to obtain the input table in the clockwise direction.
    private static String displayOriginalTable(int[][] table, int tableSize, int degreesRotated) {
        StringBuilder sb = new StringBuilder();
        switch (degreesRotated) {
            case 0:
                // No difference, print as is.
                for (int i = 0; i < tableSize; i++) {
                    if (i != 0) sb.append("\n");
                    int[] row = table[i];
                    for (int j = 0; j < tableSize; j++) {
                        if (j != 0) sb.append(" ");
                        sb.append(row[j]);
                    }
                }
                return sb.toString();
            case 90:
                // 1 2 3          3 6 9
                // 4 5 6  becomes 2 5 8
                // 7 8 9          1 4 7
                //
                // The 3rd column has become the 1st row, 2nd column 2nd row, 1st column 3rd row.
                for (int i = tableSize - 1; i >= 0; i--) {
                    if (i != tableSize - 1) sb.append("\n");
                    for (int j = 0; j < tableSize; j++) {
                        if (j != 0) sb.append(" ");
                        sb.append(table[j][i]);
                    }
                }
                return sb.toString();
            case 180:
                // 1 2 3         9 8 7
                // 4 5 6 becomes 6 5 4
                // 7 8 9         3 2 1
                //
                // Reversed 3rd column becomes 1st column, reversed 2nd column becomes 1st column, etc.
                for (int i = tableSize - 1; i >= 0; i--) {
                    if (i != tableSize - 1) sb.append("\n");
                    int[] row = table[i];
                    for (int j = tableSize - 1; j >= 0; j--) {
                        if (j != tableSize - 1) sb.append(" ");
                        sb.append(row[j]);
                    }
                }
                return sb.toString();
            case 270:
                // 1 2 3         7 4 1
                // 4 5 6 becomes 8 5 2
                // 7 8 9         9 6 3
                //
                // The 1st column has become the 1st row, 2nd column 2nd row, 1st column 3rd row.
                for (int i = 0; i < tableSize; i++) {
                    if (i != 0) sb.append("\n");
                    for (int j = tableSize - 1; j >= 0; j--) {
                        if (j != tableSize - 1) sb.append(" ");
                        sb.append(table[j][i]);
                    }
                }
                return sb.toString();
            default:
                throw new IllegalArgumentException("The number provided as the degrees rotated was invalid.");
        }
    }

    // inferSortOrder attempts to infer the order two integers are sorted in, throwing a runtime error if it cannot.
    private static SortOrder inferSortOrder(int first, int second) {
        if (first > second) return SortOrder.DSC;
        if (first < second) return SortOrder.ASC;
        throw new Error("Could not determine the sort order as the first element was equal to the second element.");
    }

    private enum SortOrder {
        ASC,
        DSC,
    }
}
