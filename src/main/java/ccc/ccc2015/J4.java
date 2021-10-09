package ccc.ccc2015;

import java.util.*;

public class J4 {
    @SuppressWarnings("lgtm[java/index-out-of-bounds]")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int entryCount = scanner.nextInt();
        scanner.skip("\n");

        BitSet elapsedTimeEntryIndices = new BitSet();
        Entry[] entries = new Entry[entryCount];
        for (int i = 0; i < entryCount; i++) {
            String[] parts = scanner.nextLine().split(" ");
            EntryType entryType = EntryType.from(parts[0].charAt(0));
            int data = Integer.parseInt(parts[1]);

            entries[i] = new Entry(entryType, data);
            if (entryType == EntryType.TIME_ELAPSED) elapsedTimeEntryIndices.set(i);
        }

        SortedMap<Integer, Integer> totalWaitTimes = new TreeMap<>();
        Map<Integer, Integer> messageSentTimes = new HashMap<>();

        int timeElapsed = 0;
        int i = 0;
        while (i < entryCount) {
            Entry entry = entries[i];
            if (entry.type == EntryType.MESSAGE_RECEIVED) {
                messageSentTimes.put(entry.data, timeElapsed);
            } else {
                int messageSentTime = messageSentTimes.get(entry.data);
                totalWaitTimes.merge(entry.data, timeElapsed - messageSentTime, Integer::sum);
                messageSentTimes.remove(entry.data);
            }

            if (elapsedTimeEntryIndices.get(i + 1)) {
                timeElapsed += entries[i + 1].data;
                // Skip over time elapsed entry.
                i += 2;
            } else {
                ++timeElapsed;
                ++i;
            }
        }

        for (int friendNumber : messageSentTimes.keySet()) totalWaitTimes.put(friendNumber, -1);
        for (SortedMap.Entry<Integer, Integer> entry : totalWaitTimes.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private enum EntryType {
        MESSAGE_RECEIVED,
        MESSAGE_SENT,
        TIME_ELAPSED;

        public static EntryType from(char c) {
            switch (c) {
                case 'R':
                    return MESSAGE_RECEIVED;
                case 'S':
                    return MESSAGE_SENT;
                case 'W':
                    return TIME_ELAPSED;
                default:
                    throw new IllegalArgumentException("Argument passed to EntryType.from() was not one of 'R', 'S' or 'W'.");
            }
        }
    }

    private static class Entry {
        public final EntryType type;
        public final int data;

        public Entry(EntryType type, int data) {
            this.type = type;
            this.data = data;
        }
    }
}
