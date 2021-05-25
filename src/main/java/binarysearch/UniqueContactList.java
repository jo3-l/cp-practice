package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class UniqueContactList {
    public int solve(String[][] contacts) {
        Set<String> seen = new HashSet<>();

        int uniq = contacts.length;
        for (String[] emails : contacts) {
            boolean dupe = false;
            for (String email : emails) {
                if (!dupe && seen.contains(email)) {
                    uniq--;
                    dupe = true;
                }
                seen.add(email);
            }
        }

        return uniq;
    }
}
