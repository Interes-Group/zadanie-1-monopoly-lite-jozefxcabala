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
                buyProperty(player, board);
            } else if (this.propertyOf != player) {
                payFeeToPlayer(player, board);
            } else {
                System.out.printf(ConsoleColors.chooseColor(player.getColor()) + "[%s]: You are visit your property[%s]!\n", player.getName(), this.getName());
            }
        }
        else{
            this.propertyOf = null;
        }
    }

    private void buyProperty(Player player, Board board){
        if (player.getMoney() >= this.value) {
            System.out.printf(ConsoleColors.chooseColor(player.getColor()) + "[%s]: This building is for sale. [%s], take your pick... [y/n]\n", player.getName(), this.getName());
            System.out.printf(ConsoleColors.chooseColor("RESET") + "\n[FIELD][%s]: \nPosition: %d\nValue: %d €\nFine: %d €\nProperty of: %s\n", this.getName(), this.getPosition(),
                    this.getValue(), this.getFine(), (this.getPropertyOf() != null)?this.getPropertyOf().getName():"i doesnt have owner");
            String choice = "";

            while(!(choice.equals("y") || choice.equals("n"))){
                choice = KeyboardInput.readString(ConsoleColors.chooseColor(player.getColor()) + "\n[y/n]");
                if(!(choice.equals("y") || choice.equals("n")))
                    System.out.printf("[INFO]: %s is wrong input, try again!", choice);
            }
            if (choice.equals("y")) {
                System.out.printf(ConsoleColors.chooseColor(player.getColor()) + "\n[%s]: You have new property!\n", player.getName());
                this.propertyOf = player;
                player.setMoney(player.getMoney() - this.value);
                player.getProperties().add(player.getActualField());
            } else
                System.out.printf(ConsoleColors.chooseColor(player.getColor()) + "\n[%s]: You choose dont buy new property[%s]!\n", player.getName(), this.getName());
        } else
            System.out.printf(ConsoleColors.chooseColor(player.getColor()) + "[%s]: You dont have enough money for buing this[%s][%d €]!\n", player.getName(), this.getName(), this.getValue());

    }

    private void payFeeToPlayer(Player player, Board board){
        System.out.printf(ConsoleColors.chooseColor(player.getColor()) + "[%s]: You stepped on a player box[%s][%s], you have to pay a fee[%d €]!\n",
                player.getName(), this.propertyOf.getName(), this.getName(), this.fine);
        if(player.getMoney() < this.fine){
            System.out.printf(ConsoleColors.chooseColor(player.getColor()) + "[%s]: You dont have enough money! Pay everything you have[%d €]!\n",
                    player.getName(), player.getMoney());
            this.propertyOf.setMoney(this.propertyOf.getMoney() + player.getMoney());
            player.setMoney(-1);
            player.setStatus(false);
        }
        else{
            player.setMoney(player.getMoney() - this.fine);
            this.propertyOf.setMoney(this.propertyOf.getMoney() + this.fine);
        }
    }

    @Override
    public String toString() {
        return String.format(ConsoleColors.chooseColor("RESET") + "\n[FIELD][%s]: \nPosition: %d\nValue: %d €\nFine: %d €\nProperty of: %s\n", this.getName(), this.getPosition(),
                this.getValue(), this.getFine(), (this.getPropertyOf() != null)?this.getPropertyOf().getName():"I doesnt have owner...");
    }
}

