package binarysearch;

public class AngryOwner {
    public int solve(int[] customers, int[] mood, int k) {
        int happy = 0;
        int all = 0;
        for (int i = 0; i < k; i++) {
            all += customers[i];
            if (mood[i] == 1) happy += customers[i];
        }
        int total = happy;

        int maxInc = Math.max(all - happy, 0);
        for (int i = 1, j = k; j < customers.length; i++, j++) {
            if (mood[i - 1] == 1) happy -= customers[i - 1];
            if (mood[j] == 1) {
                happy += customers[j];
                total += customers[j];
            }
            all -= customers[i - 1];
            all += customers[j];
            maxInc = Math.max(maxInc, all - happy);
        }

        return total + maxInc;
    }
}
