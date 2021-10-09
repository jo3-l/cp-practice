package binarysearch;

public class FiveStarReviews {
    public int solve(int[][] reviews, int threshold) {
        if (threshold == 0) return 0;

        int numReviews = 0;
        int numFiveStarReviews = 0;
        for (int[] review : reviews) {
            numFiveStarReviews += review[0];
            numReviews += review[1];
        }

        if ((numFiveStarReviews / numReviews) >= threshold) return 0;

        // Let the number of reviews needed be n.
        // We can form an equation as follows:
        //
        //  5starReviews + n >= ((reviews + n) * threshold) / 100
        //  100 * 5starReviews + 100 * n >= reviews * threshold + n * threshold
        //  100 * n - threshold * n >= reviews * threshold - 100 * 5starReviews
        //  (100 - threshold) * n >= reviews * threshold - 100 * 5starReviews
        //  n >= (reviews * threshold - 100 * 5starReviews) / (100 - threshold)
        float numerator = (float) numReviews * threshold - 100 * numFiveStarReviews;
        int denominator = 100 - threshold;
        return (int) Math.ceil(numerator / denominator);
    }
}
