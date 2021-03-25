package sk.stuba.fei.uim.oop;

public class FineCard extends Card{
    private final int money;

    public FineCard(String name, String description, int money) {
        super(name, description);
        this.money = money;
    }

    @Override
    void action(Player player, Board board) {
        System.out.printf(ConsoleColors.chooseColor(player.getColor()) + "[%s]: You choose this card[%s]!\nDescription: %s\n", player.getName(), this.getName(), this.getDescription());
        if(player.getMoney() < this.money) {
            System.out.printf(ConsoleColors.chooseColor(player.getColor()) + "[%s]: You are broke. [%d €]! Pay everything you have and declare bankruptcy!\n", player.getName(), player.getMoney());
            player.setMoney(-1); //Player doesnt have money, player lost
            player.setStatus(false);
        }
        else
            player.setMoney(player.getMoney()-this.money);
    }
}
