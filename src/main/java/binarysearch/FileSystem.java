package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    private FileOrDirectory root = new FileOrDirectory(-1);

    public int get(String path) {
        String[] segments = path.substring(1).split("/");
        FileOrDirectory cur = root;
        for (String segment : segments) {
            cur = cur.subDirectories.get(segment);
            if (cur == null) return -1;
        }
        return cur.value;
    }

    public boolean create(String path, int content) {
        String[] segments = path.substring(1).split("/");
        FileOrDirectory cur = root;
        for (int i = 0; i < segments.length; i++) {
            String segment = segments[i];
            if (i == segments.length - 1) {
                if (cur.subDirectories.containsKey(segment)) return false; // already exists
                cur.subDirectories.put(segment, new FileOrDirectory(content));
            } else {
                cur = cur.subDirectories.get(segment);
                if (cur == null) return false; // some parent directory doesn't exist
            }
        }

        return true;
    }

    public class FileOrDirectory {
        public int value;
        public Map<String, FileOrDirectory> subDirectories = new HashMap<>();

        public FileOrDirectory(int value) {
            this.value = value;
        }
    }
}
