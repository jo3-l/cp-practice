package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class UnixPathResolution {
    public String[] solve(String[] path) {
        List<String> dirs = new ArrayList<>();
        for (String instruction : path) {
            if (instruction.equals("..")) {
                if (!dirs.isEmpty()) dirs.remove(dirs.size() - 1);
            } else if (!instruction.equals(".")) {
                dirs.add(instruction);
            }
        }

        String[] ret = new String[dirs.size()];
        for (int i = 0; i < dirs.size(); i++) ret[i] = dirs.get(i);
        return ret;
    }
}
