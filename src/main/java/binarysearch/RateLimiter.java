package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    private Map<Integer, Integer> reqs = new HashMap<>();
    private int expire;

    public RateLimiter(int expire) {
        this.expire = expire;
    }

    public boolean limit(int uid, int timestamp) {
        if (!reqs.containsKey(uid)) {
            reqs.put(uid, timestamp);
            return false;
        }

        int ts = reqs.get(uid);
        if (timestamp - ts < expire) return true;
        reqs.put(uid, timestamp);
        return false;
    }
}
