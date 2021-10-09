package binarysearch;

public class PartitionListToPairsThatAreDivisibleByK {
    public boolean solve(int[] nums, int k) {
        if ((nums.length & 1) == 1) return false;
        int[] buckets = new int[k];
        for (int n : nums) {
            if (n < 0) {
                int mod = n % k;
                n = mod + k;
            }

            buckets[n % k]++;
        }
        for (int i = 0; i < buckets.length; i++) {
            int c = (k - i) % k;
            if (i == c && (buckets[i] & 1) == 1) return false;
            else if (buckets[c] != buckets[i]) return false;
        }
        return true;
    }
}
