package ccc.ccc2014;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        List<Integer> p = new ArrayList<>(K);
        for (int i = 0; i < K; i++) p.add(i + 1);
        int m = sc.nextInt();
        while (m-- > 0) {
            int r = sc.nextInt();
            List<Integer> n = new ArrayList<>();
            for (int i = 0; i < p.size(); i++) {
                int pos = i + 1;
                if (pos % r != 0) n.add(p.get(i));
            }
            p = n;
        }

        p.forEach(System.out::println);
    }
}
