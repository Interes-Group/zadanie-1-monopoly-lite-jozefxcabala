package sk.stuba.fei.uim.oop;

public abstract class Card {
    private final String name;
    private final String description;

    public Card(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    abstract void action(Player player, Board board);

    @Override
    public String toString() {
        return String.format(ConsoleColors.chooseColor("RESET") + "[CARD][%s]: \nDescription of card: %s\n", this.getName(), this.getDescription());
    }
}
