package ccc.ccc2008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE;
        String name = "";
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp < min) {
                min = tmp;
                name = c;
            }
            if (c.equals("Waterloo")) break;
        }
        System.out.println(name);
    }
}
