package ccc2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class J5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int pageCount = Integer.parseInt(reader.readLine());
        int[][] pageData = new int[pageCount][];
        PageVisitor visitor = new PageVisitor(pageData);

        StringBuilder buffer = new StringBuilder();
        for (int pageNumber = 0; pageNumber < pageCount; pageNumber++) {
            for (int c = reader.read(); Character.isDigit(c); c = reader.read()) buffer.append((char) c);
            int branchCount = Integer.parseInt(buffer.toString());
            buffer.setLength(0);

            int[] branches = new int[branchCount];
            for (int i = 0; i < branchCount; i++) {
                for (int c = reader.read(); Character.isDigit(c); c = reader.read()) buffer.append((char) c);
                // -1 as pages are provided as 1-based integers.
                branches[i] = Integer.parseInt(buffer.toString()) - 1;
                buffer.setLength(0);
            }

            visitor.visitPage(pageNumber, branches, pageNumber == 0);
            pageData[pageNumber] = branches;
        }

        System.out.println(visitor.canVisitAll() ? "Y" : "N");
        System.out.println(getShortestPath(pageData));
    }

    private static int getShortestPath(int[][] pageData) {
        Set<Integer> visitedPages = new HashSet<>();
        Queue<Integer> pageQueue = new LinkedList<>();
        pageQueue.add(0);
        visitedPages.add(0);

        int depth = 1;
        while (!pageQueue.isEmpty()) {
            int levelBreadth = pageQueue.size();
            // Process all nodes in the the current level before moving on.
            while (levelBreadth-- > 0) {
                int pageNumber = pageQueue.poll();
                int[] branches = pageData[pageNumber];
                if (branches.length == 0) return depth;

                for (int branchPageNumber : branches) {
                    if (visitedPages.contains(branchPageNumber)) continue;
                    visitedPages.add(branchPageNumber);
                    pageQueue.add(branchPageNumber);
                }
            }
            depth++;
        }

        throw new IllegalStateException();
    }

    private static class PageVisitor {
        private final int[][] pageData;
        private final Set<Integer> visitedPages = new HashSet<>();
        private final Set<Integer> pageVisitQueue = new HashSet<>();

        public PageVisitor(int[][] pageData) {
            this.pageData = pageData;
        }

        public boolean canVisitAll() {
            return visitedPages.size() == pageData.length;
        }

        public void visitPage(int pageNumber, int[] branches, boolean canNaturallyReach) {
            // If this page number was queued from an earlier call, we can override some checks.
            boolean isQueued = pageVisitQueue.contains(pageNumber);
            if (isQueued) pageVisitQueue.remove(pageNumber);
            if ((!canNaturallyReach && !isQueued) || (visitedPages.contains(pageNumber) && !isQueued)) return;
            for (int branchPageNumber : branches) {
                // visitPage is called when pageData may not be fully populated. However, we can be sure that we have the
                // data for the current page, meaning that all pages with lower page numbers have complete data.
                if (pageNumber > branchPageNumber) visitPage(branchPageNumber, pageData[branchPageNumber], true);
                    // If we don't have the complete data, then add it to the visit queue and wait for visitPage() to be called
                    // with that page number later.
                else pageVisitQueue.add(branchPageNumber);

                visitedPages.add(branchPageNumber);
            }
            // Finally, add the current page to the set of visited ones.
            visitedPages.add(pageNumber);
        }
    }
}
