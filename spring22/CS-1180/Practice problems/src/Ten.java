public class Ten {
    
    public static void main(String[] args) throws Exception {
        
        Player goodGuy = new Player("Iron Man", 50, 10);
        Player badGuy = new Player("Thanos", 100, 20);



        while (true) {
            System.out.println(goodGuy + "\t" + badGuy);
            goodGuy.hit(badGuy);
            badGuy.hit(goodGuy);

            if (goodGuy.getHealth() <= 0 || badGuy.getHealth() <= 0) {
                break;
            }
        }

        System.out.println(goodGuy + "\t" + badGuy);
        if (goodGuy.getHealth() <= 0) {
            System.out.println("Iron Man: 'You win this time, Thanos!'");
        } else {
            System.out.println("Thanos: 'Nice try, Iron Man!'"); //even though this will probably never print unless lucky rng
        }
    }
}
