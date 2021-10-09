package ccc.ccc2009;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int trout = sc.nextInt();
        int pike =  sc.nextInt();
        int pick = sc.nextInt();
        int total = sc.nextInt();
        int i = 0;
        for (int tr = 0; tr <= total / trout; tr++) {
            for (int pr = 0; pr <= total / pike; pr++) {
                for (int ppr = 0; ppr <= total / pick; ppr++) {
                    if (tr == 0 && pr == 0 && ppr == 0) continue;
                    int tt = tr * trout + pr * pike + ppr * pick;
                    if (tt > total) continue;
                    System.out.println(tr + " Brown Trout, " + pr + " Northern Pike, " + ppr + " Yellow Pickerel");
                    i++;
                }
            }
        }
        System.out.println("Number of ways to catch fish: " + i);
    }
}
