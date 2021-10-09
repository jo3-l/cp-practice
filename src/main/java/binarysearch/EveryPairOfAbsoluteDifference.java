package binarysearch;

public class EveryPairOfAbsoluteDifference {
    public int solve(int[] nums) {
        final long MOD = (long) 1e9 + 7;
        long diff = 0;
        for (int i = 1; i < nums.length; i++) {
            diff += Math.floorMod(Math.abs(nums[i] - nums[0]), MOD);
            diff = Math.floorMod(diff, MOD);
        }
        diff = Math.floorMod(diff, MOD);
        long res = Math.floorMod(diff + diff, MOD);
        for (int i = 1; i < nums.length - 1; i++) {
            long sub = Math.floorMod(Math.abs(nums[i] - nums[0]), MOD);
            diff -= Math.floorMod(sub + sub, MOD);
            diff = Math.floorMod(diff, MOD);
            res += Math.floorMod(diff + diff, MOD);
            res = Math.floorMod(res, MOD);
        }
        return (int) Math.floorMod(res, MOD);
    }
}
