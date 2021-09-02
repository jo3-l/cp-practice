package binarysearch;

public class CircularQueue {
    private int[] data;
    private int head;
    private int len;
    private int cap;

    public CircularQueue(int capacity) {
        data = new int[capacity];
        cap = capacity;
    }

    public boolean enqueue(int val) {
        if (len == cap) return false;
        data[(head + len) % cap] = val;
        len++;
        return true;
    }

    public boolean dequeue() {
        if (len == 0) return false;
        head = (head + 1) % cap;
        len--;
        return true;
    }

    public int front() {
        if (len == 0) return -1;
        return data[head];
    }

    public int top() {
        if (len == 0) return -1;
        return data[(head + len - 1) % cap];
    }

    public boolean isFull() {
        return len == cap;
    }

    public boolean isEmpty() {
        return len == 0;
    }
}
