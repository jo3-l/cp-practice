package ccc_2014;

import java.util.Scanner;

public class J3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rounds = scanner.nextInt();
        scanner.skip("\n");

        int antoniaScore = 100;
        int davidScore = 100;
        for (int i = 0; i < rounds; i++) {
            String[] parts = scanner.nextLine().split(" ");
            int antoniaRoll = Integer.parseInt(parts[0]);
            int davidRoll = Integer.parseInt(parts[1]);

            if (antoniaRoll > davidRoll) davidScore -= antoniaRoll;
            else if (antoniaRoll < davidRoll) antoniaScore -= davidRoll;
        }

        System.out.println(antoniaScore + "\n" + davidScore);
    }
}
