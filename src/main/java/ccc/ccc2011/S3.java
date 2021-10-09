package ccc.ccc2011;

import java.util.Scanner;

public class S3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int m = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(check(m, x, y) ? "crystal" : "empty");
        }
    }

    private static boolean check(int m, int x, int y) {
        if (m == 0) return false;

        // regardless of magnification level, we can always separate the grid into 5*5 sectors.
        // let us number them as follows:
        // 20   21   22   23   24
        // 15   16   17   18   19
        // 10   11   12   13   14
        // 5    6    7    8    9
        // 0    1    2    3    4
        //
        // we can observe the following:
        // 1. if (x, y) is in sector 0, 4, 5, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, or 24 it is guaranteed not to
        // be part of the crystal image.
        // 2. if (x, y) is in sector 1, 2, 3 or 7, it is guaranteed to be part of the crystal image.
        // 3. if (x, y) is in sector 6, 12, or 8, the contents of that sector itself is the image with a magnification level
        // 1 less than the current one. we can then apply the rules above recursively to that sector.
        int sectorSize = (int) Math.pow(5, m - 1);
        int col = x / sectorSize;
        int row = y / sectorSize;
        int sector = row * 5 + col;
        switch (sector) {
            case 1:
            case 2:
            case 3:
            case 7:
                return true;
            case 6:
            case 12:
            case 8:
                return check(m - 1, x % sectorSize, y % sectorSize);
            default:
                return false;
        }
    }
}
