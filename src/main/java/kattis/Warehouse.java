package kattis;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Warehouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int shipmentCount = scanner.nextInt();
            scanner.skip("\n");

            Map<String, Integer> shipments = new HashMap<>();
            for (int j = 0; j < shipmentCount; j++) {
                String[] parts = scanner.nextLine().split(" ");
                shipments.merge(parts[0], Integer.parseInt(parts[1]), Integer::sum);
            }

            System.out.println(shipments.size());
            shipments.entrySet()
                    .stream()
                    .sorted((a, b) -> {
                        int diff = b.getValue() - a.getValue();
                        if (diff != 0) return diff;
                        return String.CASE_INSENSITIVE_ORDER.compare(a.getKey(), b.getKey());
                    })
                    .forEach((entry) -> System.out.println(entry.getKey() + " " + entry.getValue()));
        }
    }
}
