package ccc.ccc2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int N = Integer.parseInt(parts[0]);
        int M = Integer.parseInt(parts[1]);
        // index = person number - 1, value = list of people this person is taller than
        @SuppressWarnings("unchecked")
        List<Integer>[] people = new ArrayList[N];
        while (M-- > 0) {
            String[] ps = br.readLine().split(" ");
            int x = Integer.parseInt(ps[0]) - 1; // 1-based -> 0-based
            int y = Integer.parseInt(ps[1]) - 1;
            if (people[x] == null) people[x] = new ArrayList<>();
            people[x].add(y);
        }

        String[] ps = br.readLine().split(" ");
        int p = Integer.parseInt(ps[0]) - 1;
        int q = Integer.parseInt(ps[1]) - 1;

        Queue<Integer> qu = new ArrayDeque<>();
        Set<Integer> seen = new HashSet<>();
        qu.add(p);
        seen.add(p);
        while (!qu.isEmpty()) {
            int pp = qu.poll();
            List<Integer> ppt = people[pp];
            if (ppt == null) continue;
            if (ppt.contains(q)) {
                System.out.println("yes");
                return;
            }
            for (int v : ppt) {
                if (seen.add(v)) qu.add(v);
            }
        }

        qu.clear();
        qu.add(q);
        seen.clear();
        seen.add(q);
        while (!qu.isEmpty()) {
            int pp = qu.poll();
            List<Integer> ppt = people[pp];
            if (ppt == null) continue;
            if (ppt.contains(p)) {
                System.out.println("no");
                return;
            }
            for (int v : ppt) {
                if (seen.add(v)) qu.add(v);
            }
        }
        System.out.println("unknown");
    }
}
