package ccc.ccc2005;

import java.util.Scanner;

public class S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            String s = sc.next();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length() && sb.length() < 10; i++) {
                char c = s.charAt(i);
                if ((c < '0' || c > '9') && (c < 'A' || c > 'Z')) continue;
                if (c <= '9') sb.append(c);
                else if (c <= 'C') sb.append(2);
                else if (c <= 'F') sb.append(3);
                else if (c <= 'I') sb.append(4);
                else if (c <= 'L') sb.append(5);
                else if (c <= 'O') sb.append(6);
                else if (c <= 'S') sb.append(7);
                else if (c <= 'V') sb.append(8);
                else sb.append(9);
            }
            sb.insert(3, '-');
            sb.insert(7, '-');
            System.out.println(sb);
        }
    }
}
