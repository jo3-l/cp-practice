package ccc.ccc2004;

import java.util.*;

public class S3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cell[][] cells = new Cell[10][9];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (sc.hasNextInt()) {
                    cells[i][j] = new Cell(new IndexPair(i, j), null, sc.nextInt());
                } else {
                    List<IndexPair> ip = new ArrayList<>();
                    StringTokenizer st = new StringTokenizer(sc.next(), "+");
                    while (st.hasMoreTokens()) {
                        String sym = st.nextToken();
                        int ii = sym.charAt(0) - 'A';
                        int jj = sym.charAt(1) - '1';
                        ip.add(new IndexPair(ii, jj));
                    }
                    cells[i][j] = new Cell(new IndexPair(i, j), ip, Integer.MIN_VALUE);
                }
            }
        }

        int[] allUndef = new int[10];
        int[][] resolved = new int[10][9];
        for (int i = 0; i < 10; i++) Arrays.fill(resolved[i], Integer.MIN_VALUE);
        for (int i = 0; i < 10; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 9; j++) {
                if (j != 0) sb.append(' ');
                int rv = resolveValue(cells[i][j], cells, new int[10], allUndef, resolved);
                if (rv == Integer.MAX_VALUE) sb.append('*');
                else sb.append(rv);
            }
            System.out.println(sb);
        }
    }

    private static int resolveValue(Cell cell, Cell[][] cells, int[] seen, int[] allUndef, int[][] resolved) {
        if (cell.concreteValue != Integer.MIN_VALUE) return cell.concreteValue;
        if (resolved[cell.idx.i][cell.idx.j] != Integer.MIN_VALUE) return resolved[cell.idx.i][cell.idx.j];
        if ((seen[cell.idx.i] & (1 << cell.idx.j)) != 0) return Integer.MAX_VALUE;
        if ((allUndef[cell.idx.i] & (1 << cell.idx.j)) != 0) return Integer.MAX_VALUE;
        int x = 0;
        for (IndexPair dep : cell.lazyValue) {
            int[] cseen = Arrays.copyOf(seen, seen.length);
            cseen[cell.idx.i] |= 1 << cell.idx.j;
            int v = resolveValue(cells[dep.i][dep.j], cells, cseen, allUndef, resolved);
            if (v == Integer.MAX_VALUE) {
                x = Integer.MAX_VALUE;
                break;
            }
            x += v;
        }
        if (x == Integer.MAX_VALUE) allUndef[cell.idx.i] |= 1 << cell.idx.j;
        return resolved[cell.idx.i][cell.idx.j] = x;
    }

    public static class Cell {
        public IndexPair idx;
        public List<IndexPair> lazyValue;
        public int concreteValue;

        public Cell(IndexPair idx, List<IndexPair> lazyValue, int concreteValue) {
            this.idx = idx;
            this.lazyValue = lazyValue;
            this.concreteValue = concreteValue;
        }

        @Override
        public String toString() {
            return "Cell { idx=" + idx + ", lazyValue=" + lazyValue + ", concreteValue=" + concreteValue + " }";
        }
    }

    public static class IndexPair {
        public int i;
        public int j;

        public IndexPair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "(" + i + ", " + j + ")";
        }
    }
}
