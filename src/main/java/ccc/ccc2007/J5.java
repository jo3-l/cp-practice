package ccc.ccc2007;

import java.util.*;

public class J5 {
    public static void main(String[] args) {
        List<Integer> motels = new ArrayList<>();
        motels.add(0);
        motels.add(990);
        motels.add(1010);
        motels.add(1970);
        motels.add(2030);
        motels.add(2940);
        motels.add(3060);
        motels.add(3930);
        motels.add(4060);
        motels.add(4970);
        motels.add(5030);
        motels.add(5990);
        motels.add(6010);
        motels.add(7000);

        Scanner sc = new Scanner(System.in);
        int minDist = sc.nextInt();
        int maxDist = sc.nextInt();

        int N = sc.nextInt();
        while (N-- > 0) motels.add(sc.nextInt());

        motels.sort(Comparator.naturalOrder());

        long[] dp = new long[motels.size()];
        int first = findFirstIdxGteN(motels, minDist); // first motel we can stay at
        if (first == -1) {
            System.out.println("0");
            return;
        }

        int last = findLastIdxLteN(motels, maxDist); // last motel we can stay at
        if (last == -1) {
            System.out.println("0");
            return;
        }

        // set dp[first..last] to 1
        for (int i = first; i <= last; i++) dp[i] = 1;

        for (int j = 1; j < motels.size(); j++) {
            int loc = motels.get(j);
            first = findFirstIdxGteN(motels, loc - maxDist);
            last = findLastIdxLteN(motels, loc - minDist);
            for (int z = first; z <= last; z++) dp[j] += dp[z];
        }

        // sum up the values of all motels which can get to 7000
        System.out.println(dp[dp.length - 1]);
    }

    private static int findFirstIdxGteN(List<Integer> list, int N) {
        int hi = list.size() - 1;
        int lo = 0;
        while (lo < hi) {
            int mid = (lo + hi) >> 1;
            if (list.get(mid) >= N) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return list.get(lo) >= N ? lo : -1;
    }

    private static int findLastIdxLteN(List<Integer> list, int N) {
        int hi = list.size() - 1;
        int lo = 0;
        while (lo < hi) {
            int mid = (lo + hi + 1) >> 1;
            if (list.get(mid) <= N) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return list.get(lo) <= N ? lo : -1;
    }
}
