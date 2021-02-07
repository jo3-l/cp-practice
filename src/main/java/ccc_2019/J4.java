package ccc_2019;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class J4 {
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
        // 2 horizontal flips result in no change, so do 2 vertical flips. As such, we only need to modify the matrix
        // if the number of flips was an odd number.
        if ((horizontalFlips & 1) != 0) Collections.reverse(matrix);
        if ((verticalFlips & 1) != 0) {
            Collections.reverse(matrix.get(0));
            Collections.reverse(matrix.get(1));
        }

        System.out.println(String.join(" ", matrix.get(0)) + "\n" + String.join(" ", matrix.get(1)));
    }
}
