package sk.stuba.fei.uim.oop;

public abstract class Field {
    private String name;
    private int position;

    public Field(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    abstract int action();

    @Override
    abstract public String toString();
}
