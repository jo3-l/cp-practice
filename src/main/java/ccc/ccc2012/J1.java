package ccc.ccc2012;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the speed limit: ");
        int speedLimit = scanner.nextInt();
        System.out.print("Enter the recorded speed of the car: ");
        int recordedSpeed = scanner.nextInt();

        if (recordedSpeed <= speedLimit) System.out.println("Congratulations, you are within the speed limit!");
        else if (recordedSpeed <= speedLimit + 20) System.out.println("You are speeding and your fine is $100.");
        else if (recordedSpeed <= speedLimit + 30) System.out.println("You are speeding and your fine is $270.");
        else System.out.println("You are speeding and your fine is $500.");
    }
}
