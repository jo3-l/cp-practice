package kattis;

import java.util.Scanner;

public class SodaSlurper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initial = scanner.nextInt();
        int found = scanner.nextInt();
        int cost = scanner.nextInt();

        int total = 0;
        int emptyBottles = initial + found;
        while (emptyBottles >= cost) {
            int canPurchase = emptyBottles / cost;
            total += canPurchase;
            emptyBottles = canPurchase + (emptyBottles % cost);
        }

        System.out.println(total);
    }
}
