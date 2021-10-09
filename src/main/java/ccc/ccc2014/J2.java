package ccc.ccc2014;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.skip("\\d+\\n");

        String line = scanner.nextLine();
        int aVotes = 0;
        int bVotes = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == 'A') ++aVotes;
            else ++bVotes;
        }

        if (aVotes > bVotes) System.out.println("A");
        else if (aVotes == bVotes) System.out.println("Tie");
        else System.out.println("B");
    }
}
