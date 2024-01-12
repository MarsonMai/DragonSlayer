import java.util.Scanner;
public class
DragonSlayer {
    private static final Scanner SCANNER = new Scanner(System.in);
    private Player player;
    private Room room;
    private Dragon dragon;
    public DragonSlayer() {
        room = null;
    }
    public void play() {
    WelcomePlayer();


    }
    public void WelcomePlayer() {
        room = new Room();
        String choice = "";
        String choice2 = "";
        while (!choice.equals("q")) {
            System.out.println("Main Menu");
            System.out.println("--------------------");
            System.out.println("(N)ew Game");
            System.out.println("(Q)uit");
            System.out.println("(V)iew Top Scores");
            System.out.print("Enter Option: ");
            choice = SCANNER.nextLine().toLowerCase();
            System.out.println("--------------------");
            if (choice.equals("n")) {
                System.out.print("What is your name slayer?");
                String name = SCANNER.nextLine();
                Sword StartingSword = new Sword(10,20);
                player = new Player(name,StartingSword);
                System.out.println("You have to beat 5 rooms in order to win or die before you finish!");
                System.out.println("1.fight 2.search room 3.view stats 4.use potion");
                System.out.print("Choose option: ");
                choice2 = SCANNER.nextLine().toLowerCase();
                System.out.println("-------------------------------");
                if (choice2.equals("2")) {
                    room.healthPot();
                } else if (choice2.equals("4")) {
                    room.useHealthPot();
                } else if (choice2.equals("1")) {
                    //player.attack(room.getCurrentDragon());
                }
            } else if (choice.equals("v")) {

            } else if (choice.equals("q")) {
                System.out.println("Goodbye!");
            }

        }
    }

}
