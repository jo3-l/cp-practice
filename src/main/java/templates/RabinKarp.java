package templates;

public class RabinKarp {
    // random prime
    private final int P = 31;

    public int search(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.length() < needle.length()) return -1;
        int maxP = 1; // p^(len(needle)-1), precalculated for efficiency
        int needleHash = needle.charAt(0);
        int rollingHash = haystack.charAt(0);
        for (int i = 1; i < needle.length(); i++) {
            needleHash = needleHash * P + needle.charAt(i);
            rollingHash = rollingHash * P + haystack.charAt(i);
            maxP *= P;
        }

        // do the current hashes match?
        if (needleHash == rollingHash && haystack.startsWith(needle)) return 0;
        // advance sliding window until we're done / find a match
        for (int i = 1, j = needle.length(); j < haystack.length(); i++, j++) {
            // update rolling hash
            // we have to remove the oldest character, which contributes (c * P^(len(needle)-1))
            // then, add the latest character
            rollingHash = (rollingHash - maxP * haystack.charAt(i - 1)) * P + haystack.charAt(j);
            // does it match?
            if (rollingHash == needleHash && haystack.startsWith(needle, i)) return i;
        }

        // no match
        return -1;
    }
}
