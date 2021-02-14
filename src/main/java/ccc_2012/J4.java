package ccc_2012;

import java.util.Scanner;

public class J4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = scanner.nextInt();
        scanner.skip("\n");
        String encoded = scanner.nextLine();

        StringBuilder decoded = new StringBuilder();
        for (int i = 0; i < encoded.length(); i++) {
            char c = encoded.charAt(i);
            int position = i + 1;
            int shiftedBy = 3 * position + key;

            int originalCharacter = c - (shiftedBy % 26);
            if (originalCharacter < 'A') originalCharacter += 26;

            decoded.append((char) originalCharacter);
        }

        System.out.println(decoded.toString());
    }
}
