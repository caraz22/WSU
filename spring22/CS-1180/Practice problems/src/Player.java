public class Player {

    private String name;
    private int health;
    private int maxDamage;

    public Player(String name, int health, int maxDamage) {
        setName(name);
        setHealth(health);
        setMaxDamage(maxDamage);
    }

    public void hit(Player other) {
        int currentHealth = other.getHealth();
        int hpLost = (int) (Math.random() * getMaxDamage() + 1);
        other.setHealth(currentHealth - hpLost);
    }

    public String toString() {
        String nameHealth = name + " (" + health + ")";
        return nameHealth;
    }
    
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getMaxDamage() {
        return maxDamage;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }
}
