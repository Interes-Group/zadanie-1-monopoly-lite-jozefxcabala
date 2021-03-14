package sk.stuba.fei.uim.oop;

public class Building extends Field{
    private int value;
    private int fine;
    private Player propertyOf;

    public Building(String name, int position, int value, int fine) {
        super(name, position);
        this.value = value;
        this.fine = fine;
        this.propertyOf = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public Player getPropertyOf() {
        return propertyOf;
    }

    public void setPropertyOf(Player propertyOf) {
        this.propertyOf = propertyOf;
    }

    @Override
    void action(Player player, Board board) {
    }

    @Override
    public String toString() {
        return String.format("Field: %s\nPosition: %d\nValue: %d\nFine: %d\nProperty of: %s\n", this.getName(), this.getPosition(),
                this.getValue(), this.getFine(), "nemam");
    }
}

