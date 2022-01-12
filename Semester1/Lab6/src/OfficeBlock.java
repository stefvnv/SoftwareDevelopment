//2. Extend Building into OfficeBlock; Units for OfficeBlock
public class OfficeBlock extends Building implements Cubicle{
    private int cubicles;

    public OfficeBlock() {
        this.cubicles = DEFAULT_NUM_CUBICLES;
    }

    @Override
    public int getCubicles() {
        return this.cubicles;
    }

    @Override
    public void setCubicles(int i) {
        this.cubicles = i;
    }
}