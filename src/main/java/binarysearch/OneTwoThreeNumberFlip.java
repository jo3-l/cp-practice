package binarysearch;

public class OneTwoThreeNumberFlip {
    public int solve(int n) {
        char[] v = Integer.toString(n).toCharArray();
        for (int i = 0; i <v.length; i++) {
            if (v[i] != '3') {
                v[i] = '3';
                break;
            }
        }
        int vv = 0;
        for (char c : v) {
            vv *= 10;
            vv += c - '0';
        }
        return vv;
    }
}
