//2. Extend Building into ApartmentBlock; Units for ApartmentBlock
public class ApartmentBlock extends Building implements Unit{
    private int units;

    public ApartmentBlock() {
        this.units = DEFAULT_NUM_UNITS;
    }

    @Override
    public int getUnits() {
        return this.units;
    }

    @Override
    public void setUnits(int i) {
        this.units = i;
    }
}