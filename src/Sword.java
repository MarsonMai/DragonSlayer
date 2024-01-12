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
}
