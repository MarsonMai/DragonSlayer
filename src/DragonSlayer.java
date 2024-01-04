import java.util.Scanner;
public class DragonSlayer {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Player player;
    private Room room;
    private Dragon dragon;
    public DragonSlayer() {

    }
    public void play() {



    }
    public void WelcomePlayer() {
        System.out.println("Welcome to Dragon Slayer!");
        System.out.print("What is your name slayer?");
        String name = SCANNER.nextLine();
        player = new Player(name);
        System.out.println("You have entered the dungeon!");
        System.out.println("You have to beat 5 rooms in order to win or die before you finish!");
        System.out.println("There are " + room.getDragons() + " dragons and they are level " + dragon.getLevel());

    }

}
