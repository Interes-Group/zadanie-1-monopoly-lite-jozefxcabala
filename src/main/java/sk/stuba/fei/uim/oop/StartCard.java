package sk.stuba.fei.uim.oop;

public class StartCard extends Card{
    public StartCard(String name, String description) {
        super(name, description);
    }

    @Override
    void action(Player player, Board board) {
        System.out.printf("[%s]: You choose this card[%s]!\nDescription: %s\n", player.getName(), this.getName(), this.getDescription());
        player.setActualField(board.getFieldByPosition(0));
        player.setNewLap(true);
    }
}
