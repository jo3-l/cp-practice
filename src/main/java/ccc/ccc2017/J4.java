package ccc.ccc2017;

import java.util.Scanner;

public class J4 {
    private static final int[] HOURS = new int[]{12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minutes = scanner.nextInt();

        int count = 0;
        // Given N minutes, we typically do not need to check all N minutes: We know that there are 31 times which are
        // arithmetic sequences in a 12-hour period (precalculated using computeArithmeticSequencesInRotation), so we can
        // simply subtract 12-hour periods as many times as we can and add 31 to the total count for each one. In practice,
        // we do not subtract in a loop, rather, we can utilise floor division as seen below.
        //
        // 720 is the number of minutes in 12 hours.
        int rotations = Math.floorDiv(minutes, 720);
        // There are 31 times of day between 12:00 to 11:59 which are arithmetic sequences, calculated beforehand using
        // computeArithmeticSequencesInRotation().
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
        int minuteTensPlace = Math.floorDiv(minute, 10);
        int minuteUnitsPlace = minute % 10;
        if (hour < 10) {
            return minuteUnitsPlace - minuteTensPlace == minuteTensPlace - hour;
        }
        int hourTensPlace = Math.floorDiv(hour, 10);
        int hourUnitsPlace = hour % 10;
        return ((minuteUnitsPlace - minuteTensPlace) == (minuteTensPlace - hourUnitsPlace)) && ((minuteTensPlace - hourUnitsPlace) == (hourUnitsPlace - hourTensPlace));
    }
}
