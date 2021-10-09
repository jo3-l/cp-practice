package ccc.ccc2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J5S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rowCount = Integer.parseInt(reader.readLine());
        int columnCount = Integer.parseInt(reader.readLine());

        int instructionCount = Integer.parseInt(reader.readLine());
        boolean[] paintedColumns = new boolean[columnCount];
        boolean[] paintedRows = new boolean[rowCount];

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < instructionCount; i++) {
            boolean isColumnInstruction = reader.read() == 'C';
            // Skip space
            reader.skip(1);
            for (int c = reader.read(); Character.isDigit(c); c = reader.read()) buffer.append((char) c);

            // -1 since the row/column is provided as a 1-based integer.
            int v = Integer.parseInt(buffer.toString()) - 1;

            if (isColumnInstruction) paintedColumns[v] = !paintedColumns[v];
            else paintedRows[v] = !paintedRows[v];
            buffer.setLength(0);
        }

        int goldPoints = 0;
        for (int row = 0; row < rowCount; row++) {
            boolean isRowPainted = paintedRows[row];
            for (int column = 0; column < columnCount; column++) {
                boolean isColumnColored = paintedColumns[column];
                if (isRowPainted != isColumnColored) ++goldPoints;
            }
        }

        System.out.println(goldPoints);
    }
}