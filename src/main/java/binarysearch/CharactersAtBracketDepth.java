package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class CharactersAtBracketDepth {
    public int[] solve(String s) {
        List<Integer> vals = new ArrayList<>();
        int depth = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                depth++;
                if (vals.size() <= depth) {
                    vals.add(0);
                }
            } else if (c == ')') {
                depth--;
            } else {
                vals.set(depth, vals.get(depth) + 1);
            }
        }

        int[] res = new int[vals.size()];
        for (int i = 0; i < vals.size(); i++) res[i] = vals.get(i);
        return res;
    }
}
