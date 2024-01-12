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
        int dragonDmg = dragon.dragonAttack();
        health -= dragonDmg;
        System.out.println(name + " did " + sword.swordAttack() + "dmg!");
        newHealth = dragon.getDragonHealth() - sword.swordAttack();
        dragon.takeDmg(newHealth);
    }

}
