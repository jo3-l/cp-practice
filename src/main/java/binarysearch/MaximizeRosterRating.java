package binarysearch;

import java.util.Arrays;
import java.util.Comparator;

public class MaximizeRosterRating {
    private int[][] dp;

    public int solve(int[] ratings, int[] ages) {
        dp = new int[ratings.length + 1][ratings.length + 1];
        Person[] people = new Person[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            people[i] = new Person(ratings[i], ages[i]);
        }
        Arrays.sort(people, Comparator.comparing((Person person) -> person.age).thenComparing((Person person) -> person.rating));
        return go(people, 0, 1);
    }

    private int go(Person[] people, int lastPos, int curPos) {
        if (curPos == people.length + 1) return 0;
        if (dp[lastPos][curPos] != 0) return dp[lastPos][curPos];
        boolean canChoose = lastPos == 0
                || people[lastPos - 1].age == people[curPos - 1].age
                || people[lastPos - 1].rating <= people[curPos - 1].rating;
        return dp[lastPos][curPos] = Math.max(
                // chose this person
                canChoose ? people[curPos - 1].rating + go(people, curPos, curPos + 1) : Integer.MIN_VALUE,
                // skip this person
                go(people, lastPos, curPos + 1)
        );
    }

    public static class Person {
        public int rating;
        public int age;

        public Person(int rating, int age) {
            this.rating = rating;
            this.age = age;
        }
    }
}
