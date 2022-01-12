//1. Create a base class Building which implements interfaces for Walls, Roof
public class Building implements Walls, Roof{
   private int walls, roofs;

    public Building() {
        this.walls = DEFAULT_NUM_WALLS;
        this.roofs = DEFAULT_NUM_ROOFS;
    }

    public Building(int w, int r) {
        this.walls = w;
        this.roofs = r;
    }

    @Override
    public int getWalls() {
        return this.walls;
    }

    @Override
    public void setWalls(int i) {
        this.walls = i;
    }

    @Override
    public int getRoof() {
        return this.roofs;
    }

    @Override
    public void setRoof(int i) {
        this.roofs = i;
    }
}