package one;

public class Rating implements Comparable<Rating> {
    
    private double sumOfRatings;
    private int raters;

    public Rating() {
        sumOfRatings = 0;
        raters = 0;
    }

    public Rating(double sumOfRatings, int raters) {
        this.sumOfRatings = sumOfRatings;
        this.raters = raters;
    }

    public void addRating(double newRating) {
        sumOfRatings += newRating;
        raters++;
    }

    public double getAverageRating() {
        if (raters > 0) {
            return sumOfRatings / raters;
        } else {
            return 0.0;
        }
    }

    public String toString() {
        return getAverageRating() + " based on " + raters + " reviews";
    }

    public int compareTo(Rating t) {
        if (this.getAverageRating() > t.getAverageRating()) {
            return -1;
        } else if (this.getAverageRating() < t.getAverageRating()) {
            return 1;
        } else {
            if (this.raters > t.raters) {
                return -1;
            } else if (this.raters < t.raters) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
