package binarysearch;

public class BeerBottles {
    public int solve(int n) {
        int total = n;
        while (n >= 3) {
            int mark = total;
            total += n / 3;
            n %= 3;
            n += total - mark;
        }

        return total;
    }
}
