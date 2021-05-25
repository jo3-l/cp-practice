package ccc.ccc2012;

import java.util.Scanner;

public class J3 {
    private static final char[][] INITIAL_GRID = {
            {'*', 'x', '*'},
            {' ', 'x', 'x'},
            {'*', ' ', '*'},
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scalingFactor = scanner.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3 * scalingFactor; i++) {
            if (i != 0) sb.append("\n");
            for (int j = 0; j < 3 * scalingFactor; j++) {
                char c = INITIAL_GRID[i / scalingFactor][j / scalingFactor];
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
