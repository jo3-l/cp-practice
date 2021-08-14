package ccc.ccc2003;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// TLEs on tc #6 and #8
public class S4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.skip("\n");
        while (n-- > 0) System.out.println(solve(sc.nextLine()));
    }

    private static int solve(String s) {
        int rs = 1;
        TrieNode r = new TrieNode();
        for (int i = 0; i < s.length(); i++) {
            TrieNode cur = r;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                TrieNode n = cur.child.get(c);
                if (n == null) {
                    cur.child.put(c, n = new TrieNode());
                    rs++;
                }
                cur = n;
            }
        }
        return rs;
    }

    private static class TrieNode {
        public Map<Character, TrieNode> child = new HashMap<>();
    }
}
