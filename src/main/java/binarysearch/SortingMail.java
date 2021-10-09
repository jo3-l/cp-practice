package binarysearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SortingMail {
    public String[] solve(String[][] mailboxes) {
        List<String> res = new ArrayList<>();
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < mailboxes.length; i++) {
            if (mailboxes[i].length > 0) q.add(new int[]{i, 0});
        }
        while (!q.isEmpty()) {
            int[] elem = q.poll();
            String[] mb = mailboxes[elem[0]];
            String e = mb[elem[1]++];
            if (e.charAt(0) != 'j') res.add(e);
            if (elem[1] < mb.length) q.add(elem);
        }
        String[] ret = new String[res.size()];
        for (int i = 0; i < res.size(); i++) ret[i] = res.get(i);
        return ret;
    }
}
