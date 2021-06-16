package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class ParenthesesGrouping {
    public String[] solve(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder buf = new StringBuilder();

        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            buf.append(c);
            switch (c) {
                case '(':
                    depth++;
                    break;
                case ')':
                    if (--depth == 0) {
                        res.add(buf.toString());
                        buf.setLength(0);
                    }
                    break;
            }
        }

        String[] vs = new String[res.size()];
        for (int i = 0; i < res.size(); i++) vs[i] = res.get(i);
        return vs;
    }
}
