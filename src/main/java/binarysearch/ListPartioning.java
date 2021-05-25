package binarysearch;

import java.util.Arrays;

public class ListPartioning {
    public String[] solve(String[] strs) {
        int redSeen = 0;
        int greenSeen = 0;
        for (String str : strs) {
            if (str.equals("red")) redSeen++;
            else if (str.equals("green")) greenSeen++;
        }

        Arrays.fill(strs, 0, redSeen, "red");
        Arrays.fill(strs, redSeen, redSeen + greenSeen, "green");
        Arrays.fill(strs, redSeen + greenSeen, strs.length, "blue");

        return strs;
    }
}
