package templates;

public class BinaryExponentation {
    // a^b
    public static int pow(int a, int b) {
        int res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a;
            }
            a = a * a;
            b >>= 1;
        }
        return res;
    }
}
