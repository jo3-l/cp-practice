package ccc.ccc2013;

import java.util.Arrays;
import java.util.Scanner;

public class J4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int timeAllotted = scanner.nextInt();
        int choreCount = scanner.nextInt();

        int[] chores = new int[choreCount];
        for (int i = 0; i < choreCount; i++) chores[i] = scanner.nextInt();

        Arrays.sort(chores);

        int choresDone = 0;
        int timeUsed = 0;
        for (int chore : chores) {
            timeUsed += chore;
            if (timeUsed > timeAllotted) break;
            ++choresDone;
        }

        System.out.println(choresDone);
    }
}
