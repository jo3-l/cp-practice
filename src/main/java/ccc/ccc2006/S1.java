package ccc.ccc2006;

import java.util.Scanner;

public class S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String parent0 = sc.next();
        String parent1 = sc.next();
        int x = sc.nextInt();
        while (x-- > 0) {
            String child = sc.next();
            int i;
            for (i = 0; i < child.length(); i++) {
                char c = child.charAt(i);
                int pis = i << 1;
                char a0 = parent0.charAt(pis);
                char a1 = parent0.charAt(pis + 1);
                char b0 = parent1.charAt(pis);
                char b1 = parent1.charAt(pis + 1);
                if (uc(c)) {
                    if (lc(a0) && lc(a1) && lc(b0) && lc(b1)) break;
                } else {
                    if ((uc(a0) && uc(a1)) || (uc(b0) && uc(b1))) break;
                }
            }

            if (i != child.length()) System.out.println("Not their baby!");
            else System.out.println("Possible baby.");
        }
    }

    private static boolean lc(char c) {
        return Character.isLowerCase(c);
    }

    private static boolean uc(char c) {
        return Character.isUpperCase(c);
    }
}
