package ccc.ccc2009;

import java.util.Scanner;

public class J3 {
    private static final Tz[] tzs = new Tz[]{
            new Tz("Ottawa", 0),
            new Tz("Victoria", -300),
            new Tz("Edmonton", -200),
            new Tz("Winnipeg", -100),
            new Tz("Toronto", 0),
            new Tz("Halifax", 100),
            new Tz("St. John's", 130)
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (Tz tz : tzs) {
            int lt = t + tz.adj;
            if (lt < 0) lt += 2400;
            if (lt >= 2400) lt -= 2400;
            if (lt % 100 >= 60) {
                int h = lt / 100;
                lt = (h + 1) * 100 + (lt % 100) % 60;
            }
            System.out.println(lt + " in " + tz.name);
        }
    }

    private static class Tz {
        public String name;
        public int adj;

        public Tz(String name, int adj) {
            this.name = name;
            this.adj = adj;
        }
    }
}
