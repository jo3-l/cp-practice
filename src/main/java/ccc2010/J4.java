package ccc2010;

import java.util.Scanner;

public class J4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int sequenceSize = scanner.nextInt();
            if (sequenceSize == 0) return;

            int[] sequence = new int[sequenceSize];
            for (int i = 0; i < sequenceSize; i++) sequence[i] = scanner.nextInt();

            System.out.println(getShortestSequenceLength(sequence));
        }
    }

    private static int getShortestSequenceLength(int[] sequence) {
        outer:
        for (int i = 1; i < sequence.length - 1; i++) {
            for (int j = i; j < sequence.length - 1; j++) {
                int offset = (j - i) % i;
                int expectedDifference = sequence[offset + 1] - sequence[offset];
                int actualDifference = sequence[j + 1] - sequence[j];
                if (expectedDifference != actualDifference) continue outer;
            }
            return i;
        }

        return sequence.length - 1;
    }
}
