public class Player {
    private String playerName;
    private int Health;
    private int Gold;
    private static int topScore = 0;
    private int Score;
    private boolean hasHealthPotion;
    private Sword sword;
    public Player(String playerName) {
        this.playerName = playerName;
        Health = 100;
        Gold = 0;
        hasHealthPotion = false;
        sword = new Sword();
    }

    public boolean getHasHealthPot() {
        return hasHealthPotion;
    }

    public int getPlayerScore() {
        return Score;
    }

    public int getPlayerGold() {
        return Gold;
    }

    public int getTopScore() {
        return topScore;
    }

    public Sword getSword() {
        return sword;
    }

    public String SwordInfo() {
        return playerName + " has a attack rating of " + sword.getSwordAttack() + " and a dodge rating of " + sword.getDodgeRating();
    }
    public void stats() {
        System.out.println("Health: " + Health);
        System.out.println("Sword info: " + SwordInfo());
        System.out.println("PlayerGold: " + Gold);
        System.out.println("Health Pot:" + hasHealthPotion);
    }

    public int getHealth() {
        return Health;
    }
    public void lowerGold(int gold) {
        Gold -= gold;
    }

    public void setHasHealthPotion(boolean HealthPotion) {
        hasHealthPotion = HealthPotion;
    }

    public void setGold(int playerGold) {
        Gold += playerGold;
    }

    public void setHealth(int playerHealth) {
        Health = playerHealth;
    }

    public int attack() {
        return sword.getSwordAttack() * ((int)(Math.random() * 3) + 2);
    }

    public void TakeDamage(int damage) {
        int num = (int) (Math.random() * 100) + 1;
        if (num > sword.getDodgeRating()) {
            Health -= damage;
            System.out.println(playerName + " took " + damage + " damage");
        } else {
            System.out.println("You dodged the dragon's attack");
        }
    }

    public void useHealthPot() {
        int newHealth = getHealth() + ((int)(Math.random() * 16) + 35);
        if (newHealth > 100) {
            newHealth = 100;
        }
        setHealth(newHealth);
        hasHealthPotion = false;
    }
    public void Score(boolean roomsCleared) {
        if(!roomsCleared) {
            Score = Gold + Health;
        } else {
            Score = Gold + Health + 100;
        }

        if (Score > topScore) {
            topScore = Score;
        }
    }

}
