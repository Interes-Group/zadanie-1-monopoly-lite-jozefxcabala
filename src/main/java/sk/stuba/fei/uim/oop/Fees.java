package sk.stuba.fei.uim.oop;

public class Fees extends Field{
    Fees(String name, int position){
        super(name, position);
    }

    @Override
    void action(Player player, Board board) {
        System.out.printf("[%s]: You must pay 20%% fees from your wealthy[%d]!\n", player.getName(), (20*player.getMoney()/100));
        player.setMoney(player.getMoney() - 20*player.getMoney()/100);
    }

    @Override
    public String toString() {
        return String.format("[FIELD][%s]: \nPosition: %d\n", this.getName(), this.getPosition());
    }
}

