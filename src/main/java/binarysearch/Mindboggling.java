package binarysearch;

public class Mindboggling {
    public int solve(String[][] matrix, String[] words) {
        int x = 0;
        outer: for (String word : words) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (canMake(word, 0, matrix, i, j, 0)) {
                        x++;
                        continue outer;
                    }
                }
            }
        }
        return x;
    }

    private boolean canMake(String word, int offset, String[][] matrix, int r, int c, int used) {
        if (offset == word.length()) return true;
        char ch = matrix[r][c].charAt(0);
        if (word.charAt(offset) != ch) return false;
        used |= 1 << (4 * r + c);
        return helper(word, offset,matrix, r + 1, c, used)
                || helper(word, offset, matrix, r + 1, c + 1, used)
                || helper(word, offset, matrix, r + 1, c - 1, used)
                || helper(word, offset, matrix, r, c + 1, used)
                || helper(word, offset, matrix, r, c - 1, used)
                || helper(word, offset, matrix, r - 1, c + 1, used)
                || helper(word, offset, matrix, r - 1, c, used)
                || helper(word, offset, matrix, r - 1, c - 1, used);
    }

    private boolean helper(String s, int offset, String[][] matrix, int r, int c, int used) {
        if (r < 0 || r >= matrix.length) return false;
        if (c < 0 || c >= matrix[0].length) return false;
        if ((used & (1 << (4 * r + c))) != 0) return false;
        return canMake(s, offset + 1, matrix, r, c, used);
    }
}
