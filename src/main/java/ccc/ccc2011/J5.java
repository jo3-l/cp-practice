package ccc.ccc2011;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class J5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] inviters = new int[N + 1]; // index = inviter ID, value = people invited, in form of bitset
        for (int invited = 1; invited < N; invited++) {
            int inviter = sc.nextInt();
            inviters[inviter] |= 1 << invited;
        }

        Set<Integer> deletions = new HashSet<>();
        deletions.add(0); // delete nothing
        for (int id = 1; id < N; id++) {
            deletions.add(rmRecursive(inviters, id, N, 0));
        }

        while (true) {
            Set<Integer> nextGen = new HashSet<>(deletions);
            for (int first : deletions) {
                for (int second : deletions) {
                    int combined = first | second;
                    nextGen.add(combined);
                }
            }

            if (nextGen.size() == deletions.size()) break;
            deletions = nextGen;
        }

        System.out.println(deletions.size());
    }

    private static int rmRecursive(int[] inviters, int remove, int N, int removed) {
        removed |= 1 << remove;
        int bs = inviters[remove];
        if (bs == 0) return removed;
        for (int id = 1; id < N; id++) {
            if ((bs & (1 << id)) != 0) removed = rmRecursive(inviters, id, N, removed);
        }

        return removed;
    }
}
