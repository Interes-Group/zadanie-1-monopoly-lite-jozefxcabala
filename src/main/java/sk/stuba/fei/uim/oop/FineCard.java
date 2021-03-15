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
        if(player.getMoney() < this.money) {
            System.out.printf("[%s]: You dont have enough money[%d €]! Zaplat vsetko co mas a vyhlas bankrot!\n", player.getName(), player.getMoney());
            player.setMoney(-1);
            player.setStatus(false);
        }
        else
            player.setMoney(player.getMoney()-this.money);
    }
}
