public class Player {
    private int health;
    private int gold;
    private String name;
    private Sword sword;
    private Dragon dragon;
    private int newHealth;
    public Player(String name) {
        this.name = name;
        health = 100;

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
    public void attack() {
        System.out.println(name + " did " + sword.swordAttack() + "dmg!");
        newHealth = dragon.getDragonHealth() - sword.swordAttack();
    }
    public void getAttacked() {
        if (health - dragon.dragonAttack() > 0) {
            health =- dragon.dragonAttack();
            System.out.println("The dragon did " + dragon.dragonAttack() + "and you have " + health + " hp remaining!");
        } else {
            System.out.println(name + "died!");
            health = 0;
        }
    }
}
