package binarysearch;

public class Bounce {
    public boolean solve(int[] nums, int k) {
        return dfs(nums, k, new boolean[nums.length]);
    }

    private boolean dfs(int[] nums, int i, boolean[] visited) {
        if (i == nums.length - 1) return true;
        int r = i + nums[i];
        if (r < nums.length) {
            if (!visited[r]) {
                visited[r] = true;
                if (dfs(nums, r, visited)) return true;
            }
        }

        int l = i - nums[i];
        if (l >= 0) {
            if (!visited[l]) {
                visited[l] = true;
                return dfs(nums, l, visited);
            }
        }
        return false;
    }
}
