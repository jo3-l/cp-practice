package binarysearch;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class HashTable {
    @SuppressWarnings("unchecked")
    private List<Entry>[] table = new LinkedList[10_000];

    public void put(int key, int val) {
        int i = hash(key);
        List<Entry> entries = table[i];
        if (entries == null) {
            entries = table[i] = new LinkedList<>();
        }

        for (Entry e : entries) {
            if (e.key == key) {
                e.value = val;
                return;
            }
        }
        entries.add(new Entry(key, val));
    }

    public int get(int key) {
        int i = hash(key);
        List<Entry> entries = table[i];
        if (entries == null) return -1;
        for (Entry e : entries) {
            if (e.key == key) return e.value;
        }
        return -1;
    }

    public void remove(int key) {
        int i = hash(key);
        List<Entry> entries = table[i];
        if (entries == null) return;
        ListIterator<Entry> iter = entries.listIterator();
        while (iter.hasNext()) {
            if (iter.next().key == key) {
                iter.remove();
                return;
            }
        }
    }

    // hash used by Java's HashMap
    private int hash(int key) {
        key ^= (key >>> 20) ^ (key >>> 12);
        key = key ^ (key >>> 7) ^ (key >>> 4);
        return key % 10_000;
    }

    public static class Entry {
        public int key;
        public int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
