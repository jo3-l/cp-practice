package ccc.ccc2006;

import java.util.*;

public class S2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String original = sc.nextLine();
        String encoded = sc.nextLine();
        Map<Character, Character> cipher = new HashMap<>();
        for (int i = 0; i < original.length(); i++) {
            cipher.put(encoded.charAt(i), original.charAt(i));
        }
        if (cipher.size() == 26) {
            // missing one; we can always determine the last one.
            Set<Character> usedKeys = cipher.keySet();
            Set<Character> usedVals = new HashSet<>(cipher.values());
            char missingKey = ' ';
            char missingVal = ' ';
            for (char c = 'A'; c <= 'Z'; c++) {
                if (!usedKeys.contains(c)) missingKey = c;
                if (!usedVals.contains(c)) missingVal = c;
            }
            cipher.put(missingKey, missingVal);
        }

        String subject = sc.nextLine();
        char[] dec = new char[subject.length()];
        for (int i = 0; i < subject.length(); i++) {
            dec[i] = cipher.getOrDefault(subject.charAt(i), '.');
        }
        System.out.println(dec);
    }
}
