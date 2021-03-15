package sk.stuba.fei.uim.oop;

public class Police extends Field{
    Police(String name, int position){
        super(name, position);
    }

    @Override
    void action(Player player, Board board) {
        System.out.printf(ConsoleColors.chooseColor(player.getColor()) + "[%s]: Chytila ta policia! Musis ist do väzenie na 2 kola:(\n", player.getName());
        player.setActualField(board.getFieldByPosition(7));
        player.setLapInPrison(2);
    }

    @Override
    public String toString() {
        return String.format(ConsoleColors.chooseColor("RESET") + "[FIELD][%s]: \nPosition: %d\n", this.getName(), this.getPosition());
    }
}
