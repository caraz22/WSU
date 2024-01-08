import java.util.ArrayList;
import java.util.Random;

public class Avery {

    private String highStatus;
    private String game;
    private Random rng = new Random();
    
    public Avery(String highStatus, String game) {
        this.highStatus = highStatus;
        this.game = game;
    }

    public String getGame() {
        return game;
    }

    public String getHighStatus() {
        return highStatus;
    }

    public void setGame(String game) {
        this.game = game;
    }
    
    public void setHighStatus(String highStatus) {
        this.highStatus = highStatus;
    }

    public boolean winApexGame() {
        int num = rng.nextInt(1, 101);
        if (num <= 15) {
            return true;
        } else {
            return false;
        }
    }

    public void getApexGames() throws InterruptedException {
        int gameCount = 1;
        int numOfGames = (int) (Math.random() * 10) + 1;
        String gameStatus = "";
        int wins = 0;
        
        System.out.println("Number of games that will be played: " + numOfGames);                
        for (int i = gameCount; i <= numOfGames; i++) {   
            if (this.winApexGame() == true) {
                gameStatus = "Win";
                wins++;
            } else {
                gameStatus = "Loss";
            }                    
            System.out.println("Game " + i + ": " + gameStatus);
            Thread.sleep(1000);
        }

        System.out.println("Won " + wins + " games");
        Thread.sleep(1000);

        if (this.getHighStatus().equals("yes")) {
            System.out.println("Avery is high, so he is not angry");
        } else {
            if (wins > numOfGames * 0.15) {
                System.out.println("We won more than usual, so Avery is not angry");
            } else {
                System.out.println("We lost more than usual, so Avery is angry");
            }
        }
    }

    public int minutesPlayingRaft() {
        int min = rng.nextInt(30, 181);
        return min;
    }    

    public void getRaftEvents() throws InterruptedException {
        String sharkAttack = "The shark took off a piece of the raft.";
        String toolBreak = "The tool you were using broke, you must make a new one.";
        String fullNets = "The nets are full, you will get a lot of materials.";
        String sharkAttackNet = "The shark took off one of the nets";
        String foundIsland = "You found a " + islandSize() + " island.";
        String lowOnMats = "You are low on materials you need for what you are doing.";
        String goodWind = "The wind is blowing in the direction you need to go.";
        String badWind = "The wind is blowing in the opposite direction you need to go.";
        String killShark = "You killed the shark, you may now take its meat.";
        String killBird = "You killed a seagull, you may loot its lifeless body.";

        ArrayList<String> goodEvents = new ArrayList<>();
        goodEvents.add(fullNets);
        goodEvents.add(foundIsland);
        goodEvents.add(killShark);
        goodEvents.add(goodWind);
        goodEvents.add(killBird);

        ArrayList<String> badEvents = new ArrayList<>();
        badEvents.add(sharkAttack);
        badEvents.add(toolBreak);
        badEvents.add(sharkAttackNet);
        badEvents.add(lowOnMats);
        badEvents.add(badWind);

        int numOfEvents = 0;
        int timePlaying = this.minutesPlayingRaft();
        int numOfBadEvents = 0;
        int numOfGoodEvents = 0;
        int eventNum = 0;
        int listNum = 0;
        ArrayList<String> totalEvents = new ArrayList<>();

        if (timePlaying >= 30 && timePlaying < 60) {
            numOfEvents = 3;
            for (int i = 0; i < numOfEvents; i++) {
                eventNum = rng.nextInt(1, 3);
                listNum = rng.nextInt(0, 5);
                if (eventNum == 1) {
                    numOfGoodEvents++;
                    totalEvents.add(goodEvents.get(listNum));
                } else {
                    numOfBadEvents++;
                    totalEvents.add(badEvents.get(listNum));
                }
            }
        } else if (timePlaying >= 60 && timePlaying < 90) {
            numOfEvents = 6;
            for (int i = 0; i < numOfEvents; i++) {
                eventNum = rng.nextInt(1, 3);
                listNum = rng.nextInt(0, 5);
                if (eventNum == 1) {
                    numOfGoodEvents++;
                    totalEvents.add(goodEvents.get(listNum));
                } else {
                    numOfBadEvents++;
                    totalEvents.add(badEvents.get(listNum));
                }
            }
        } else if (timePlaying >= 90 && timePlaying < 120) {
            numOfEvents = 9;
            for (int i = 0; i < numOfEvents; i++) {
                eventNum = rng.nextInt(1, 3);
                listNum = rng.nextInt(0, 5);
                if (eventNum == 1) {
                    numOfGoodEvents++;
                    totalEvents.add(goodEvents.get(listNum));
                } else {
                    numOfBadEvents++;
                    totalEvents.add(badEvents.get(listNum));
                }
            }
        } else if (timePlaying >= 120 && timePlaying < 150) {
            numOfEvents = 12;
            for (int i = 0; i < numOfEvents; i++) {
                eventNum = rng.nextInt(1, 3);
                listNum = rng.nextInt(0, 5);
                if (eventNum == 1) {
                    numOfGoodEvents++;
                    totalEvents.add(goodEvents.get(listNum));
                } else {
                    numOfBadEvents++;
                    totalEvents.add(badEvents.get(listNum));
                }
            }
        } else if (timePlaying >= 150 && timePlaying <= 180) {
            numOfEvents = 15;
            for (int i = 0; i < numOfEvents; i++) {
                eventNum = rng.nextInt(1, 3);
                listNum = rng.nextInt(0, 5);
                if (eventNum == 1) {
                    numOfGoodEvents++;
                    totalEvents.add(goodEvents.get(listNum));
                } else {
                    numOfBadEvents++;
                    totalEvents.add(badEvents.get(listNum));
                }
            }
        }

        System.out.println("Playing for " + timePlaying + " minutes.");
        Thread.sleep(1000);
        for (int i = 0; i < totalEvents.size(); i++) {
            System.out.println(totalEvents.get(i));
            Thread.sleep(2500);
        }

        if (this.getHighStatus().equals("yes")) {
            System.out.println("Avery is high, so he is not angry");
        } else {
            if (numOfGoodEvents > numOfBadEvents) {
                System.out.println("More good things happened than bad, so Avery is not angry");
            } else {
                System.out.println("More bad things happened than good, so Avery is angry");
            }
        }
    }


    public String islandSize() {
        String islandSize = "";
        int sizeNum = rng.nextInt(1, 4);
        if (sizeNum == 1) {
            islandSize = "small";
        } else if (sizeNum == 2) {
            islandSize = "medium-sized";
        } else {
            islandSize = "big";
        }

        return islandSize;
    }
}
