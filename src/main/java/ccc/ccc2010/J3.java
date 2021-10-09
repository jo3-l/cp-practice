package ccc.ccc2010;

import java.util.Scanner;

public class J3 {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(" ");
            int opcode = Integer.parseInt(parts[0]);
            char operand = parts.length > 1 ? parts[1].charAt(0) : 0;
            String arg = parts.length > 2 ? parts[2] : "";

            switch (opcode) {
                case 1: {
                    int v = Integer.parseInt(arg);
                    if (operand == 'A') a = v;
                    else b = v;

                    break;
                }
                case 2: {
                    System.out.println(operand == 'A' ? a : b);
                    break;
                }
                case 3: {
                    int rhsValue = arg.equals("A") ? a : b;
                    if (operand == 'A') a += rhsValue;
                    else b += rhsValue;

                    break;
                }
                case 4: {
                    int rhsValue = arg.equals("A") ? a : b;
                    if (operand == 'A') a *= rhsValue;
                    else b *= rhsValue;

                    break;
                }
                case 5: {
                    int rhsValue = arg.equals("A") ? a : b;
                    if (operand == 'A') a -= rhsValue;
                    else b -= rhsValue;

                    break;
                }
                case 6: {
                    int rhsValue = arg.equals("A") ? a : b;
                    if (operand == 'A') a /= rhsValue;
                    else b /= rhsValue;

                    break;
                }
                default:
                    return;
            }
        }
    }
}
