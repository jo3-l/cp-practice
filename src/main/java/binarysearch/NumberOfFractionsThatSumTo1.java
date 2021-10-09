package binarysearch;

import java.util.*;

public class NumberOfFractionsThatSumTo1 {
    public int solve(int[][] fractions) {
        Map<Fraction, Integer> fs = new HashMap<>();
        for (int[] fraction : fractions) {
            int d = gcd(fraction[0], fraction[1]);
            if (d != 1) {
                fraction[0] /= d;
                fraction[1] /= d;
            }
            fs.merge(new Fraction(fraction[0], fraction[1]), 1, Integer::sum);
        }

        int ctr = 0;
        Set<Fraction> seen = new HashSet<>();
        for (Map.Entry<Fraction, Integer> e : fs.entrySet()) {
            Fraction cur = e.getKey();
            if (seen.contains(cur)) continue;
            Fraction other = new Fraction(cur.denom - cur.numer, cur.denom);
            int oc = fs.getOrDefault(other, 0);
            if (oc == 0) continue;
            if (other.equals(cur)) {
                ctr += oc * (oc - 1) / 2;
            } else {
                ctr += e.getValue() * oc;
                seen.add(other);
            }

            seen.add(cur);
        }

        return ctr;
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    private static class Fraction {
        public int numer;
        public int denom;

        public Fraction(int numer, int denom) {
            this.numer = numer;
            this.denom = denom;
        }

        @Override
        public int hashCode() {
            return Objects.hash(numer, denom);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Fraction)) return false;
            Fraction f = (Fraction) obj;
            return f.numer == numer && f.denom == denom;
        }
    }
}
