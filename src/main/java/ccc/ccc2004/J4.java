package ccc.ccc2004;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String kw = sc.nextLine();
        String inp = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inp.length(); i++) {
            char c = inp.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            sb.append(c);
        }
        List<List<Character>> buckets = new ArrayList<>(kw.length());
        for (int i = 0; i < kw.length(); i++) buckets.add(new ArrayList<>());
        int kwn = 0;
        int maxlen = 0;
        for (int i = 0; i < sb.length(); i++) {
            int n = kwn++;
            int offset = kw.charAt(n) - 'A';
            char nc = (char) (sb.charAt(i) + offset);
            if (nc > 'Z') nc -= 26;
            buckets.get(n).add(nc);
            maxlen = Math.max(maxlen, buckets.get(n).size());
            if (kwn == kw.length()) kwn = 0;
        }
        StringBuilder sbb = new StringBuilder();
        for (int i = 0; i < maxlen; i++) {
            for (List<Character> lc : buckets) {
                if (i < lc.size()) sbb.append(lc.get(i));
            }
        }
        System.out.println(sbb);
    }
}
