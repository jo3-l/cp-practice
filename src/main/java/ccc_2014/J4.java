package ccc_2014;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class J4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int friendCount = scanner.nextInt();

        List<Integer> friendNumbers = new LinkedList<>();
        for (int i = 1; i <= friendCount; i++) friendNumbers.add(i);

        int roundCount = scanner.nextInt();
        for (int i = 0; i < roundCount; i++) {
            int roundValue = scanner.nextInt();
            ListIterator<Integer> it = friendNumbers.listIterator();
            // Note that we can't use ListIterator#nextIndex() to keep track of the position as we are mutating the list
            // during iteration.
            int position = 0;
            while (it.hasNext()) {
                it.next();
                ++position;
                if (position % roundValue == 0) it.remove();
            }
        }

        for (int friendNumber : friendNumbers) System.out.println(friendNumber);
    }
}
