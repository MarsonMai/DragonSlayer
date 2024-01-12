public class
Dragon {
    private int level;
    private int dragonHealth;
    private Player player;
    public Dragon() {
        int rand = (int) (Math.random() * 4);
        dragonHealth = 100;
        level = rand;
    }
    public int getLevel() {
        return level;
    }
    public int getDragonHealth() {
        return dragonHealth;
    }
    public int dragonAttack() {
        int rand = (int) (Math.random() * 101);
        int randAttack = (int) (Math.random() * 11) + 1;
        if (rand > 20) {
            System.out.println("Dragon did " + level * randAttack + " dmg!");
            return level * randAttack;
        } else {
            System.out.println(player + " dodged your attack!");
            return 0;
        }
    }
    public void takeDmg(int x) {
        dragonHealth = x;
    }
}
