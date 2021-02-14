package ccc_2013;

import java.util.*;

public class J5 {
    private static final Set<String> ALL_GAMES = new HashSet<>(Arrays.asList("1:2", "1:3", "1:4", "2:3", "2:4", "3:4"));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int favoriteTeam = scanner.nextInt();
        int gamesPlayed = scanner.nextInt();
        scanner.skip("\n");

        Set<String> playedGames = new HashSet<>();
        Map<Integer, Integer> teamPoints = new HashMap<>();
        for (int i = 0; i < gamesPlayed; i++) {
            String[] parts = scanner.nextLine().split(" ");
            int teamA = Integer.parseInt(parts[0]);
            int teamB = Integer.parseInt(parts[1]);
            int scoreA = Integer.parseInt(parts[2]);
            int scoreB = Integer.parseInt(parts[3]);

            if (scoreA > scoreB) {
                teamPoints.merge(teamA, 3, Integer::sum);
            } else if (scoreA == scoreB) {
                teamPoints.merge(teamA, 1, Integer::sum);
                teamPoints.merge(teamB, 1, Integer::sum);
            } else {
                teamPoints.merge(teamB, 3, Integer::sum);
            }

            playedGames.add(generateKey(teamA, teamB));
        }

        Set<String> remainingGames = new HashSet<>(ALL_GAMES);
        remainingGames.removeIf(playedGames::contains);

        Queue<Map<Integer, Integer>> possibleFinalPoints = new LinkedList<>();
        possibleFinalPoints.add(teamPoints);
        for (String gameKey : remainingGames) {
            String[] parts = gameKey.split(":");
            int teamA = Integer.parseInt(parts[0]);
            int teamB = Integer.parseInt(parts[1]);

            int levelBreadth = possibleFinalPoints.size();
            while (levelBreadth-- > 0) {
                Map<Integer, Integer> scores = possibleFinalPoints.poll();
                assert scores != null;

                Map<Integer, Integer> pointsAfterTeamAWin = new HashMap<>(scores);
                pointsAfterTeamAWin.merge(teamA, 3, Integer::sum);
                possibleFinalPoints.add(pointsAfterTeamAWin);

                Map<Integer, Integer> pointsAfterTeamBWin = new HashMap<>(scores);
                pointsAfterTeamBWin.merge(teamB, 3, Integer::sum);
                possibleFinalPoints.add(pointsAfterTeamBWin);

                Map<Integer, Integer> pointsAfterTie = new HashMap<>(scores);
                pointsAfterTie.merge(teamA, 1, Integer::sum);
                pointsAfterTie.merge(teamB, 1, Integer::sum);
                possibleFinalPoints.add(pointsAfterTie);
            }
        }

        int scenariosWhereFavoriteTeamWins = 0;
        outer:
        for (Map<Integer, Integer> finalPoints : possibleFinalPoints) {
            int favoriteTeamPoints = finalPoints.getOrDefault(favoriteTeam, 0);
            for (Map.Entry<Integer, Integer> entry : finalPoints.entrySet()) {
                if (entry.getKey() == favoriteTeam) continue;
                if (entry.getValue() >= favoriteTeamPoints) continue outer;
            }

            ++scenariosWhereFavoriteTeamWins;
        }

        System.out.println(scenariosWhereFavoriteTeamWins);
    }

    private static String generateKey(int teamA, int teamB) {
        return Math.min(teamA, teamB) + ":" + Math.max(teamA, teamB);
    }
}
