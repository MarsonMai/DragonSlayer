public class Dragon {
    private int dragonHealth;
    private int dragonLevel;
    private static Player player;
    public Dragon(Player player) {
        dragonLevel = (int) (Math.random() * 3) + 1; //gives dragon random level
        dragonHealth = 150;
        this.player = player;
    }

    public int getLevel() {
        return dragonLevel;
    }

    public int getDragonHealth() {
        return dragonHealth;
    }

    public void setDragonHealth(int dragonHealth) {
        this.dragonHealth = dragonHealth;
    }

    public int dragonAttack() {
        return dragonLevel * ((int)(Math.random() * 7) + 2);
    }

    public void deadDragon() {
        int randomNum = (int) (Math.random() * 4) + 1;
        int goldAmount = (int) (Math.random() * 51) + 25;
        if (randomNum == 1) {
            player.setGold(player.getGold() + goldAmount);
            System.out.println("You killed a dragon and got " + goldAmount + " gold");
        } else if (randomNum == 2) {
            player.getSword().swordUpgrade();
            System.out.println("You killed a dragon and got a sword upgrade and upgraded your sword");
        } else if (randomNum == 3) {
            player.useHealthPot();
            System.out.println("You killed a dragon and got a health bonus and your new health is " + player.getHealth());
        } else {
            System.out.println("You killed a dragon and got nothing");
        }
    }
}