package ccc.ccc2004;

import java.util.Scanner;

public class S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        outer: for (int i = 0; i < N; i++) {
            String[] col = new String[3];
            for (int j = 0; j < 3; j++) {
                col[j] = sc.next();
            }
            for (int j = 0; j < 3; j++) {
                for (int z = 0; z < 3; z++) {
                    if (j == z) continue;
                    if (col[j].startsWith(col[z])
                            || col[z].startsWith(col[j])
                            || col[j].endsWith(col[z])
                            || col[z].endsWith(col[j])) {
                        System.out.println("No");
                        continue outer;
                    }
                }
            }
            System.out.println("Yes");
        }
    }
}
