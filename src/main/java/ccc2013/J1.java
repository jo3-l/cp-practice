package ccc2013;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstChildAge = scanner.nextInt();
        int secondChildAge = scanner.nextInt();
        System.out.println(secondChildAge + (secondChildAge - firstChildAge));
    }
}
