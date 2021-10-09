package ccc.ccc2009;

import java.util.*;

public class S2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int l = sc.nextInt();
        int[] ls = new int[r + 1];
        for (int i = r; i >= 1; i--) {
            for (int j = 0; j < l; j++) if (sc.nextInt() == 1) ls[i] |= 1 << j;
        }

        Set<Integer> last = new HashSet<>();
        last.add(ls[r]);
        Set<Integer> cur = new HashSet<>();
        for (int p = r - 1; p >= 1; p--) {
            cur.add(ls[p]); // don't click anything
            for (int x : last) {
                cur.add(x ^ ls[p]); // xor with prev
            }
            last = new HashSet<>(cur);
            cur.clear();
        }
        System.out.println(last.size());
    }
}
