package templates;

public class RabinKarp {
    private final int P = 31;

    public int search(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.length() < needle.length()) return -1;
        int maxP = 1;
        int needleHash = needle.charAt(0);
        int rollingHash = haystack.charAt(0);
        for (int i = 1; i < needle.length(); i++) {
            needleHash = needleHash * P + needle.charAt(i);
            rollingHash = rollingHash * P + haystack.charAt(i);
            maxP *= P;
        }
        if (needleHash == rollingHash) return 0;
        for (int i = 1, j = needle.length(); j < haystack.length(); i++, j++) {
            rollingHash = (rollingHash - maxP * haystack.charAt(i - 1)) * P + haystack.charAt(j);
            if (rollingHash == needleHash && haystack.startsWith(needle, i)) {
                return i;
            }
        }
        return -1;
    }
}
