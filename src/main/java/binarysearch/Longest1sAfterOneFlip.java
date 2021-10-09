package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class Longest1sAfterOneFlip {
    public int solve(String s) {
        if (s.length() < 2) return s.length();
        List<Group> groups = getOnes(s);
        int res = 1; // can always flip one
        for (int i = 0; i < groups.size(); i++) {
            Group g = groups.get(i);
            int len = g.end - g.start;
            if (i == 0) {
                res = Math.max(res, g.start >= 1
                        ? len + 1 // one zero at the start we can flip
                        : g.end == s.length()
                        ? len
                        : len + 1);
            } else {
                Group pg = groups.get(i - 1);
                // one zero between the two groups
                if (pg.end == g.start - 1) res = Math.max(res, g.end - pg.start);
                    // one zero before the group we can flip
                else res = Math.max(res, len + 1);
            }

            if (i == groups.size() - 1 && g.end == s.length() - 1) {
                res = Math.max(res, len + 1); // flip last
            }
        }
        return res;
    }

    private List<Group> getOnes(String s) {
        List<Group> groups = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int start = i;
            if (s.charAt(i++) == '0') continue;
            while (i < s.length() && s.charAt(i) == '1') i++;
            groups.add(new Group(start, i));
        }

        return groups;
    }

    private static class Group {
        public int start; // inclusive
        public int end; // exclusive

        public Group(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
