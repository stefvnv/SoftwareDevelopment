//2. Extend Building into House; Rooms for House
public class House extends Building implements Rooms{
    private int rooms;

    public House() {
        this.rooms = DEFAULT_NUM_ROOMS;
    }

    @Override
    public int getRooms() {
        return this.rooms;
    }

    @Override
    public void setRooms(int i) {
        this.rooms = i;
    }
}