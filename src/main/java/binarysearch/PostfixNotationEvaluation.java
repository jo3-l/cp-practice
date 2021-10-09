package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class PostfixNotationEvaluation {
    public int solve(String[] expr) {
        List<Long> stack = new ArrayList<>();
        for (String v : expr) {
            try {
                long vv = Long.parseLong(v);
                stack.add(vv);
            } catch (NumberFormatException ignored) {
                long lhs = stack.remove(stack.size() - 1);
                long rhs = stack.remove(stack.size() - 1);
                switch (v) {
                    case "+":
                        stack.add(rhs + lhs);
                        break;
                    case "-":
                        stack.add(rhs - lhs);
                        break;
                    case "*":
                        stack.add(rhs * lhs);
                        break;
                    case "/":
                        stack.add(rhs / lhs);
                        break;
                }
            }
        }

        return (int) (long) stack.get(stack.size() - 1);
    }
}
