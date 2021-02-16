package ccc2010;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int c = scanner.nextInt();
        int d = scanner.nextInt();

        int steps = scanner.nextInt();

        int nikkyDistance = computeDistance(a, b, steps);
        int byronDistance = computeDistance(c, d, steps);

        if (nikkyDistance > byronDistance) System.out.println("Nikky");
        else if (nikkyDistance == byronDistance) System.out.println("Tied");
        else System.out.println("Byron");
    }

    private static int computeDistance(int forwardSteps, int backwardSteps, int steps) {
        int cycleLength = forwardSteps + backwardSteps;

        int distance = Math.floorDiv(steps, cycleLength) * (forwardSteps - backwardSteps);
        int remaining = steps % cycleLength;
        if (remaining <= forwardSteps) distance += remaining;
        else distance += 2 * forwardSteps - remaining;
        return distance;
    }
}
