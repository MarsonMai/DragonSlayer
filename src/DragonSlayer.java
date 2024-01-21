import java.sql.SQLOutput;
import java.util.Scanner;
public class DragonSlayer {
    private Scanner myScanner;
    public DragonSlayer() {
        myScanner = new Scanner(System.in);
    }
    public void play() {
        System.out.println("Welcome to the Dragon Slayer game!" );
        System.out.print("What is your name adventurer? " );
        String name = myScanner.nextLine();
        boolean bool = true;
        while(bool) {
            Player player = new Player(name);
            Room room = new Room(player);
            System.out.println("----------------------");
            System.out.println("Main Menu");
            System.out.println("1.New game 2.Quit 3.View top score");
            System.out.print("Enter your choice: ");
            String number = myScanner.nextLine();
            System.out.println("----------------------");
            if(number.equals("1")) {
                room.enterRoom();
            } else if(number.equals("2")) {
                System.out.println("You quit");
                bool = false;
            } else if(number.equals("3")) {
                System.out.println("Top Score: " + player.getTopScore());
            } else {
                System.out.println("Not an option!");
            }
        }
    }
}