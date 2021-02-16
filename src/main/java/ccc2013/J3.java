package ccc2013;

import java.util.Scanner;
import java.util.BitSet;

public class J3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startYear = scanner.nextInt();

        int year = startYear + 1;
        while (!hasDistinctDigits(year)) ++year;

        System.out.println(year);
    }

    private static boolean hasDistinctDigits(int year) {
        String str = Integer.toString(year);

        BitSet seenChars = new BitSet();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (seenChars.get(c)) return false;
            else seenChars.set(c);
        }
        return true;
    }
}
