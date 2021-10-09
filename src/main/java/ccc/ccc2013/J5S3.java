package ccc.ccc2013;

import java.util.*;

public class J5S3 {
    private static final Set<TeamPairing> ALL_GAMES = new HashSet<>(
            Arrays.asList(
                    new TeamPairing(1, 2),
                    new TeamPairing(1, 3),
                    new TeamPairing(1, 4),
                    new TeamPairing(2, 3),
                    new TeamPairing(2, 4),
                    new TeamPairing(3, 4)
            )
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int favoriteTeam = scanner.nextInt();
        int gamesPlayed = scanner.nextInt();
        scanner.skip("\n");

        Set<TeamPairing> playedGames = new HashSet<>();
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

            playedGames.add(new TeamPairing(teamA, teamB));
        }

        Set<TeamPairing> remainingGames = new HashSet<>(ALL_GAMES);
        remainingGames.removeIf(playedGames::contains);

        Queue<Map<Integer, Integer>> possibleFinalPoints = new LinkedList<>();
        possibleFinalPoints.add(teamPoints);
        for (TeamPairing pairing : remainingGames) {
            int levelBreadth = possibleFinalPoints.size();
            // Process all nodes in the current level before moving on.
            while (levelBreadth-- > 0) {
                Map<Integer, Integer> scores = possibleFinalPoints.poll();

                Map<Integer, Integer> pointsAfterTeamAWin = new HashMap<>(scores);
                pointsAfterTeamAWin.merge(pairing.teamA, 3, Integer::sum);
                possibleFinalPoints.add(pointsAfterTeamAWin);

                Map<Integer, Integer> pointsAfterTeamBWin = new HashMap<>(scores);
                pointsAfterTeamBWin.merge(pairing.teamB, 3, Integer::sum);
                possibleFinalPoints.add(pointsAfterTeamBWin);

                Map<Integer, Integer> pointsAfterTie = new HashMap<>(scores);
                pointsAfterTie.merge(pairing.teamA, 1, Integer::sum);
                pointsAfterTie.merge(pairing.teamB, 1, Integer::sum);
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

    private static class TeamPairing {
        public final int teamA;
        public final int teamB;

        public TeamPairing(int teamA, int teamB) {
            if (teamA > teamB) {
                int tmp = teamB;
                teamB = teamA;
                teamA = tmp;
            }

            this.teamA = teamA;
            this.teamB = teamB;
        }

        @Override
        public int hashCode() {
            return Objects.hash(teamA, teamB);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof TeamPairing)) return false;
            TeamPairing objCast = (TeamPairing) obj;
            return objCast.teamA == teamA && objCast.teamB == teamB;
        }
    }
}
