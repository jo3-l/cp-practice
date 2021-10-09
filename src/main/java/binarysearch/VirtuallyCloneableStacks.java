package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class VirtuallyCloneableStacks {
    private List<Integer> x = new ArrayList<>();

    public VirtuallyCloneableStacks() {
        x.add(0);
    }

    public void copyPush(int i) {
        x.add(x.get(i) + 1);
    }

    public void copyPop(int i) {
        x.add(x.get(i) - 1);
    }

    public int size(int i) {
        return x.get(i);
    }
}
