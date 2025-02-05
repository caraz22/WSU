package Practice2.PartA;

public class Golfer {

    private String firstName;
    private String lastName;
    private int score = 0;
    private int holesCompleted = 0;

    public Golfer(String firstName, String lastName, int score, int holesCompleted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
        this.holesCompleted = holesCompleted;
    }
    
    public String toString() {
        return lastName + ", " + firstName + ": " + score + " with " + holesCompleted + " holes completed";
    }
}
