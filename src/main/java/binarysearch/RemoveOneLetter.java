package binarysearch;

public class RemoveOneLetter {
    public static void main(String[] args) {
        System.out.println(new RemoveOneLetter().solve("hello", "hello"));
    }

    public boolean solve(String s0, String s1) {
        if (s0.length() != s1.length() + 1) return false;
        if (s1.isEmpty()) return true;

        // find longest common prefix
        int i;
        for (i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s0.charAt(i)) break;
        }

        for (int j = i + 1; j < s0.length(); j++) {
            if (s0.charAt(j) != s1.charAt(j - 1)) return false;
        }
        return true;
    }
}
