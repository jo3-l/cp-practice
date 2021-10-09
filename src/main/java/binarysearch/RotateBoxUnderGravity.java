package binarysearch;

public class RotateBoxUnderGravity {
    public String[][] solve(String[][] matrix) {
        // rotate 90 deg clockwise
        String[][] rotated = new String[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            String[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                rotated[j][matrix.length - i - 1] = row[j];
            }
        }
        for (int j = 0; j < rotated[0].length; j++) {
            int i = 0;
            while (i < rotated.length) {
                char v = rotated[i][j].charAt(0);
                if (v == '*' || v == '.') {
                    i++;
                    continue;
                }

                // found a small box, make it fall through
                int numBox = 0;
                while (i < rotated.length && rotated[i][j].charAt(0) != '*') {
                    if (rotated[i][j].charAt(0) == '#') {
                        rotated[i][j] = ".";
                        numBox++;
                    }
                    i++;
                }
                // hit an obstacle/end, add boxes
                int write = i;
                for (int z = 0; z < numBox; z++) {
                    rotated[--write][j] = "#";
                }
            }
        }
        return rotated;
    }
}
