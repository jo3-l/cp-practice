package ccc.ccc2020;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int smallTreats = scanner.nextInt();
        int mediumTreats = scanner.nextInt();
        int largeTreats = scanner.nextInt();

        int score = smallTreats + 2 * mediumTreats + 3 * largeTreats;
        System.out.println(score >= 10 ? "happy" : "sad");
    }
}
