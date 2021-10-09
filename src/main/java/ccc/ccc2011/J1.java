package ccc.ccc2011;

import java.util.Scanner;

public class J1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many antennas?");
        int antennas = scanner.nextInt();
        System.out.println("How many eyes?");
        int eyes = scanner.nextInt();

        if (antennas >= 3 && eyes <= 4) System.out.println("TroyMartian");
        if (antennas <= 6 && eyes >= 2) System.out.println("VladSaturnian");
        if (antennas <= 2 && eyes <= 3) System.out.println("GraemeMercurian");
    }
}