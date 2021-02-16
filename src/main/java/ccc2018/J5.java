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
            int branchCount = readInt(reader, buffer);
            int[] branches = new int[branchCount];
            // Subtract 1 because the page numbers are 1-based.
            for (int i = 0; i < branchCount; i++) branches[i] = readInt(reader, buffer) - 1;

            // We can always visit the first page; for other pages, we do not have sufficient information to know whether
            // we can visit it yet.
            visitor.visitPage(pageNumber, branches, pageNumber == 0);
            pageData[pageNumber] = branches;
        }

        System.out.println(visitor.canVisitAll() ? "Y" : "N");
        System.out.println(getShortestPath(pageData));
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
                // We're done with the integer, so backtrack to the position the reader was at before this iteration.
                reader.reset();
                int parsed = Integer.parseInt(buffer.toString());
                buffer.setLength(0);
                return parsed;
            }
            throw new Error("Character read from the reader was not a newline, space, or digit. This should never happen.");
        }
    }

    // getShortestPath returns the shortest path a reader can take before they get to the end of a branch, using a breadth
    // first search internally to traverse the graph efficiently.
    private static int getShortestPath(int[][] pageData) {
        Set<Integer> visitedPages = new HashSet<>();
        Queue<Integer> pageQueue = new LinkedList<>();
        pageQueue.add(0);
        visitedPages.add(0);

        // Depth we're at currently (the page count of the branch).
        int depth = 1;
        while (!pageQueue.isEmpty()) {
            int levelBreadth = pageQueue.size();
            // Exhaust all nodes in the the current level before moving on.
            while (levelBreadth-- > 0) {
                int pageNumber = pageQueue.poll();
                int[] branches = pageData[pageNumber];
                // If we've reached a page with no branches, it is the end of a branch. Due to the fact that we're using
                // a breadth-first search, this must be the lowest possible depth.
                if (branches.length == 0) return depth;
                for (int branchPageNumber : branches) {
                    if (visitedPages.contains(branchPageNumber)) continue;
                    visitedPages.add(branchPageNumber);
                    pageQueue.add(branchPageNumber);
                }
            }
            depth++;
        }

        throw new Error("Could not determine shortest path. This should never happen!");
    }

    // consumeLeadingSpaces consumes all leading space and newline characters from the BufferedReader provided.
    private static void consumeLeadingSpaces(BufferedReader reader) throws IOException {
        while (true) {
            reader.mark(1);
            int c = reader.read();
            if (c == '\n' || c == ' ') continue;

            // No more space characters, so backtrack to the position the reader was at before this iteration.
            reader.reset();
            break;
        }
    }

    // The PageVisitor is responsible for checking whether all pages can be reached.
    private static class PageVisitor {
        private final int[][] pageData;
        private final Set<Integer> visitedPages = new HashSet<>();
        private final Set<Integer> visitQueue = new HashSet<>();

        public PageVisitor(int[][] pageData) {
            this.pageData = pageData;
        }

        // canReachAll reports whether all pages have been visited using some combination or another.
        // It will only return an accurate result when visitPage has been called for all pages.
        public boolean canVisitAll() {
            return visitedPages.size() == pageData.length;
        }

        // visitPage is called sequentially with the page number, the "branches" (possible pages that can be moved to)
        // and whether we know that this page can be reached naturally through some combination of other pages.
        // Typically, the last argument will be false, as we don't have enough information, but for some edge cases (i.e. the first page,
        // which we start from) it will be true.
        public void visitPage(int pageNumber, int[] branches, boolean canNaturallyReach) {
            // If this page number was queued from an earlier call, we can override some checks.
            boolean isQueued = visitQueue.contains(pageNumber);
            if (isQueued) visitQueue.remove(pageNumber);
            if ((!canNaturallyReach && !isQueued) || (visitedPages.contains(pageNumber) && !isQueued)) return;
            for (int branchPageNumber : branches) {
                // visitPage is called when pageData may not be fully populated. However, we can be sure that we have the
                // data for the current page, meaning that all pages with lower page numbers have complete data.
                if (pageNumber > branchPageNumber) visitPage(branchPageNumber, pageData[branchPageNumber], true);
                    // If we don't have the complete data, then add it to the visit queue and wait for it to be called later.
                else visitQueue.add(branchPageNumber);

                // No matter what, know that we can visit this page, so add it to the set of visited ones.
                visitedPages.add(branchPageNumber);
            }
            // Finally, add the current page to the set of visited ones.
            visitedPages.add(pageNumber);
        }
    }
}
