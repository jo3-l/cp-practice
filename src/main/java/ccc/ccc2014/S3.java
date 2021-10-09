package ccc.ccc2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] cars = new int[N];
            for (int i = 0; i < N; i++) cars[i] = Integer.parseInt(br.readLine());

            List<Integer> lake = new ArrayList<>();
            List<Integer> branch = new ArrayList<>();
            int expect = 1;

            for (int i = N - 1; i >= 0; i--) {
                int car = cars[i];
                while (!branch.isEmpty()) {
                    int last = branch.get(branch.size() - 1);
                    if (last != expect) break;
                    lake.add(branch.remove(branch.size() - 1));
                    expect++;
                }

                if (car == expect) {
                    lake.add(car);
                    expect++;
                } else {
                    branch.add(car);
                }
            }

            while (!branch.isEmpty()) {
                int last = branch.get(branch.size() - 1);
                if (last != expect) break;
                lake.add(branch.remove(branch.size() - 1));
                expect++;
            }

            System.out.println(lake.size() == N ? "Y" : "N");
        }
    }
}
