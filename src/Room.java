import java.util.Scanner;
public class Room {
    private String[] room = {"the den", "the cave", "the underground", "the marsh", "HELL"}; //list of room names
    private static Player player;
    private int roomNumber;
    private String[] searchedRooms;
    private String roomName;
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
            System.out.println("--------------------------");
            System.out.println("You entered " +  roomName +  "\n" + rand + " dragons spawn");
            for (int i = 0; i < rand; i++) { // chance for 1-3 dragons
                Dragon dragon = new Dragon(player);
                System.out.println("The dragon is level " + dragon.getLevel() + "\nIt has " + dragon.getDragonHealth() + " health");
                System.out.println("--------------------------");
                while (dragon.getDragonHealth() > 0 && player.getHealth() > 0) {
                    System.out.println("Do you want to (S)earch the room, (A)ttack the dragon, (U)se health pot, (B)uy upgrades, (V)iew stats?");
                    System.out.print("Enter choice: ");
                    String choice = myScanner.nextLine();
                    if (choice.equals("s")) {
                        search();
                    } else if (choice.equals("a")) {
                        if ((player.getHealth()) > 0 && (dragon.getDragonHealth() > 0)) {
                            int playerAttack = player.attack();
                            System.out.println("---------------------------");
                            System.out.println("You attack the dragon for " + playerAttack + " damage");
                            dragon.setDragonHealth(dragon.getDragonHealth() - playerAttack);
                        }
                        if (dragon.getDragonHealth() <= 0) {
                            dragon.deadDragon();
                        } else {
                            player.TakeDamage(dragon.dragonAttack());
                            System.out.println("health:" + player.getHealth());
                            System.out.println("Dragon hp: " + dragon.getDragonHealth());
                            System.out.println("---------------------------");
                            if (player.getHealth() <= 0) {
                                System.out.println("You died\nGame Over");
                            }
                        }
                    } else if (choice.equals("u")) {
                        if (player.getHasHealthPot()) {
                            player.useHealthPot();
                            System.out.println("You used a health pot and gained " +  player.getHealth() + " health!");
                        } else {
                            System.out.println("You don't have a health pot");
                        }
                    } else if (choice.equals("v")) {
                        player.stats();
                    } else if (choice.equals("b")) {
                        System.out.println("(S)word upgrade(100 gold)!");
                        System.out.println("(M)ax health increase(100 gold)!");
                        System.out.println("(L)eave the shop");
                        System.out.print("Enter choice: ");
                        String str = myScanner.nextLine().toLowerCase();
                        if (str.equals("s") && player.getPlayerGold() >= 100) { // checks if the player has enough gold to purchase
                            player.getSword().swordUpgrade();
                            player.lowerGold(100);
                        } else if (str.equals("m") && player.getPlayerGold() >= 100) {
                            player.setHealth(player.getHealth() + 50);
                            player.lowerGold(100);
                        } else {
                            System.out.println("Not a choice!");
                        }
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
            System.out.println("You Win!");
        }
        player.Score(roomsCleared);
        System.out.println("Your score is " + player.getPlayerScore());
    }

    public void search() {
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