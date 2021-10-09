package binarysearch;

public class ClockAngle {
    public static void main(String[] args) {
        System.out.println(new ClockAngle().solve(12, 22));
    }
    public int solve(int hour, int minutes) {
        float ha = (float) ((hour % 12) * 60 + minutes) / 2;
        int ma = minutes * 6;
        double dist = Math.floor(Math.min(Math.abs(ha - ma), 360 - Math.abs(ha - ma)));
        return (int) dist;
    }
}
