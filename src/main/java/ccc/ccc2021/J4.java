package ccc.ccc2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class J4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int largeCount = 0;
        int mediumCount = 0;
        int smallCount = 0;

        boolean isMaybeSorted = true;
        BookSize lastSize = BookSize.LARGE;

        List<BookSize> arrangement = new ArrayList<>();
        for (int c = reader.read(); c != -1 && c != '\n'; c = reader.read()) {
            BookSize size = BookSize.from(c);
            arrangement.add(size);
            if (size == BookSize.LARGE) ++largeCount;
            else if (size == BookSize.MEDIUM) ++mediumCount;
            else ++smallCount;

            if (isMaybeSorted && size.ordinal() > lastSize.ordinal()) isMaybeSorted = false;
            lastSize = size;
        }

        if (isMaybeSorted) {
            System.out.println(0);
            return;
        }

        int swapsMade = 0;

        // In the sorted arrangement of books, the first `largeCount` books should be large books.
        int largeBookSectionBoundary = largeCount - 1;
        int mediumBookSectionBoundary = largeBookSectionBoundary + mediumCount;

        // Shift large-sized books to the front.
        if (largeCount > 0 && (mediumCount > 0 || smallCount > 0)) {
            // A double-ended queue of indices we can move large books in the incorrect position to.
            // The front of the queue is used for indices that contain small books, while the back of the queue is
            // used for indices that contain medium-sized books.
            //
            // We make this distinction as if we have a large book in a slot which should contain a small book, making
            // a swap that results in a small book being moved into this slot is preferable to moving a medium-sized
            // book into this slot.
            Deque<Integer> indices = new ArrayDeque<>();
            for (int i = 0; i < arrangement.size(); i++) {
                BookSize size = arrangement.get(i);
                boolean isLargeBook = size == BookSize.LARGE;
                boolean isInLargeBookSection = i <= largeBookSectionBoundary;

                if (isInLargeBookSection && !isLargeBook) {
                    if (size == BookSize.SMALL) indices.addFirst(i);
                    else indices.addLast(i);
                }  else if (isLargeBook && !isInLargeBookSection) {
                    int swapIndex = i <= mediumBookSectionBoundary
                            ? indices.removeLast() // Prefer an index which contains a medium-sized book, if this slot should contain a medium-sized book
                            : indices.removeFirst(); // Otherwise, prefer an index which contains a small book
                    BookSize swapValue = arrangement.get(swapIndex);
                    arrangement.set(swapIndex, size);
                    arrangement.set(i, swapValue);

                    ++swapsMade;
                }
            }
        }

        if (mediumCount > 0 && smallCount > 0) {
            List<Integer> indices = new ArrayList<>();
            for (int i = largeBookSectionBoundary + 1; i < arrangement.size(); i++) {
                BookSize size = arrangement.get(i);
                boolean isMediumSizedBook = size == BookSize.MEDIUM;
                boolean isInMediumSizedBookSection = i <= mediumBookSectionBoundary;

                if (isInMediumSizedBookSection && !isMediumSizedBook) {
                    indices.add(i);
                } else if (isMediumSizedBook && !isInMediumSizedBookSection) {
                    int swapIndex = indices.remove(indices.size() - 1);
                    arrangement.set(swapIndex, size);
                    arrangement.set(i, BookSize.SMALL);

                    ++swapsMade;
                }
            }
        }

        System.out.println(swapsMade);
    }

    private enum BookSize {
        SMALL,
        MEDIUM,
        LARGE;

        public static BookSize from(int c) {
            switch (c) {
                case 'S':
                    return BookSize.SMALL;
                case 'M':
                    return BookSize.MEDIUM;
                case 'L':
                    return BookSize.LARGE;
                default:
                    throw new IllegalStateException();
            }
        }
    }
}
