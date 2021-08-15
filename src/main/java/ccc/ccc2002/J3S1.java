package ccc.ccc2002;

import java.util.Scanner;

public class J3S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int g = sc.nextInt();
        int r = sc.nextInt();
        int o = sc.nextInt();
        int target = sc.nextInt();
        int n = 0;
        int min = Integer.MAX_VALUE;
        for (int pc = 0; pc * p <= target; pc++) {
            for (int gc = 0; gc * g <= target; gc++) {
                for (int rc = 0; rc * r <= target; rc++) {
                    for (int oc = 0; oc * o <= target; oc++) {
                        if (pc * p + gc * g + rc * r + oc * o == target) {
                            n++;
                            System.out.println("# of PINK is " + pc + " # of GREEN is " + gc + " # of RED is " + rc + " # of ORANGE is " + oc);
                            min = Math.min(min, pc + gc + rc + oc);
                        }
                    }
                }
            }
        }
        System.out.println("Total combinations is " + n + ".");
        System.out.println("Minimum number of tickets to print is " + (min == Integer.MAX_VALUE ? 0 : min) + ".");
    }
}
