package binarysearch;

public class RecursiveVoting {
    public int solve(int[] votes) {
        int n = 0;
        for (int vote : votes) {
            int p = find(vote, votes);
            if (p < 0) n++;
        }
        return n;
    }

    private int find(int i, int[] votes) {
        if (i < 0) return -1;
        if (i >= votes.length) return votes.length;
        return votes[i] = find(votes[i], votes);
    }
}
