package ccc.ccc2005;

import java.util.Scanner;

public class J4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int height = sc.nextInt();
        boolean[][] room = new boolean[height][width];
        int cutoutWidth = sc.nextInt();
        int cutoutHeight = sc.nextInt();
        for (int j = 0; j < cutoutWidth; j++) {
            for (int i = 0; i < cutoutHeight; i++) room[i][j] = true;
            for (int i = height - 1; i >= height - cutoutHeight; i--) room[i][j] = true;
        }
        for (int j = width - 1; j >= width - cutoutWidth; j--) {
            for (int i = 0; i < cutoutHeight; i++) room[i][j] = true;
            for (int i = height - 1; i >= height - cutoutHeight; i--) room[i][j] = true;
        }

        State[] states = {
                new State("moving right hugging top", new int[]{1, 0}, 0, 1), // 0
                new State("moving down hugging top right block", new int[]{0, 1}, 2, 1), // 1
                new State("moving right hugging top right block", new int[]{1, 0}, 2, 3), // 2
                new State("moving down hugging right side", new int[]{0, 1}, 3, 4), // 3
                new State("moving left hugging bottom right block", new int[]{-1, 0}, 5, 4), // 4
                new State("moving down hugging bottom right block", new int[]{0, 1}, 5, 6), // 5
                new State("moving left hugging bottom side", new int[]{-1, 0}, 6, 7), // 6
                new State("moving up hugging bottom left block", new int[]{0, -1}, 8, 7), // 7
                new State("moving left hugging bottom left block", new int[]{-1, 0}, 8, 9), // 8
                new State("moving up hugging left side", new int[]{0, -1}, 9, 10), // 9
                new State("moving right hugging top left block", new int[]{1, 0}, 11, 10), // 10
                new State("moving up hugging top left block", new int[]{0, -1}, 11, 0), // 11
        };
        State state = states[0];
        int x = cutoutWidth;
        int y = 0;
        room[y][x] = true;

        int steps = sc.nextInt();
        while (steps-- > 0) {
            int i;
            for (i = 0; i < state.transitions.length; i++) {
                State pState = states[state.transitions[i]];
                int pX = x + pState.offset[0];
                int pY = y + pState.offset[1];
                if (pX < 0 || pY >= height) continue;
                if (pY < 0 || pX >= width) continue;
                if (room[pY][pX]) continue;

                state = pState;
                x = pX;
                y = pY;
                room[pY][pX] = true;
                break;
            }

            if (i == state.transitions.length) {
                break; // nowhere to go
            }
        }

        System.out.println(x + 1);
        System.out.println(y + 1);
    }

    private static class State {
        public String name;
        public int[] offset;
        public int[] transitions;

        public State(String name, int[] offset, int... transitions) {
            this.name = name;
            this.offset = offset;
            this.transitions = transitions;
        }
    }
}
