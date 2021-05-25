package kattis;

import java.util.Scanner;

public class Yoda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String m = scanner.nextLine();
        String n = scanner.nextLine();

        boolean mAllFellOut = true;
        boolean nAllFellOut = true;

        int mLen = m.length();
        String mPart = "";
        int nLen = n.length();
        String nPart = "";
        if (mLen > nLen) {
            mPart = m.substring(0, mLen - nLen);
            m = m.substring(mLen - nLen);
            mAllFellOut = false;
        } else if (nLen > mLen) {
            nPart = n.substring(0, nLen - mLen);
            n = n.substring(nLen - mLen);
            nAllFellOut = false;
        }

        int[] newM = new int[m.length()];
        int[] newN = new int[n.length()];
        for (int i = m.length() - 1; i >= 0; i--) {
            int mDigit = m.charAt(i) - '0';
            int nDigit = n.charAt(i) - '0';
            if (mDigit > nDigit) {
                mAllFellOut = false;
                newM[i] = mDigit;
                newN[i] = -1;
            } else if (nDigit > mDigit) {
                nAllFellOut = false;
                newN[i] = nDigit;
                newM[i] = -1;
            } else {
                mAllFellOut = false;
                nAllFellOut = false;
                newM[i] = mDigit;
                newN[i] = nDigit;
            }
        }

        System.out.println(mAllFellOut ? "YODA" : mPart + formatInt(newM));
        System.out.println(nAllFellOut ? "YODA" : nPart + formatInt(newN));
    }

    private static String formatInt(int[] data) {
        int num = 0;
        int multiplier = 1;
        for (int i = data.length - 1; i >= 0; i--) {
            int digit = data[i];
            if (digit == -1) continue;
            num += digit * multiplier;
            multiplier *= 10;
        }

        return Integer.toString(num);
    }
}
