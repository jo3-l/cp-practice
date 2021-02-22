package ccc2019;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = scanner.nextInt();
        scanner.skip("\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numLines; i++) {
            if (i != 0) sb.append("\n");
            String[] parts = scanner.nextLine().split(" ");
            int count = Integer.parseInt(parts[0]);
            String charToRepeat = parts[1];

            for (int j = 0; j < count; j++) sb.append(charToRepeat);
        }

        System.out.println(sb.toString());
    }
}
