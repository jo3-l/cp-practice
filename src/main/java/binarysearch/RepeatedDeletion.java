package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class RepeatedDeletion {
    public String solve(String s) {
        List<Character> stack = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.get(stack.size() - 1) == c) {
                stack.remove(stack.size() - 1);
                ++i;
                while (i < s.length() && s.charAt(i) == c) i++;
            } else {
                stack.add(c);
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }
}
