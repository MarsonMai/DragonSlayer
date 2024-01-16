public class Sword {
    private int attack;
    private int dodge;
    public Sword(int attack,int dodge) {
        this.dodge = dodge;
        this.attack = attack;

    }
    public int swordAttack() {
        int rand = (int) (Math.random() * 100) + 1;
        if (rand > dodge) {
            return attack;
        } else {
            System.out.println("The dragon dodged your attack!");
            return 0;
        }
    }
    public void upgrade() {
        int rand = (int) (Math.random() * 3) + 1;
        if (rand == 1) {
            System.out.println("Sword has gained a attack boost!");
            attack += 10;
        } else {
            System.out.println("Sword attack cannot miss!");
            dodge = -1;
        }
    }
}
