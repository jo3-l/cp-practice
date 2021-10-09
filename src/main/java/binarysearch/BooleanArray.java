package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class BooleanArray {
    private boolean defaultValue = false;
    private Set<Integer> overrides = new HashSet<>();

    public void setTrue(int i) {
        if (defaultValue == false) overrides.add(i);
        else overrides.remove(i);
    }

    public void setFalse(int i) {
        if (defaultValue == true) overrides.add(i);
        else overrides.remove(i);
    }

    public void setAllTrue() {
        overrides.clear();
        defaultValue = true;
    }

    public void setAllFalse() {
        overrides.clear();
        defaultValue = false;
    }

    public boolean getValue(int i) {
        return overrides.contains(i)
                ? !defaultValue
                : defaultValue;
    }
}
