package ccc2012;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        if (a == b && b == c && c == d) System.out.println("Fish At Constant Depth");
        else if (a < b && b < c && c < d) System.out.println("Fish Rising");
        else if (a > b && b > c && c > d) System.out.println("Fish Diving");
        else System.out.println("No Fish");
    }
}
