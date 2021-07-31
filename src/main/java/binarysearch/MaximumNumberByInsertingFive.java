package binarysearch;

public class MaximumNumberByInsertingFive {
    public int solve(int n) {
        int mm = Integer.MIN_VALUE;
        String s = Integer.toString(n);
        for (int i = s.charAt(0) == '-' ? 1 : 0; i <= s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s, 0, i);
            sb.append(5);
            sb.append(s, i, s.length());
            mm = Math.max(mm, Integer.parseInt(sb.toString()));
        }
        return mm;
    }
}
