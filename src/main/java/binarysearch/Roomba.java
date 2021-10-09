package binarysearch;

public class Roomba {
    public boolean solve(String[] moves, int x, int y) {
        int curX = 0;
        int curY = 0;
        for (String move : moves) {
            switch (move) {
                case "NORTH":
                    curY++;
                    break;
                case "SOUTH":
                    curY--;
                    break;
                case "WEST":
                    curX--;
                    break;
                case "EAST":
                    curX++;
                    break;
            }
        }

        return curX == x && curY == y;
    }
}
