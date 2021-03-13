package sk.stuba.fei.uim.oop;

public class Police extends Field{
    Police(String name, int position){
        super(name, position);
    }

    @Override
    int action() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Field: %s\nPosition: %d\n", this.getName(), this.getPosition());
    }
}
