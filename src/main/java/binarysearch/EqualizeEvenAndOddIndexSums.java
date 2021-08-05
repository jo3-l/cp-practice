package binarysearch;

public class EqualizeEvenAndOddIndexSums {
    public int solve(int[] nums) {
        if (nums.length < 2) return nums.length;
        int[] es = new int[nums.length]; // es[i] = sum(even index values in nums[i..])
        int[] os = new int[nums.length]; // os[i] = sum(odd index values in nums[i..])
        int[] esr = new int[nums.length]; // esr[i] = sum(even index values in nums[..i])
        int[] osr = new int[nums.length]; // osr[i] = sum(odd index values in nums[..i])
        int[][] s = {es, os};
        int[][] sr = {esr, osr};
        for (int i = nums.length - 1, j = 0; i >= 0; i--, j++) {
            es[i] = i == nums.length - 1 ? 0 : es[i + 1];
            os[i] = i == nums.length - 1 ? 0 : os[i + 1];
            s[i & 1][i] += nums[i];

            esr[j] = j == 0 ? 0 : esr[j - 1];
            osr[j] = j == 0 ? 0 : osr[j - 1];
            sr[j & 1][j] += nums[j];
        }

        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            int odd;
            int even;
            if (i == 0) {
                odd = es[i + 1];
                even = os[i + 1];
            } else if (i == nums.length - 1) {
                odd = osr[i - 1];
                even = esr[i - 1];
            } else {
                odd = osr[i - 1] + es[i + 1];
                even = esr[i - 1] + os[i + 1];
            }

            if (odd == even) n++;
        }
        return n;
    }
}
