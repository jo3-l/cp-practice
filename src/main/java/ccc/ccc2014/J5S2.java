package ccc.ccc2014;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class J5S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentCount = scanner.nextInt();

        String[] names = new String[studentCount];
        for (int i = 0; i < studentCount; i++) {
            String name = scanner.next();
            names[i] = name;
        }

        Map<String, String> pairs = new HashMap<>();
        Map<String, String> inversePairs = new HashMap<>();
        for (int i = 0; i < studentCount; i++) {
            String name = scanner.next();
            String matching = names[i];
            if (matching.equals(name)) {
                System.out.println("bad");
                return;
            }

            pairs.put(name, matching);
            inversePairs.put(name, matching);
        }

        for (Map.Entry<String, String> entry : pairs.entrySet()) {
            if (!inversePairs.get(entry.getValue()).equals(entry.getKey())) {
                System.out.println("bad");
                return;
            }
        }

        System.out.println("good");
    }
}
