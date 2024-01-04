public class Dragon {
    private int level;
    private int dragonHealth;
    public Dragon() {
        int rand = (int) (Math.random() * 4);
        dragonHealth = 100;
        level = rand;
    }
}
