package sk.stuba.fei.uim.oop;

public class Building extends Field{
    private final int value;
    private final int fine;
    private Player propertyOf;

    public Building(String name, int position, int value, int fine) {
        super(name, position);
        this.value = value;
        this.fine = fine;
        this.propertyOf = null;
    }

    public int getValue() {
        return value;
    }

    public int getFine() {
        return fine;
    }


    public Player getPropertyOf() {
        return propertyOf;
    }

    public void setPropertyOf(Player propertyOf) {
        this.propertyOf = propertyOf;
    }

    @Override
    void action(Player player, Board board) {
        if(player.isStatus()) {
            if (this.propertyOf == null) {
                if (player.getMoney() >= this.value) {
                    System.out.printf("[%s]: Mozes kupit tuto budovu, zvol moznost... [y/n]\n", player.getName());
                    System.out.printf("\n[FIELD][%s]: \nPosition: %d\nValue: %d\nFine: %d\nProperty of: %s\n", this.getName(), this.getPosition(),
                            this.getValue(), this.getFine(), (this.getPropertyOf() != null)?this.getPropertyOf().getName():"i doesnt have owner");
                    if (KeyboardInput.readString("\n[y/n]").equals("y")) {
                        System.out.printf("\n[%s]: You have new property!\n", player.getName());
                        this.propertyOf = player;
                        player.setMoney(player.getMoney() - this.value);
                        player.getProperties().add(player.getActualField());
                    } else
                        System.out.printf("\n[%s]: You choose dont buy new property[%s]!\n", player.getName(), this.getName());
                } else
                    System.out.printf("[%s]: You dont have enough money for buing this[%s][%s]!\n", player.getName(), this.getName(), this.getValue());

            } else if (this.propertyOf != player) {
                System.out.printf("[%s]: Stupil si na policko Player[%s][%s], musis mu zaplatit poplatok[%d€]!\n",
                        player.getName(), this.propertyOf.getName(), this.getName(), this.fine);
                player.setMoney(player.getMoney() - this.fine);
                this.propertyOf.setMoney(this.propertyOf.getMoney() + this.fine);
            } else {
                System.out.printf("[%s]: You are visit your property[%s]!\n", player.getName(), this.getName());
            }
        }
        else{
            this.propertyOf = null;
        }
    }

    @Override
    public String toString() {
        return String.format("\n[FIELD][%s]: \nPosition: %d\nValue: %d\nFine: %d\nProperty of: %s\n", this.getName(), this.getPosition(),
                this.getValue(), this.getFine(), (this.getPropertyOf() != null)?this.getPropertyOf().getName():"i doesnt have owner");
    }
}

