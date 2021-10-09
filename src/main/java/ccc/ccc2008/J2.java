package ccc.ccc2008;

import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        char[] playlist = {'A', 'B', 'C', 'D', 'E'};

        Scanner sc = new Scanner(System.in);
        int btn = sc.nextLine().charAt(0) - '0';
        while (btn != 4) {
            int presses = sc.nextLine().charAt(0) - '0';
            while (presses-- > 0) {
                switch (btn) {
                    case 1: {
                        char first = playlist[0];
                        System.arraycopy(playlist, 1, playlist, 0, playlist.length - 1);
                        playlist[playlist.length - 1] = first;
                        break;
                    }
                    case 2: {
                        char last = playlist[playlist.length - 1];
                        System.arraycopy(playlist, 0, playlist, 1, playlist.length - 1);
                        playlist[0] = last;
                        break;
                    }
                    case 3: {
                        char tmp = playlist[0];
                        playlist[0] = playlist[1];
                        playlist[1] = tmp;
                        break;
                    }
                }
            }

            btn = sc.nextLine().charAt(0) - '0';
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < playlist.length; i++) {
            if (i > 0) sb.append(' ');
            sb.append(playlist[i]);
        }
        System.out.println(sb);
    }
}
