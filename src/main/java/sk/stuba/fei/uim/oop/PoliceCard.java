package sk.stuba.fei.uim.oop;

public class PoliceCard extends Card{
    public PoliceCard(String name, String description) {
        super(name, description);
    }

    @Override
    void action(Player player, Board board) {
        System.out.printf(ConsoleColors.chooseColor(player.getColor()) + "[%s]: You choose this card[%s]!\nDescription: %s\n", player.getName(), this.getName(), this.getDescription());
        player.setActualField(board.getFieldByPosition(7));
        player.setLapInPrison(2);
    }
}
