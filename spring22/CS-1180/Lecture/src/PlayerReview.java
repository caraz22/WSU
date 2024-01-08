public class PlayerReview implements Comparable<PlayerReview> {

    private String name;
    private int numWins;

    public PlayerReview(String name, int numWins) {
        this.name = name;
        this.numWins = numWins;
    }

    public int compareTo(PlayerReview o) {
        if (this.numWins > o.numWins) {
            return -1;
        } else if (this.numWins < o.numWins) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean equals(Object o) {
        if (!(o instanceof PlayerReview)) {
            return false;
        }

        PlayerReview other = (PlayerReview) o;
        return this.name.equals(other.name) && this.numWins == other.numWins;
    }   

    public String toString() {
        return name + " (" + numWins + ")";
    }
    
}
