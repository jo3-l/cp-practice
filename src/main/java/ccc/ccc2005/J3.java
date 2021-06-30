package ccc.ccc2005;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class J3 {
    public static void main(String[] args) {
        List<String> inst = new ArrayList<>();
        inst.add("HOME");
        Scanner sc = new Scanner(System.in);
        for (String s = sc.nextLine(); !s.equals("SCHOOL"); s = sc.nextLine()) inst.add(s);
        for (int i = inst.size() - 1; i >= 0; i -= 2) {
            String direction = inst.get(i);
            String place = inst.get(i - 1);
            String placePart = place.equals("HOME") ? "into your HOME" : "onto " + place + " street";
            System.out.println("Turn " + (direction.charAt(0) == 'L' ? "RIGHT" : "LEFT") + " " + placePart + ".");
        }
    }
}
