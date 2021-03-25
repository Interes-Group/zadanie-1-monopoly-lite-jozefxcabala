package sk.stuba.fei.uim.oop;

public class Start extends Field{
    private final int newLapCash;
    Start(String name, int position){
        super(name, position);
        this.newLapCash = 1000000;
    }

    @Override
    void action(Player player, Board board) {
        System.out.printf(ConsoleColors.chooseColor(player.getColor()) + "[%s]: You are on start!\n", player.getName());
    }

    @Override
    public String toString() {
        return String.format(ConsoleColors.chooseColor("RESET") + "[FIELD][%s]: \nPosition: %d\n", this.getName(), this.getPosition());
    }
}
