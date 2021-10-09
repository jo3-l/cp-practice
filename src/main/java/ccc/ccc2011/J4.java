package ccc.ccc2011;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class J4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        WellPlan wellPlan = new WellPlan();
        wellPlan.setPosition(-1, -5);

        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(" ");
            char cmd = parts[0].charAt(0);
            if (cmd == 'q') return;

            int n = Integer.parseInt(parts[1]);
            Direction direction = Direction.from(cmd);
            if (!wellPlan.move(direction, n)) {
                System.out.println(wellPlan.getX() + " " + wellPlan.getY() + " " + "DANGER");
                return;
            }
            System.out.println(wellPlan.getX() + " " + wellPlan.getY() + " " + "safe");
        }
    }

    private static class WellPlan {
        private final Set<Point> visitedPoints = new HashSet<>();
        private int x = 0;
        private int y = 0;

        public WellPlan() {
            drawInitialPlan();
        }

        public void setPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean fill(int x, int y) {
            Point point = new Point(x, y);
            return visitedPoints.add(point);
        }

        public boolean move(Direction direction, int n) {
            int initialX = x;
            int initialY = y;

            switch (direction) {
                case UP:
                    setPosition(x, y + n);
                    for (int i = 1; i <= n; i++) if (!fill(initialX, initialY + i)) return false;
                    return true;

                case DOWN:
                    setPosition(x, y - n);
                    for (int i = 1; i <= n; i++) if (!fill(initialX, initialY - i)) return false;
                    return true;

                case RIGHT:
                    setPosition(x + n, y);
                    for (int i = 1; i <= n; i++) if (!fill(initialX + i, initialY)) return false;
                    return true;

                case LEFT:
                    setPosition(x - n, y);
                    for (int i = 1; i <= n; i++) if (!fill(initialX - i, initialY)) return false;
                    return true;
            }
            throw new AssertionError("Direction was not valid, this should never happen.");
        }

        private void drawInitialPlan() {
            fill(0, -1);
            setPosition(0, -1);

            move(Direction.DOWN, 2);
            move(Direction.RIGHT, 3);
            move(Direction.DOWN, 2);
            move(Direction.RIGHT, 2);
            move(Direction.UP, 2);
            move(Direction.RIGHT, 2);
            move(Direction.DOWN, 4);
            move(Direction.LEFT, 8);
            move(Direction.UP, 2);

            setPosition(0, 0);
        }

        private static class Point {
            public final int x;
            public final int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }

            @Override
            public boolean equals(Object other) {
                if (!(other instanceof Point)) return false;
                Point otherCast = (Point) other;
                return otherCast.x == x && otherCast.y == y;
            }
        }
    }

    private enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;

        public static Direction from(char c) {
            switch (c) {
                case 'u':
                    return UP;
                case 'd':
                    return DOWN;
                case 'l':
                    return LEFT;
                case 'r':
                    return RIGHT;
                default:
                    throw new IllegalArgumentException("Argument passed to Direction.from() was not one of 'u', 'd', 'l' or 'r'.");
            }
        }
    }
}
