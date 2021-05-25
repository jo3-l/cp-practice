package ccc.ccc2021;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalBids = scanner.nextInt();
        scanner.skip("\n");

        String winner = "";
        int maxBid = -1;
        for (int i = 0; i < totalBids; i++) {
            String bidder = scanner.nextLine();
            int bid = scanner.nextInt();
            if (bid > maxBid) {
                maxBid = bid;
                winner = bidder;
            }

            scanner.skip("\n");
        }

        System.out.println(winner);
    }
}
