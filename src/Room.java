import java.util.Scanner;
public class Room {
    private String[] searchedRooms;
    private String roomName;
    private String[] room = {"the den", "the cave", "the underground", "the marsh", "hell"}; //list of room names
    private static Player player;
    private int roomNumber;
    private boolean roomsCleared;
    private Scanner myScanner;
    public Room(Player player) {
        roomsCleared = false;
        myScanner = new Scanner(System.in);
        roomNumber = 0;
        this.player = player;
        roomsCleared = false;
        searchedRooms = new String[5];
    }

    public void enterRoom() {
        while (!roomsCleared) {
            roomNumber++;
            roomName = room[0];
            String[] newList = new String[room.length - 1];
            int index = 0;
            for (int i = 1; i < room.length; i++) {
                newList[index] = room[i];
                index++;
            }
            room = newList;
            int rand = (int) (Math.random() * 3) + 1;
            System.out.println("You entered " +  roomName +  "\n" + rand + " dragons spawn");
            for (int i = 0; i < rand; i++) { // loop that creates 1 to 3 dragons per room
                Dragon dragon = new Dragon(player);
                System.out.println("The dragon is level " + dragon.getLevel() + "\nIt has " + dragon.getDragonHealth() + " health");
                while (dragon.getDragonHealth() > 0 && player.getPlayerHealth() > 0) {
                    System.out.println("Do you want to (S)earch the room, (A)ttack the dragon, (U)se health pot, (V)iew stats?");
                    System.out.print("Enter choice: ");
                    String choice = myScanner.nextLine();
                    if (choice.equals("s")) {
                        searchRoom();
                    } else if (choice.equals("a")) {
                        if ((player.getPlayerHealth()) > 0 && (dragon.getDragonHealth() > 0)) {
                            int playerAttack = player.attack();
                            System.out.println("---------------------------");
                            System.out.println("You attack the dragon for " + playerAttack + " damage");
                            dragon.setDragonHealth(dragon.getDragonHealth() - playerAttack);
                        }
                        if (dragon.getDragonHealth() <= 0) {
                            dragon.deadDragon();
                        } else {
                            player.playerTakeDamage(dragon.dragonAttack());
                            System.out.println("health:" + player.getPlayerHealth());
                            System.out.println("Dragon hp: " + dragon.getDragonHealth());
                            System.out.println("---------------------------");
                            if (player.getPlayerHealth() <= 0) {
                                System.out.println("You died\nGame Over");
                            }
                        }
                    } else if (choice.equals("u")) {
                        if (player.getHasHealthPot()) {
                            player.useHealthPot();
                            System.out.println("You used a health pot and gained " +  player.getPlayerHealth() + " health!");
                        } else {
                            System.out.println("You don't have a health pot");
                        }
                    } else if (choice.equals("v")) {
                        player.stats();
                    } else {
                        System.out.println("not an option!");
                    }
                }
                if (room.length == 0) {
                    roomsCleared = true;
                }
            }
        }
        if (room.length == 0) {
            System.out.println("You cleared all the rooms.\nYou Win!");
        }
        player.recordScore(roomsCleared);
        System.out.println("Your score is " + player.getPlayerScore());
    }

    public void searchRoom() {
        boolean isSearched = false;
        for (int i = 0; i < searchedRooms.length; i++) { //list of rooms that are searched
            if (searchedRooms[i] != null) {
                if (roomName.equals(searchedRooms[i])) {
                    isSearched = true;
                }
            }
        }
        if (!isSearched) {
            int randNum = (int) (Math.random() * 2) + 1;
            if (randNum == 1) {
                System.out.println("You searched the room and found a health pot!");
                player.setHasHealthPotion(true);
            } else {
                System.out.println("You found nothing");
            }
            searchedRooms[roomNumber - 1] = roomName;
        } else {
            System.out.println("You have already searched this room!");
        }
    }
}