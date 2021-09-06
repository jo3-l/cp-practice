package binarysearch;

import java.util.Arrays;

public class LogTruncation {
    public int solve(int[] logs, int limit) {
        Arrays.sort(logs);
        int[] pfs = new int[logs.length];
        pfs[0] = logs[0];
        for (int i = 1; i < logs.length; i++) pfs[i] = pfs[i - 1] + logs[i];

        int lo = 0;
        int hi = 0;
        for (int l : logs) hi = Math.max(hi, l);
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            int noTrunc = countLogsNotLongerThan(logs, mid);
            int sum = (noTrunc > 0 ? pfs[noTrunc - 1] : 0) + mid * (logs.length - noTrunc);
            if (sum <= limit) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }

    private int countLogsNotLongerThan(int[] logs, int n) {
        int lo = 0;
        int hi = logs.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (logs[mid] <= n) lo = mid;
            else hi = mid - 1;
        }
        return logs[lo] <= n ? lo + 1 : 0;
    }
}
