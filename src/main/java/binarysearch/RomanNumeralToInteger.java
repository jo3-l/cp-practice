package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralToInteger {
    public int solve(String numeral) {
        Map<Character, Integer> symbols = new HashMap<>();
        symbols.put('I', 1);
        symbols.put('V', 5);
        symbols.put('X', 10);
        symbols.put('L', 50);
        symbols.put('C', 100);
        symbols.put('D', 500);
        symbols.put('M', 1000);

        char[][] specialCases = {
                {'I', 'V'},
                {'I', 'X'},
                {'X', 'L'},
                {'X', 'C'},
                {'C', 'D'},
                {'C', 'M'},
        };

        int result = 0;
        for (int i = 0, j = 1; i < numeral.length(); i++, j++) {
            char c0 = numeral.charAt(i);
            int v0 = symbols.get(c0);;
            if (j == numeral.length()) {
                result += v0;
                continue;
            }
            char c1 = numeral.charAt(j);
            int v1 = symbols.get(c1);

            // check if this combo is special
            int z;
            for (z = 0; z < specialCases.length; z++) {
                char[] pair = specialCases[z];
                if (pair[0] == c0 && pair[1] == c1) break;
            }

            if (z != specialCases.length) {
                // special one
                result += v1 - v0;
                i++;
                j++;
            } else {
                result += v0;
            }
        }
        return result;
    }
}
