public class Sword {
    private int attack;
    private int dodge;
    public Sword() {
        dodge = 20;
        attack  = 10;

    }
    public int swordAttack() {
        int rand = (int) (Math.random() * 101);
        if (attack > 20) {
            return attack;
        } else {
            System.out.println("The dragon dodged your attack!");
            return 0;
        }
    }
}
