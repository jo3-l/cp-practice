package binarysearch;

public class StringMultiplication {
    public String solve(String a, String b) {
        if (a.length() > b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        int negativeCount = 0;
        if (a.startsWith("-")) {
            negativeCount++;
            a = a.substring(1);
        }
        if (b.startsWith("-")) {
            negativeCount++;
            b = b.substring(1);
        }
        boolean isNegative = negativeCount == 1;

        StringBuilder result = new StringBuilder();
        for (int i = a.length() - 1, numZero = 0; i >= 0; i--, numZero++) {
            int multiplier = a.charAt(i) - '0';
            StringBuilder padded = multOne(b, multiplier);
            for (int j = 0; j < numZero; j++) padded.append('0');
            result = add(padded, result);
        }

        if (isNegative) result.insert(0, '-');
        return result.toString();
    }

    private StringBuilder multOne(String multiplicand, int multiplier) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = multiplicand.length() - 1; i >= 0; i--) {
            int n = multiplicand.charAt(i) - '0';
            int product = n * multiplier + carry;
            carry = product / 10;
            result.append(product % 10);
        }
        result.append(carry);
        return result.reverse();
    }

    private StringBuilder add(StringBuilder first, StringBuilder second) {
        if (first.length() < second.length()) first = padStartWithZeros(first, second.length());
        else if (second.length() < first.length()) second = padStartWithZeros(second, first.length());

        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = first.length() - 1; i >= 0; i--) {
            int x = first.charAt(i) - '0';
            int y = second.charAt(i) - '0';
            int sum = x + y + carry;
            carry = sum / 10;
            result.append(sum % 10);
        }
        if (result.charAt(result.length() - 1) == '0') result.deleteCharAt(result.length() - 1);
        if (carry != 0) result.append(carry);
        return result.reverse();
    }

    private StringBuilder padStartWithZeros(StringBuilder builder, int length) {
        StringBuilder result = new StringBuilder(length);
        int numZero = length - builder.length();
        while (numZero-- > 0) result.append('0');
        result.append(builder);
        return result;
    }
}
