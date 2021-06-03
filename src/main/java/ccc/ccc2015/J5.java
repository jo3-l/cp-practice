package ccc.ccc2015;

import java.util.Scanner;

public class J5 {
    private static int[][][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int piecesOfPie = scanner.nextInt();
        int people = scanner.nextInt();
        dp = new int[piecesOfPie + 1][people + 1][piecesOfPie + 1];

        System.out.println(ways(piecesOfPie, people, 0));
    }

    private static int ways(int piecesOfPie, int people, int lastPersonPieces) {
        if (piecesOfPie < people) return dp[piecesOfPie][people][lastPersonPieces] = 0;
        if (people == 1 || people == piecesOfPie) return dp[piecesOfPie][people][lastPersonPieces] = 1;
        if (dp[piecesOfPie][people][lastPersonPieces] != 0) return dp[piecesOfPie][people][lastPersonPieces];

        int maxPieFirstPerson = piecesOfPie / people;
        if (maxPieFirstPerson < lastPersonPieces) return dp[piecesOfPie][people][lastPersonPieces] = 0;

        int count = 0;
        int begin = lastPersonPieces == 0 ? 1 : lastPersonPieces;
        for (int p = begin; p <= maxPieFirstPerson; p++) count += ways(piecesOfPie - p, people - 1, p);

        return dp[piecesOfPie][people][lastPersonPieces] = count;
    }
}
