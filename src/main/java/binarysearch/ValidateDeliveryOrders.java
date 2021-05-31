package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class ValidateDeliveryOrders {
    public boolean solve(String[] orders) {
        Set<Integer> delivered = new HashSet<>();
        Set<Integer> waiting = new HashSet<>();
        for (String order : orders) {
            int v = Integer.parseInt(order.substring(1));
            switch (order.charAt(0)) {
                case 'P':
                    if (delivered.contains(v)) return false;
                    if (!waiting.add(v)) return false;
                    break;
                case 'D':
                    if (!waiting.remove(v)) return false;
                    delivered.add(v);
                    break;
            }
        }

        return waiting.isEmpty();
    }
}
