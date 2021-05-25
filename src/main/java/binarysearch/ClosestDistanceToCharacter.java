package binarysearch;

public class ClosestDistanceToCharacter {
    public int[] solve(String s, String cStr) {
        char c = cStr.charAt(0);

        int[] ds = new int[s.length()];

        int prevIdx = -1;
        int curIdx = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                prevIdx = curIdx;
                curIdx = i;
                ds[i] = 0;

                // go back and fill in the distances between the last known index and the current one
                for (int j = Math.max(prevIdx, 0); j < curIdx; j++) {
                    int distPrev = prevIdx == -1
                            ? 1_000_000
                            : j - prevIdx;
                    int distCur = curIdx - j;
                    ds[j] = Math.min(distPrev, distCur);
                }
            }
        }

        for (int i = curIdx + 1; i < s.length(); i++) {
            ds[i] = i - curIdx;
        }

        return ds;
    }
}
