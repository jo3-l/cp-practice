package ccc2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class J5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rowCount = Integer.parseInt(reader.readLine());
        int columnCount = Integer.parseInt(reader.readLine());

        int instructionCount = Integer.parseInt(reader.readLine());
        Set<Integer> coloredColumns = new HashSet<>();
        Set<Integer> coloredRows = new HashSet<>();

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < instructionCount; i++) {
            boolean isColumnInstruction = reader.read() == 'C';
            // Skip the space
            reader.skip(1);
            for (int c = reader.read(); c != '\n' && c != -1; c = reader.read()) {
                buffer.append((char) c);
            }

            int v = Integer.parseInt(buffer.toString());

            // Drawing over a column twice results in there being no change at all to the color of the points in the column.
            // Same goes for rows.
            if (isColumnInstruction) {
                if (coloredColumns.contains(v)) coloredColumns.remove(v);
                else coloredColumns.add(v);
            } else {
                if (coloredRows.contains(v)) coloredRows.remove(v);
                else coloredRows.add(v);
            }

            buffer.setLength(0);
        }

        int goldPoints = 0;
        for (int rowNumber = 1; rowNumber <= rowCount; rowNumber++) {
            boolean isRowColored = coloredRows.contains(rowNumber);
            for (int columnNumber = 1; columnNumber <= columnCount; columnNumber++) {
                boolean isColumnColored = coloredColumns.contains(columnNumber);

                // Only increment if *either* the row or the column has been colored - not both!
                if ((isRowColored || isColumnColored) && !(isRowColored && isColumnColored)) ++goldPoints;
            }
        }

        System.out.println(goldPoints);
    }
}