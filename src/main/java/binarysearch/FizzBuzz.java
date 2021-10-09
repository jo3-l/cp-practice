package binarysearch;

public class FizzBuzz {
    public String[] solve(int n) {
        String[] res = new String[n];

        int fiveCounter = 0;
        int threeCounter = 0;
        for (int i = 1; i <= n; i++) {
            boolean isFiveMultiple = ++fiveCounter == 5;
            boolean isThreeMultiple = ++threeCounter == 3;

            if (isFiveMultiple && isThreeMultiple) {
                fiveCounter = threeCounter = 0;
                res[i - 1] = "FizzBuzz";
            } else if (isFiveMultiple) {
                fiveCounter = 0;
                res[i - 1] = "Buzz";
            } else if (isThreeMultiple) {
                threeCounter = 0;
                res[i - 1] = "Fizz";
            } else {
                res[i - 1] = Integer.toString(i);
            }
        }

        return res;
    }
}
