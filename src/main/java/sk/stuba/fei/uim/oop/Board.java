package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class Board {
    private final int sizeOfBoard = 24;
    private final ArrayList<Field> fields;
    private final PackOfCards cards;

    Board() {
        this.fields = new ArrayList<>();
        this.cards = new PackOfCards();

        this.fields.add(new Start("Start", 0));
        this.fields.add(new Building("Dom1", 1, 200, 50));
        this.fields.add(new Chance("Chance", 2));
        this.fields.add(new Building("Dom2", 3, 200, 50));
        this.fields.add(new Building("Dom3", 4, 200, 50));
        this.fields.add(new Building("Dom4", 5, 200, 50));
        this.fields.add(new Prison("Prison", 6));
        this.fields.add(new Building("Dom5", 7, 200, 50));
        this.fields.add(new Chance("Chance", 8));
        this.fields.add(new Building("Dom6", 9, 200, 50));
        this.fields.add(new Building("Dom7", 10, 200, 50));
        this.fields.add(new Fees("Pay fees!", 11));
        this.fields.add(new Building("Dom8", 12, 200, 50));
        this.fields.add(new Building("Dom9", 13, 200, 50));
        this.fields.add(new Chance("Chance", 14));
        this.fields.add(new Building("Dom10", 15, 200, 50));
        this.fields.add(new Building("Dom11", 16, 200, 50));
        this.fields.add(new Building("Dom12", 17, 200, 50));
        this.fields.add(new Building("Dom13", 18, 200, 50));
        this.fields.add(new Police("Police!", 19));
        this.fields.add(new Building("Dom14", 20, 200, 50));
        this.fields.add(new Chance("Chance", 21));
        this.fields.add(new Building("Dom15", 22, 200, 50));
        this.fields.add(new Building("Dom16", 23, 200, 50));
    }

    public ArrayList<Field> getFields() {
        return fields;
    }

    public int getSizeOfBoard() {
        return sizeOfBoard;
    }

    public Field getFieldByPosition(int position){
        return this.fields.get(position);
    }

    public PackOfCards getCards() {
        return cards;
    }
}
