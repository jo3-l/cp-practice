package kattis;

import java.util.Arrays;
import java.util.Scanner;

public class ABC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] xs = new int[3];
        for (int i = 0; i < 3; i++) xs[i] = scanner.nextInt();
        Arrays.sort(xs);

        scanner.skip("\n");
        String order = scanner.nextLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            if (i > 0) sb.append(" ");
            sb.append(xs[order.charAt(i) - 'A']);
        }

        System.out.println(sb.toString());
    }
}
