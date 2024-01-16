public class Player {
    private int health;
    private int gold;
    private String name;
    private Sword sword;
    private int newHealth;
    public Player(String name,Sword sword) {
        this.name = name;
        health = 100;
        gold = 0;
        this.sword = sword;
        newHealth = 0;

    }
    public String getName() {
        return name;
    }
    public void heal() {
        health += 50;
        System.out.println("You healed 50 health!");
        if (health > 100) {
            health = 100;
        }
    }
    public int getNewHealth() {
        return  newHealth;
    }
    public void attack(Dragon dragon) {
        int rand = (int) (Math.random() * 5) + 1;
        int dragonDmg = dragon.dragonAttack();
        health -= dragonDmg;
        System.out.println(name + " did " + sword.swordAttack() + "dmg!");
        newHealth = dragon.getDragonHealth() - sword.swordAttack();
        if (newHealth <= 0) {
            System.out.println("The dragon has been slayed!");
            if (rand == 1) {
                System.out.println("You received 50 gold!");
                gold += 50;
            } else if (rand == 2) {
                System.out.println("You received a sword upgrade!");
                sword.upgrade();
            } else if (rand == 3) {
                System.out.println("You healed back to max hp!");
                health = 100;
            } else {
                System.out.println("Dragon dropped nothing!");
            }

        } else {
            dragon.takeDmg(newHealth);
        }
    }
    public void stats() {
        System.out.println("Gold: " + gold);
        System.out.println("Health: " + health);

    }

}
