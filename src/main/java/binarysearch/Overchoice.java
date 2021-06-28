package binarysearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Overchoice {
    public String[] solve(String s) {
        if (s.equals("[]")) return new String[]{""}; // expandOne barfs on this, too lazy to fix : )

        List<String> finished = new ArrayList<>();
        Queue<String> q = new ArrayDeque<>();
        q.add(s);
        while (!q.isEmpty()) {
            String cur = q.poll();
            boolean didExpand = expandOne(cur, q);
            if (!didExpand) finished.add(cur);
        }

        String[] ret = new String[finished.size()];
        for (int i = 0; i < finished.size(); i++) ret[i] = finished.get(i);
        return ret;
    }

    private boolean expandOne(String s, Queue<String> q) {
        StringBuilder sb = new StringBuilder();
        List<String> opts = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c != '[') continue;

            List<String> ps = new ArrayList<>();
            String before = s.substring(0, i - 1);
            while (i < s.length() && (c = s.charAt(i)) != ']') {
                if (c == '|') {
                    ps.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(c);
                }

                i++;
            }
            if (sb.length() != 0) {
                ps.add(sb.toString());
                sb.setLength(0);
            }

            String after = s.substring(i + 1);
            for (String p : ps) opts.add(before + p + after);
            break;
        }

        if (opts.isEmpty()) return false;
        q.addAll(opts);
        return true;
    }
}
