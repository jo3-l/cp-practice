package ccc2015;

import java.util.Scanner;

public class J5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int piecesOfPie = scanner.nextInt();
        int people = scanner.nextInt();

        System.out.println(ways(piecesOfPie, people, 0));
    }

    private static int ways(int piecesOfPie, int people, int lastPersonPieces) {
        if (piecesOfPie < people) return 0;
        if (people == 1 || people == piecesOfPie) return 1;

        int maxPieFirstPerson = Math.floorDiv(piecesOfPie, people);
        if (maxPieFirstPerson < lastPersonPieces) return 0;

        int count = 0;
        int begin = lastPersonPieces == 0 ? 1 : lastPersonPieces;
        for (int i = begin; i <= maxPieFirstPerson; i++) count += ways(piecesOfPie - i, people - 1, i);

        return count;
    }
}
