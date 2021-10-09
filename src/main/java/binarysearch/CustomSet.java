package binarysearch;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CustomSet {
    @SuppressWarnings("unchecked")
    private List<Integer>[] table = new LinkedList[10_000];

    public void add(int val) {
        int i = hash(val);
        List<Integer> keys = table[i];
        if (keys == null) keys = table[i] = new LinkedList<>();
        if (!keys.contains(val)) keys.add(val);
    }

    public boolean exists(int val) {
        int i = hash(val);
        List<Integer> keys = table[i];
        if (keys == null) return false;
        return keys.contains(val);
    }

    public void remove(int val) {
        int i = hash(val);
        List<Integer> keys = table[i];
        if (keys == null) return;

        ListIterator<Integer> iter = keys.listIterator();
        while (iter.hasNext()) {
            if (iter.next() == val) {
                iter.remove();
                return;
            }
        }
    }

    private int hash(int val) {
        if (val < 0) val = -val;
        val ^= (val >>> 20) ^ (val >>> 12);
        val = val ^ (val >>> 7) ^ (val >>> 4);
        return val % 10_000;
    }
}
