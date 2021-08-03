package ccc.ccc2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class S3 {
    public static void main(String[] args) throws IOException {
        final long P0 = 31;
        final long P1 = 71;
        final long P2 = 101;
        final int ALLEQ = (1<<26) - 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String needle = br.readLine();
        String haystack = br.readLine();
        if (haystack.length() < needle.length()) {
            System.out.println(0);
            return;
        }

        long p0pow = 1;
        long p1pow = 1;
        long p2pow = 1;
        long hshf = 0;
        long hshs = 0;
        long hsht = 0;
        int[] nfreq = new int[26];
        int[] wfreq = new int[26];
        for (int i = 0; i < needle.length(); i++) {
            hshf = hshf * P0 + haystack.charAt(i);
            hshs = hshs * P1 + haystack.charAt(i);
            hsht = hsht * P2 + haystack.charAt(i);
            ++nfreq[needle.charAt(i) - 'a'];
            ++wfreq[haystack.charAt(i) - 'a'];
            if (i > 0) {
                p0pow *= P0;
                p1pow *= P1;
                p2pow *= P2;
            }
        }

        int same = 0;
        for (int i = 0; i < 26; i++) if (nfreq[i] == wfreq[i]) same |= 1 << i;

        Set<Hset> seen = new HashSet<>();
        if (same == ALLEQ) seen.add(new Hset(hshf, hshs, hsht));

        for (int i = 1, j = needle.length(); j < haystack.length(); i++, j++) {
            hshf = (hshf - p0pow * haystack.charAt(i - 1)) * P0 + haystack.charAt(j);
            hshs = (hshs - p1pow * haystack.charAt(i - 1)) * P1 + haystack.charAt(j);
            hsht = (hsht - p2pow * haystack.charAt(i - 1)) * P2 + haystack.charAt(j);
            int cdel = haystack.charAt(i - 1) - 'a';
            int cadd = haystack.charAt(j) - 'a';
            int cdelb = 1 << cdel;
            int caddb = 1 << cadd;
            if (--wfreq[cdel] != nfreq[cdel]) same &= ~cdelb;
            else same |= cdelb;
            if (++wfreq[cadd] != nfreq[cadd]) same &= ~caddb;
            else same |= caddb;

            if (same == ALLEQ) seen.add(new Hset(hshf, hshs, hsht));
        }

        System.out.println(seen.size());
    }

    private static class Hset {
        public long f;
        public long s;
        public long t;

        public Hset(long f, long s, long t) {
            this.f = f;
            this.s = s;
            this.t = t;
        }

        @Override
        public int hashCode() {
            return Objects.hash(f, s);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Hset)) return false;
            Hset h = (Hset) obj;
            return h.f == f && h.s == s && h.t == t;
        }
    }
}
