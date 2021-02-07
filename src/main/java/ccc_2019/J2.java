package ccc_2019;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = scanner.nextInt();
        scanner.skip("\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numLines; i++) {
            // Only append a leading newline if this isn't the first iteration.
            if (i != 0) sb.append("\n");
            // Format is "<times to repeat> <character to repeat>".
            String[] parts = scanner.nextLine().split(" ");
            int count = Integer.parseInt(parts[0]);
            String charToRepeat = parts[1];

            for (int j = 0; j < count; j++) sb.append(charToRepeat);
        }

        System.out.println(sb.toString());
    }
}
