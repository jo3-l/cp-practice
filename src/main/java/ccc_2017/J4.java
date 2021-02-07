package ccc_2017;

import java.util.Scanner;

public class J4 {
    private static final int[] HOURS = new int[]{12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minutes = scanner.nextInt();

        int count = 0;
        int rotations = Math.floorDiv(minutes, 720);
        // There are 31 times of day between 12:00 to 11:59 which are arithmetic sequences, calculated beforehand using
        // computeArithmeticSequencesInRotation()
        count += rotations * 31;

        int leftOverMinutes = minutes - rotations * 720;
        int restHours = Math.floorDiv(leftOverMinutes, 60);
        int restMinutes = leftOverMinutes - restHours * 60;
        for (int hourIndex = 0; hourIndex <= restHours; hourIndex++) {
            int hour = HOURS[hourIndex];
            int maxMinute = hourIndex == restHours ? restMinutes : 59;
            for (int minute = 0; minute <= maxMinute; minute++) {
                if (isArithmeticSequence(hour, minute)) ++count;
            }
        }
        System.out.println(count);
    }

    /* private static int computeArithmeticSequencesInRotation() {
        int count = 0;
        for (int hour : HOURS) {
            for (int minute = 0; minute < 60; minute++) {
                if (isArithmeticSequence(hour, minute)) {
                    System.out.println(hour + ":" + minute);
                    ++count;
                }
            }
        }
        return count;
    } */

    private static boolean isArithmeticSequence(int hour, int minute) {
        int mTens = Math.floorDiv(minute, 10);
        int mUnits = minute % 10;
        if (hour < 10) {
            return mUnits - mTens == mTens - hour;
        }
        int hTens = Math.floorDiv(hour, 10);
        int hUnits = hour % 10;
        return ((mUnits - mTens) == (mTens - hUnits)) && ((mTens - hUnits) == (hUnits - hTens));
    }
}
