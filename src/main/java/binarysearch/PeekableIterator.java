package binarysearch;

public class PeekableIterator {
    private int idx = -1;
    private int[] nums;

    public PeekableIterator(int[] nums) {
        this.nums = nums;
    }

    public int peek() {
        return nums[idx + 1];
    }

    public int next() {
        return nums[++idx];
    }

    public boolean hasnext() {
        return idx != nums.length - 1;
    }
}
