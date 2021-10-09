package binarysearch;

public class TwoDimensionalIterator {
    private int[][] lists;
    private int i;
    private int j;

    public TwoDimensionalIterator(int[][] lists) {
        this.lists = lists;
    }

    public int next() {
        maybeWrap();
        return lists[i][j++];
    }

    public boolean hasnext() {
        maybeWrap();
        return i < lists.length && j < lists[i].length;
    }

    private void maybeWrap() {
        while (i < lists.length && j == lists[i].length) {
            i++;
            j = 0;
        }
    }
}
