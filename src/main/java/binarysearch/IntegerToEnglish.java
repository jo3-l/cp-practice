package binarysearch;

public class IntegerToEnglish {
    private final String[] digits = new String[]{
            "Zero",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
    };

    private final String[] tenX = new String[]{
            "Ten",
            "Eleven",
            "Twelve",
            "Thirteen",
            "Fourteen",
            "Fifteen",
            "Sixteen",
            "Seventeen",
            "Eighteen",
            "Nineteen",
    };

    private final String[] tenMult = new String[]{
            "",
            "Ten",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety"
    };

    public String solve(int num) {
        if (num < 10) return digits[num];
        if (num < 20) return tenX[num - 10];
        if (num < 100) {
            String tens = tenMult[num / 10];
            int dec = num % 10;
            return dec == 0 ? tens : tens + " " + digits[dec];
        }
        if (num < 1000) {
            String hundreds = digits[num / 100] + " Hundred";
            int cent = num % 100;
            return cent == 0 ? hundreds : hundreds + " " + solve(cent);
        }
        if (num < 1_000_000) {
            String thousands = solve(num / 1000) + " Thousand";
            int rem = num % 1000;
            return rem == 0 ? thousands : thousands + " " + solve(rem);
        }
        if (num < 1_000_000_000) {
            String millions = solve(num / 1_000_000) + " Million";
            int rem = num % 1_000_000;
            return rem == 0 ? millions : millions + " " + solve(rem);
        }
        String billions = solve(num / 1_000_000_000) + " Billion";
        int rem = num % 1_000_000_000;
        return rem == 0 ? billions : billions + " " + solve(rem);
    }
}
