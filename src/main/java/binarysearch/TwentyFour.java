package binarysearch;

public class TwentyFour {
    public boolean solve(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2], d = nums[3];
        // first op
        int[] op = new int[3];
        for (; op[0] < 4; op[0]++) {
            op[1] = 0;
            // second op
            for (; op[1] < 4; op[1]++) {
                op[2] = 0;
                // third op
                for (; op[2] < 4; op[2]++) {
                    // a ? b ? c ? d
                    int s1 = x(x(x(a, op[0], b), op[1], c), op[2], d);
                    if (s1 == 24) return true;
                    // (a ? (b ? c) ? d)
                    int s2 = x(x(a, op[0], x(b, op[1], c)), op[2], d);
                    if (s2 == 24) return true;
                    // (a ? b) ? (c ? d)
                    int s3 = x(x(a, op[0], b), op[1], x(c, op[2], d));
                    if (s3 == 24) return true;
                    // a ? (b ? c ? d)
                    int s4 = x(a, op[0], x(x(b, op[1], c), op[2], d));
                    if (s4 == 24) return true;
                    // a ? (b ? (c ? d))
                    int s5 = x(a, op[0], x(b, op[1], x(c, op[2], d)));
                    if (s5 == 24) return true;
                }
            }
        }
        return false;
    }

    private int x(int lhs, int o, int rhs) {
        switch (o) {
            case 0:
                return lhs + rhs;
            case 1:
                return lhs - rhs;
            case 2:
                return lhs * rhs;
            case 3:
                if (rhs == 0) return -173;
                return lhs / rhs;
        }
        return -1;
    }
}
