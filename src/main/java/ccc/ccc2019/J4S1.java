package ccc.ccc2019;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J4S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int verticalFlips = 0;
        int horizontalFlips = 0;

        String line = scanner.nextLine();
        for (int i = 0; i < line.length(); i++) {
            int c = line.charAt(i);
            if (c == 'H') ++horizontalFlips;
            else ++verticalFlips;
        }

        List<List<String>> matrix = Arrays.asList(Arrays.asList("1", "2"), Arrays.asList("3", "4"));

        if (horizontalFlips % 2 != 0) Collections.reverse(matrix);
        if (verticalFlips % 2 != 0) {
            Collections.reverse(matrix.get(0));
            Collections.reverse(matrix.get(1));
        }

        System.out.println(String.join(" ", matrix.get(0)) + "\n" + String.join(" ", matrix.get(1)));
    }
}
