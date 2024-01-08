package two;

public class StrategicPlayer extends Player {
    
    private double percentPaper;
    private double percentScissors;
    private double percentRock;

    public StrategicPlayer(double paper, double scissors, double rock) {
        percentPaper = paper;
        percentScissors = scissors;
        percentRock = rock;
    }

    @Override
    public String go() {
        
        double random = (Math.random() * 100) + 1;

        if (random < 100 - percentRock - percentScissors) {
            return "Paper";
        } else if (random < 100 - percentPaper - percentRock) {
            return "Scissors";
        } else {
            return "Rock";
        }
    }
}
