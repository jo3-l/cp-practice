package ccc.ccc2012;

import java.util.Scanner;

public class S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int J = sc.nextInt();
        if (J < 4) {
            System.out.println(0);
            return;
        }

        // J-1 choose 3
        System.out.println(((J - 1) * (J - 2) * (J - 3)) / 6);
    }
}
