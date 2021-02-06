package ccc_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class J5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int pageNumber = Integer.parseInt(reader.readLine());
        int[][] pageData = new int[pageNumber][];

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < pageNumber; i++) {
            int numOptions = readInt(reader, buffer);
            int[] optionArr = new int[numOptions];
            for (int j = 0; j < numOptions; j++) optionArr[j] = readInt(reader, buffer);

            pageData[i] = optionArr;
        }
    }

    private static int readInt(BufferedReader reader, StringBuilder buffer) throws IOException {
        consumeLeadingSpaces(reader);

        while (true) {
            reader.mark(1);
            int c = reader.read();
            if (Character.isDigit(c)) {
                buffer.append((char) c);
                continue;
            }
            if (c == '\n' || c == ' ' || c == -1) {
                // Backtrack to the position the reader was at before this iteration.
                reader.reset();
                int parsed = Integer.parseInt(buffer.toString());
                buffer.setLength(0);
                return parsed;
            }

            throw new Error("Character read from the reader was not a newline, space character, or digit. This should never happen.");
        }
    }

    private static void consumeLeadingSpaces(BufferedReader reader) throws IOException {
        while (true) {
            reader.mark(1);

            int c = reader.read();
            if (c != '\n' && c != ' ') {
                // Backtrack to the position the reader was at before this iteration.
                reader.reset();
                break;
            }
        }
    }

    private static class PageVisitor {
        private final List<List<Integer>> pageData;
        private final Set<Integer> visitedPages = new HashSet<>();
        private final Set<Integer> reachablePages = new HashSet<>();

        public PageVisitor(List<List<Integer>> pageData) {
            this.pageData = pageData;
        }

        public void visitPage(int pageNumber, List<Integer> pageData) {
            if (this.visitedPages.contains(pageNumber)) return;
            this.reachablePages.addAll(pageData);
        }
    }
}
