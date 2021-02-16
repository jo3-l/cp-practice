package ccc2015;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int happyFaces = 0;
        int sadFaces = 0;

        int i = 0;
        // :-) and :-( are both three characters, thus, we do not need to check the last 3 characters.
        while (i < input.length() - 2) {
            if (input.startsWith(":-", i)) {
                char c = input.charAt(i + 2);
                if (c == ')') {
                    ++happyFaces;
                    i += 3;
                } else if (c == '(') {
                    ++sadFaces;
                    i += 3;
                } else {
                    // We already know the next 2 characters are ':' and '-' and that the 3rd character isn't a ')' or '('
                    // so we can skip over ':' and '-'.
                    i += 2;
                }
            } else {
                ++i;
            }
        }

        if (happyFaces > sadFaces) System.out.println("happy");
        else if (happyFaces == sadFaces) System.out.println(happyFaces == 0 ? "none" : "unsure");
        else System.out.println("sad");
    }
}
