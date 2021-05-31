package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class WordMachine {
    public int solve(String[] ops) {
        List<Integer> stack = new ArrayList<>();
        for (String op : ops) {
            switch (op) {
                case "POP":
                    if (stack.isEmpty()) return -1;
                    stack.remove(stack.size() - 1);
                    break;
                case "DUP":
                    if (stack.isEmpty()) return -1;
                    stack.add(stack.get(stack.size() - 1));
                    break;
                case "+":
                    if (stack.size() < 2) return -1;
                    stack.add(stack.remove(stack.size() - 1) + stack.remove(stack.size() - 1));
                    break;
                case "-":
                    if (stack.size() < 2) return -1;
                    stack.add(stack.remove(stack.size() - 1) - stack.remove(stack.size() - 1));
                    break;
                default:
                    stack.add(Integer.parseInt(op));
                    break;
            }
        }

        return stack.isEmpty() ? -1 : stack.get(stack.size() - 1);
    }
}
