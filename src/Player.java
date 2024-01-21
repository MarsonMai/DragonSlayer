public class Player {
    private String playerName;
    private int health;
    private int gold;
    private static int topScore = 0;
    private int score;
    private boolean hasHealthPotion;
    private Sword sword;
    public Player(String playerName) {
        this.playerName = playerName;
        health = 100;
        gold = 0;
        hasHealthPotion = false;
        sword = new Sword();
    }

    public boolean getHasHealthPot() {
        return hasHealthPotion;
    }

    public int getScore() {
        return score;
    }

    public int getGold() {
        return gold;
    }

    public int getTopScore() {
        return topScore;
    }

    public Sword getSword() {
        return sword;
    }

    public String swordInfo() {
        return playerName + " has a attack rating of " + sword.getSwordAttack() + " and a dodge rating of " + sword.getDodgeRating();
    }

    public int getHealth() {
        return health;
    }
    public void lowerGold(int gold) {
        gold -= gold;
    }

    public void setHasHealthPotion(boolean HealthPotion) {
        hasHealthPotion = HealthPotion;
    }

    public void setGold(int playerGold) {
        gold += playerGold;
    }

    public void setHealth(int playerHealth) {
        health = playerHealth;
    }

    public int attack() {
        return sword.getSwordAttack() * ((int)(Math.random() * 3) + 2);
    }

    public void takeDamage(int damage) {
        int num = (int) (Math.random() * 100) + 1;
        if (num > sword.getDodgeRating()) {
            health -= damage;
            System.out.println(playerName + " took " + damage + " damage");
        } else {
            System.out.println("You dodged the dragon's attack");
        }
    }
    public void stats() {
        System.out.println("Health: " + health);
        System.out.println("Sword info: " + swordInfo());
        System.out.println("PlayerGold: " + gold);
        System.out.println("Health Pot:" + hasHealthPotion);
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
            score = gold + health;
        } else {
            score = gold + health + 100;
        }

        if (score > topScore) {
            topScore = score;
        }
    }

}
