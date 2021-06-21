package binarysearch;

public class UnidirectionalWordSearch {
    public boolean solve(String[][] board, String word) {
        for (String[] strings : board) {
            if (String.join("", strings).contains(word)) return true;
        }

        for (int j = 0; j < board[0].length; j++) {
            StringBuilder sb = new StringBuilder();
            for (String[] strings : board) {
                sb.append(strings[j]);
            }
            if (sb.toString().contains(word)) return true;
        }
        return false;
    }
}
