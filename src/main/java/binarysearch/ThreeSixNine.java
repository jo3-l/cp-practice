package binarysearch;

public class ThreeSixNine {
    public String[] solve(int n) {
        String[] res = new String[n];

        int threeCtr = 0;
        for (int i = 0; i < n; i++) {
            if (++threeCtr == 3) {
                threeCtr = 0;
                res[i] = "clap";
                continue;
            }

            String nn = Integer.toString(i + 1);
            int j;
            for (j = 0; j < nn.length(); j++) {
                int v = nn.charAt(j) - '0';
                if (v == 3 || v == 6 || v == 9) break;
            }

            res[i] = j == nn.length() ? nn : "clap";
        }

        return res;
    }
}
