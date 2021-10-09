package binarysearch;

public class RunLengthEncoding {
    public String solve(String s) {
        StringBuilder rle = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int n = 1;
            i++;
            while (i < s.length()) {
                if (s.charAt(i) != c) break;
                i++;
                n++;
            }

            rle.append(n);
            rle.append(c);
        }
        return rle.toString();
    }
}
