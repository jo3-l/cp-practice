package ccc2016;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[4][4];
        int firstRowTotal = -1;
        for (int i = 0; i < 4; i++) {
            int rowTotal = 0;
            for (int j = 0; j < 4; j++) {
                int v = scanner.nextInt();
                rowTotal += v;
                matrix[i][j] = v;
            }
            if (firstRowTotal == -1) firstRowTotal = rowTotal;
            else if (rowTotal != firstRowTotal) {
                System.out.println("not magic");
                return;
            }
            scanner.skip("\n");
        }

        int firstColumnTotal = -1;
        // Check columns
        for (int i = 0; i < 4; i++) {
            int columnTotal = 0;
            for (int j = 0; j < 4; j++) columnTotal += matrix[j][i];
            if (firstColumnTotal == -1) firstColumnTotal = columnTotal;
            else if (columnTotal != firstColumnTotal) {
                System.out.println("not magic");
                return;
            }
        }

        System.out.println("magic");
    }
}
