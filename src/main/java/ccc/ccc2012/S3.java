package ccc.ccc2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Reading[] buckets = new Reading[1001];
        while (N-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (buckets[n] == null) buckets[n] = new Reading(n);
            buckets[n].freq++;
        }
        List<Reading> mostFrequentReadings = new ArrayList<>();
        List<Reading> secondMostFrequentReadings = new ArrayList<>();
        for (Reading reading : buckets) {
            if (reading == null) continue;
            if (mostFrequentReadings.isEmpty() || reading.freq > mostFrequentReadings.get(0).freq) {
                secondMostFrequentReadings = mostFrequentReadings;
                mostFrequentReadings = new ArrayList<>();
                mostFrequentReadings.add(reading);
            } else if (reading.freq == mostFrequentReadings.get(0).freq) {
                mostFrequentReadings.add(reading);
            } else if (secondMostFrequentReadings.isEmpty() || reading.freq > secondMostFrequentReadings.get(0).freq) {
                secondMostFrequentReadings.clear();
                secondMostFrequentReadings.add(reading);
            } else if (reading.freq == secondMostFrequentReadings.get(0).freq) {
                secondMostFrequentReadings.add(reading);
            }
        }

        int best = Integer.MIN_VALUE;
        if (mostFrequentReadings.size() > 1) {
            for (int i = 0; i < mostFrequentReadings.size(); i++) {
                for (int j = i + 1; j < mostFrequentReadings.size(); j++) {
                    best = Math.max(best, Math.abs(mostFrequentReadings.get(i).reading - mostFrequentReadings.get(j).reading));
                }
            }
            System.out.println(best);
            return;
        }

        for (Reading f0 : mostFrequentReadings) {
            for (Reading f1 : secondMostFrequentReadings) {
                best = Math.max(best, Math.abs(f0.reading - f1.reading));
            }
        }
        System.out.println(best);
    }

    private static class Reading {
        public int reading;
        public int freq;

        public Reading(int reading) {
            this.reading = reading;
        }
    }
}
