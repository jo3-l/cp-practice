package ccc.ccc2008;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (String input = sc.nextLine(); !input.equals("0"); input = sc.nextLine()) {
            List<String> stack = new ArrayList<>();
            for (int i = input.length() - 1; i >= 0; i -= 2) {
                char c = input.charAt(i);
                if ('0' <= c && c <= '9') {
                    stack.add(Character.toString(c));
                } else {
                    String op0 = stack.remove(stack.size() - 1);
                    String op1 = stack.remove(stack.size() - 1);
                    stack.add(op0 + " " + op1 + " " + c);
                }
            }
            System.out.println(stack.get(stack.size() - 1));
        }
    }
}
