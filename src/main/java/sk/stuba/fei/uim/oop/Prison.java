package sk.stuba.fei.uim.oop;

public class Prison extends Field{
    Prison(String name, int position){
        super(name, position);
    }

    @Override
    void action(Player player, Board board) {
        System.out.printf("Player[%s]: Si na navsteve vo väzeni!\n", player.getName());
    }

    @Override
    public String toString() {
        return String.format("Field: %s\nPosition: %d\n", this.getName(), this.getPosition());
    }
}
