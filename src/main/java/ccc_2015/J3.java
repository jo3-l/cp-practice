package ccc_2015;

import java.util.Arrays;
import java.util.Scanner;

public class J3 {
    private static final char[][] consonantTranslationCache = new char[26][3];
    private static final char[] consonants = "bcdfghjklmnpqrstvwxyz".toCharArray();
    private static final char[] vowels = "aeiou".toCharArray();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        StringBuilder translated = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (isConsonant(c)) {
                for (char _c : translateConsonant(c)) translated.append(_c);
            } else {
                translated.append(c);
            }
        }

        System.out.println(translated.toString());
    }

    private static char[] translateConsonant(char consonant) {
        int consonantAlphabetIndex = consonant - 'a';

        char[] cachedSequence = consonantTranslationCache[consonantAlphabetIndex];
        if (cachedSequence[0] == '\u0000') {
            cachedSequence[0] = consonant; // First letter is the character itself.

            int minDistance = Integer.MAX_VALUE;
            char closestVowel = 0;
            for (char vowel : vowels) {
                int vowelAlphabetIndex = vowel - 'a';
                int distance = Math.abs(vowelAlphabetIndex - consonantAlphabetIndex);
                if (distance < minDistance) {
                    closestVowel = vowel;
                    minDistance = distance;
                }
            }
            cachedSequence[1] = closestVowel;
            cachedSequence[2] = consonant == 'z' ? 'z' : consonants[Arrays.binarySearch(consonants, consonant) + 1];
        }

        return cachedSequence;
    }

    private static boolean isConsonant(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return false;
            default:
                return true;
        }
    }
}
