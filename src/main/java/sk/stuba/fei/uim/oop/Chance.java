package sk.stuba.fei.uim.oop;

public class Chance extends Field{
    Chance(String name, int position){
        super(name, position);
    }

    @Override
    void action(Player player, Board board) {
        board.getCards().getCard().action(player, board);
    }

    @Override
    public String toString() {
        return String.format(ConsoleColors.chooseColor("RESET") + "[FIELD][%s]: \nPosition: %d\n", this.getName(), this.getPosition());
    }
}
