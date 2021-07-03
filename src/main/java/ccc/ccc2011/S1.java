package ccc.ccc2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int nt = 0;
        int ns = 0;
        while (N-- > 0) {
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case 't':
                    case 'T':
                        nt++;
                        break;
                    case 's':
                    case 'S':
                        ns++;
                        break;
                }
            }
        }

        System.out.println(nt <= ns ? "French" : "English");
    }
}
