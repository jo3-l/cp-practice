package binarysearch;

public class GrammarRules {
    public int solve(int n) {
        final int MOD = (int) 1e9 + 7;
        long na = 0, a = 1,
                ne = 0, e = 1,
                ni = 0, i = 1,
                no = 0, o = 1,
                nu = 0, u = 1;
        for (int j = 2; j <= n; j++) {
            na = e + i + u;
            ne = a + i;
            ni = o + e;
            no = i;
            nu = o + i;
            a = na % MOD;
            e = ne % MOD;
            i = ni % MOD;
            o = no % MOD;
            u = nu % MOD;
        }
        return (int) ((a + e + i + o + u) % MOD);
    }
}
