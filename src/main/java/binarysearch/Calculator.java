// A funny little solution to this problem. IT's certainly not the best - or proper - way, but it gets the job done.

package binarysearch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private final Pattern PAREN_PATTERN = Pattern.compile("\\(([^)]+)\\)");
    private final Pattern MUL_DIV_PATTERN = Pattern.compile("((?:(?<!\\d)-)?\\d+)([*/])(-?\\d+)");
    private final Pattern ADD_SUB_PATTERN = Pattern.compile("((?:(?<!\\d)-)?\\d+)([+-])(-?\\d+)");

    public int solve(String expr) {
        Matcher matcher;
        for (matcher = PAREN_PATTERN.matcher(expr); matcher.find(); matcher.reset(expr)) {
            int startIdx = matcher.start();
            int endIdx = matcher.end();
            int result = solve(expr.substring(startIdx, endIdx));
            expr = replaceBetween(expr, startIdx, endIdx, Integer.toString(result));
        }

        for (matcher.usePattern(MUL_DIV_PATTERN).reset(expr); matcher.find(); matcher.reset(expr)) {
            int a = Integer.parseInt(matcher.group(1));
            int b = Integer.parseInt(matcher.group(3));
            int result = matcher.group(2).equals("*") ? a * b : Math.floorDiv(a, b);
            expr = replaceBetween(expr, matcher.start(), matcher.end(), Integer.toString(result));
        }

        for (matcher.usePattern(ADD_SUB_PATTERN).reset(expr); matcher.find(); matcher.reset(expr)) {
            int a = Integer.parseInt(matcher.group(1));
            int b = Integer.parseInt(matcher.group(3));
            int result = matcher.group(2).equals("+") ? a + b : a - b;
            expr = replaceBetween(expr, matcher.start(), matcher.end(), Integer.toString(result));
        }

        return Integer.parseInt(expr);
    }

    private String replaceBetween(String input, int from, int to, String replacement) {
        return input.substring(0, from) + replacement + input.substring(to);
    }
}
