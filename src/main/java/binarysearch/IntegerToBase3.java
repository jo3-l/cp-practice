package binarysearch;

public class IntegerToBase3 {
    public String solve(int n) {
        StringBuilder sb = new StringBuilder();
        while (n >= 3) {
            int rem = n - (n /= 3) * 3;
            sb.append(rem);
        }
        sb.append(n);

        return sb.reverse().toString();
    }
}
