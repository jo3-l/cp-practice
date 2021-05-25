package binarysearch;

public class ConsecutiveOnes {
    public boolean solve(int[] nums) {
        int state = 0; // 0 -> begin state, 1 -> in group of 1s, 2 -> already ended group of 1s
        for (int num : nums) {
            switch (state) {
                case 0:
                    if (num == 1) state = 1;
                    break;
                case 1:
                    if (num != 1) state = 2;
                    break;
                case 2:
                    if (num == 1) return false;
                    break;
            }
        }

        return true;
    }
}
