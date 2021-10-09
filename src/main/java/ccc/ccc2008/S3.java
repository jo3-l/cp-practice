package ccc.ccc2008;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class S3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            sc.skip("\n");
            State[][] city = new State[r][c];
            for (int i = 0; i < r; i++) {
                String s = sc.nextLine();
                for (int j = 0; j < c; j++) {
                    switch (s.charAt(j)) {
                        case '+':
                            city[i][j] = State.ANY_DIRECTION;
                            break;
                        case '-':
                            city[i][j] = State.EAST_OR_WEST;
                            break;
                        case '|':
                            city[i][j] = State.NORTH_OR_SOUTH;
                            break;
                        default:
                            city[i][j] = State.UNUSABLE;
                            break;
                    }
                }
            }

            if (r == 1 && c == 1) {
                System.out.println(1);
                continue;
            }

            Queue<Pt> q = new ArrayDeque<>();
            Pt begin = new Pt(0, 0);
            q.add(begin);
            boolean[][] seen = new boolean[r][c];
            seen[0][0] = true;
            int n = 1;
            int ans = -1;
            f:
            while (!q.isEmpty()) {
                int xx = q.size();
                while (xx-- > 0) {
                    Pt p = q.poll();
                    switch (city[p.y][p.x]) {
                        case ANY_DIRECTION:
                            if (x(p.x, p.y + 1, q, seen, city) || x(p.x, p.y - 1, q, seen, city) || x(p.x + 1, p.y, q, seen, city) || x(p.x - 1, p.y, q, seen, city)) {
                                ans = n + 1;
                                break f;
                            }
                            break;
                        case EAST_OR_WEST:
                            if (x(p.x + 1, p.y, q, seen, city) || x(p.x - 1, p.y, q, seen, city)) {
                                ans = n + 1;
                                break f;
                            }
                            break;
                        case NORTH_OR_SOUTH:
                            if (x(p.x, p.y + 1, q, seen, city) || x(p.x, p.y - 1, q, seen, city)) {
                                ans = n + 1;
                                break f;
                            }
                            break;
                    }
                }

                n++;
            }

            System.out.println(ans);
        }
    }

    static boolean x(int x, int y, Queue<Pt> q, boolean[][] seen, State[][] ss) {
        if (x < 0 || x >= seen[0].length) return false;
        if (y < 0 || y >= seen.length) return false;
        if (ss[y][x] == State.UNUSABLE) return false;
        if (seen[y][x]) return false;
        if (x == seen[0].length - 1 && y == seen.length - 1) return true;
        q.add(new Pt(x, y));
        seen[y][x] = true;
        return false;
    }

    private static class Pt {
        int x;
        int y;

        Pt(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private enum State {
        ANY_DIRECTION,
        EAST_OR_WEST,
        NORTH_OR_SOUTH,
        UNUSABLE,
    }
}
