import java.util.Scanner;
public class Room {
    private String roomName;
    private int dragons;
    private boolean cleared;
    private boolean hasHealthPot;
    private static final Scanner SCANNER = new Scanner(System.in);
    private Player player;
    private Dragon dragon;
    public Room() {
        int rand = (int) (Math.random() * 4);
        dragons = rand;
        hasHealthPot = false;
        cleared = false;
        roomName = "Dragon Den";
    }
    public int getDragons() {
        return dragons;
    }
    public boolean getHasHealthPot() {
        return hasHealthPot;
    }
    public boolean setHealthPot(boolean bool) {
        hasHealthPot = bool;
        return hasHealthPot;
    }
    public void dragonRoom() {
        dragon = new Dragon();
        player = new Player(player.getName());
        System.out.println(roomName);
        System.out.println("There are " + getDragons() + " dragons and they are level " + dragon.getLevel());
        dragon.dragonAttack();
        player.attack();

    }
    public void healthPot() {
        if (hasHealthPot) {
            System.out.println("You found a health pot!");
            hasHealthPot = true;
        } else {
            System.out.println("You already have one!");
        }
    }
    public void useHealthPot() {
        if (hasHealthPot) {
            hasHealthPot = false;
            player.heal();
        } else {
            System.out.println("You don't have a health pot!");
        }
    }
}
