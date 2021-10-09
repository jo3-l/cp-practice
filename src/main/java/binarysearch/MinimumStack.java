package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class MinimumStack {
    private final List<Entry> stack = new ArrayList<>();

    public void append(int val) {
        if (stack.isEmpty()) {
            stack.add(new Entry(val, val));
        } else {
            stack.add(new Entry(val, Math.min(val, min())));
        }
    }

    public int peek() {
        return stack.get(stack.size() - 1).val;
    }

    public int min() {
        return stack.get(stack.size() - 1).min;
    }

    public int pop() {
        return stack.remove(stack.size() - 1).val;
    }

    private static class Entry {
        public int val;
        public int min;

        public Entry(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}
