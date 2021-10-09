package ccc.ccc2005;

import java.text.DecimalFormat;
import java.util.Scanner;

public class J1 {
    private static final DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dm = sc.nextInt();
        int em = sc.nextInt();
        int wm = sc.nextInt();

        int acents = (Math.max(0, dm - 100) * 25) + (15 * em) + (20 * wm);
        int bcents = (Math.max(0, dm - 250) * 45) + (35 * em) + (25 * wm);

        System.out.println("Plan A costs " + df.format((double) acents / 100));
        System.out.println("Plan B costs " + df.format((double) bcents / 100));
        if (acents < bcents) System.out.println("Plan A is cheapest.");
        else if (acents == bcents) System.out.println("Plan A and B are the same price.");
        else System.out.println("Plan B is cheapest.");
    }
}
