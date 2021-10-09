package binarysearch;

public class IntegerToRomanNumeral {
    public String solve(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if (n < 4) {
                sb.append('I');
                n--;
            } else if (n == 4) {
                sb.append("IV");
                n = 0;
            } else if (n < 9) {
                sb.append('V');
                n -= 5;
            } else if (n == 9) {
                sb.append("IX");
                n = 0;
            } else if (n < 40) {
                sb.append('X');
                n -= 10;
            } else if (n < 50) {
                sb.append("XL");
                n -= 40;
            } else if (n < 90) {
                sb.append('L');
                n -= 50;
            } else if (n < 100) {
                sb.append("XC");
                n -= 90;
            } else if (n < 400) {
                sb.append('C');
                n -= 100;
            } else if (n < 500) {
                sb.append("CD");
                n -= 400;
            } else if (n < 900) {
                sb.append('D');
                n -= 500;
            } else if (n < 1000) {
                sb.append("CM");
                n -= 900;
            } else {
                sb.append('M');
                n -= 1000;
            }
        }
        return sb.toString();
    }
}
