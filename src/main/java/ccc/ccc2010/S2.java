package ccc.ccc2010;

import java.util.Scanner;

public class S2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        sc.skip("\n");
        // build a trie from the codes
        TrieNode root = new TrieNode();
        while (K-- > 0) {
            String l = sc.nextLine();
            char c = l.charAt(0);
            TrieNode cur = root;
            for (int i = 2; i < l.length(); i++) {
                int of = l.charAt(i) - '0';
                if (cur.child[of] != null) cur = cur.child[of];
                else cur = cur.child[of] = new TrieNode();
            }
            cur.val = c;
        }

        StringBuilder decoded = new StringBuilder();
        String x = sc.nextLine();
        int i = 0;
        while (i < x.length()) {
            TrieNode cur;
            for (cur = root; i < x.length() && cur.val == 0; cur = cur.child[x.charAt(i++) - '0']);
            decoded.append(cur.val);
        }
        System.out.println(decoded);
    }

    private static class TrieNode {
        public char val = 0;
        public TrieNode[] child = new TrieNode[2];
    }
}
