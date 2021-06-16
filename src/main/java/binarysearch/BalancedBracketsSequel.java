package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class BalancedBracketsSequel {
    public boolean solve(String s) {
        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.add(')');
            else if (c == '{') stack.add('}');
            else if (c == '[') stack.add(']');
            else if (stack.isEmpty() || stack.remove(stack.size() - 1) != c) return false;
        }

        return stack.isEmpty();
    }
}
