import java.util.Scanner;
public class DragonSlayer {
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
        while (!choice.equals("Q")) {
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
                player = new Player(name);
                System.out.println("Welcome to Dragon Slayer!");
                System.out.println("You have entered the dungeon!");
                System.out.println("You have to beat 5 rooms in order to win or die before you finish!");
                System.out.println("(E)nter next room");
                System.out.println("(S)earch Room");
                System.out.println("(U)se health pot");
                System.out.println("(F)ight");
                System.out.print("Choose option: ");
                choice2 = SCANNER.nextLine().toLowerCase();
                System.out.println("-------------------------------");
                if (choice2.equals("s")) {
                    room.healthPot();
                } else if (choice2.equals("u")) {
                    room.useHealthPot();
                } else if (choice2.equals("f")) {
                    room.dragonRoom();
                }
            } else if (choice2.equals("v")) {

            }

        }
    }

}
