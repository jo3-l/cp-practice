package ccc2021;

import java.util.Scanner;

public class J3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lastDirection = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("99999")) return;

            int firstDigit = Integer.parseInt(line.substring(0, 1));
            int secondDigit = Integer.parseInt(line.substring(1, 2));
            String rest = line.substring(2);

            int sum = firstDigit + secondDigit;

            String direction;
            if (sum == 0) direction = lastDirection;
            else if (sum % 2 == 0) direction = "right";
            else direction = "left";

            System.out.println(direction + " " + rest);
            lastDirection = direction;
        }
    }
}
