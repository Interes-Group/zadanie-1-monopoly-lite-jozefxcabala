package sk.stuba.fei.uim.oop;

public class Start extends Field{
    Start(String name, int position){
        super(name, position);
    }

    @Override
    void action(Player player, Board board) {
        System.out.println("Si na starte!");
    }

    @Override
    public String toString() {
        return String.format("Field: %s\nPosition: %d\n", this.getName(), this.getPosition());
    }
}
