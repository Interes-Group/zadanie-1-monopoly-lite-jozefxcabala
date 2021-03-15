package sk.stuba.fei.uim.oop;

public class FineCard extends Card{
    private final int money;

    public FineCard(String name, String description, int money) {
        super(name, description);
        this.money = money;
    }

    @Override
    void action(Player player, Board board) {
        System.out.printf("[%s]: You choose this card[%s]!\nDescription: %s\n", player.getName(), this.getName(), this.getDescription());
        player.setMoney(player.getMoney()-this.money);
    }
}
