package sk.stuba.fei.uim.oop;

public class Prison extends Field{
    Prison(String name, int position){
        super(name, position);
    }

    @Override
    void action(Player player, Board board) {
        System.out.printf("[%s]: You are on visit in prison!\n", player.getName());
    }

    @Override
    public String toString() {
        return String.format("[FIELD][%s]: \nPosition: %d\n", this.getName(), this.getPosition());
    }
}
