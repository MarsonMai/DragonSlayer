public class Room {
    private String roomName;
    private int dragons;
    private boolean cleared;
    private boolean hasHealthPot;
    public Room() {
        int rand = (int) (Math.random() * 4);
        dragons = rand;
    }
    public int getDragons() {
        return dragons;
    }
}
