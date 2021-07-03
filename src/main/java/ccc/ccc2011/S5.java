// the obvious, brute force solution. uses bit masks to speed things up a bit at a lower level.
// this works for 9/10 test cases (TLEs on the last one, which has 25 lights).
// still thinking about how a better solution could be constructed, but this will do for now.
package ccc.ccc2011;

import java.util.*;

public class S5 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int K = sc.nextInt();
        int b = 0;
        for (int i = 0; i < K; i++) if (sc.nextInt() == 1) b |= 1 << i;
        if (b == 0) {
            System.out.println("0");
            return;
        }
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> s = new HashSet<>();
        q.add(b);
        s.add(b);
        int step = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                int bb = q.poll();
                // find 0s and turn them on
                for (int i = 0; i < K; i++) {
                    int m = 1 << i;
                    if ((bb & m) == 0) {
                        int w = bb | m;
                        if (s.add(w)) {
                            int lo = i - 1;
                            while (lo >= 0 && (w & (1 << lo)) != 0) lo--;
                            lo++; // adjust for extra lo--

                            int hi = i + 1;
                            while (hi < K && (w & (1 << hi)) != 0) hi++;
                            hi--; // adjust for extra hi++

                            // do we have a sequence of >= 4 lights?
                            int seq = hi - lo + 1;
                            if (seq >= 4) {
                                w = clearBitsInRange(w, lo, hi);
                            }

                            if (w == 0) {
                                System.out.println(step);
                                return;
                            }

                            q.add(w);
                            s.add(w);
                        }
                    }
                }
            }
            step++;
        }
        System.out.println(-1);
    }

    private static int clearBitsInRange(int b, int lo, int hi) {
        int mask = (1 << (hi + 1)) - 1; // set 0...hi (inclusive)
        mask &= -(1 << lo); // unset 0..lo (exclusive)
        return b & ~mask; // apply mask
    }
}
