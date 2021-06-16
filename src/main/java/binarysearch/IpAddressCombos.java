package binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IpAddressCombos {
    private List<Ip> ret = new ArrayList<>();

    public String[] solve(String seq) {
        ret.add(new Ip());
        while (go(seq));
        return ret.stream()
                .filter(v -> v.idx == seq.length())
                .filter(v -> v.numCount == 4)
                .map(v -> v.ip.toString())
                .toArray(String[]::new);
    }

    private boolean go(String seq) {
        List<Ip> gen = new ArrayList<>();

        boolean foundNew = false;
        for (Ip ip : ret) {
            if (ip.numCount == 4) {
                gen.add(ip);
                continue;
            }

            List<Integer> ns = next(seq, ip.idx);
            for (int ipPart : ns) {
                foundNew = true;

                Ip clone = new Ip();
                clone.numCount = ip.numCount + 1;
                clone.ip.append(ip.ip);
                if (ip.numCount > 0) clone.ip.append('.');
                clone.ip.append(ipPart);
                clone.idx = ip.idx + Integer.toString(ipPart).length();
                gen.add(clone);
            }
        }

        ret = gen;
        return foundNew;
    }

    private List<Integer> next(String seq, int i) {
        if (i < seq.length() && seq.charAt(i) == '0') return new ArrayList<>(Collections.singletonList(0));

        List<Integer> ret = new ArrayList<>();
        StringBuilder buf = new StringBuilder();
        for (int j = i; j < i + 3 && j < seq.length(); j++) {
            buf.append(seq.charAt(j));
            int v = Integer.parseInt(buf.toString());
            if (v <= 255) {
                ret.add(v);
            }
        }

        return ret;
    }

    private static class Ip {
        public int numCount;
        public StringBuilder ip = new StringBuilder();
        public int idx;
    }
}
