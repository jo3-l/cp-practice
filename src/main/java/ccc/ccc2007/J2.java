package ccc.ccc2007;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class J2 {
    public static void main(String[] args) {
        Map<String, String> table = new HashMap<>();
        table.put("CU", "see you");
        table.put(":-)", "I'm happy");
        table.put(":-(", "I'm unhappy");
        table.put(";-)", "wink");
        table.put(":-P", "stick out my tongue");
        table.put("( ̃. ̃)", "sleepy");
        table.put("TA", "totally awesome");
        table.put("CCC", "Canadian Computing Competition");
        table.put("CUZ", "because");
        table.put("ty", "thank-you");
        table.put("YW", "you're welcome");
        table.put("TTYL", "talk to you later");

        Scanner sc = new Scanner(System.in);
        for (String s = sc.nextLine(); !s.equals("TTYL"); s = sc.nextLine()) {
            System.out.println(table.getOrDefault(s, s));
        }
        System.out.println(table.get("TTYL"));
    }
}
