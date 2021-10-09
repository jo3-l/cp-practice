package ccc.ccc2006;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J4 {
    public static void main(String[] args) {
        List<int[]> constraints = new ArrayList<>();
        constraints.add(new int[]{1, 7});
        constraints.add(new int[]{1, 4});
        constraints.add(new int[]{2, 1});
        constraints.add(new int[]{3, 4});
        constraints.add(new int[]{3, 5});
        int hasConstraint = (1 << 1) | (1 << 4) | (1 << 5) | (1 << 7);

        Scanner sc = new Scanner(System.in);
        for (int i = sc.nextInt(), j = sc.nextInt(); i != j; i = sc.nextInt(), j = sc.nextInt()) {
            constraints.add(new int[]{i, j});
            hasConstraint |= 1 << j;
        }

        int[] order = new int[7];
        int j = 0;
        int done = 0;
        outer:
        while (done != 0b01111111) {
            for (int t = 1; t <= 7; t++) {
                if ((done & (1 << t)) != 0) continue;
                if ((hasConstraint & (1 << t)) == 0) {
                    order[j++] = t;
                    done |= 1 << t;

                    int finalT = t;
                    constraints.removeIf(v -> v[0] == finalT);
                    hasConstraint = 0;
                    for (int[] constraint : constraints) hasConstraint |= 1 << constraint[1];
                    continue outer;
                }
            }
            break;
        }
        if (j != 7) {
            System.out.println("Cannot complete these tasks. Going to bed.");
        } else {
            for (int i = 0; i < order.length; i++) {
                if (i > 0) System.out.print(' ');
                System.out.print(order[i]);
            }
        }
    }
}
