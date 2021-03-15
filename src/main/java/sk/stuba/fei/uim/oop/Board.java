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
        this.fields.add(new Building("Bratislavsky hrad", 1, 50000000, 10000000));
        this.fields.add(new Chance("Chance", 2));
        this.fields.add(new Building("Dom sv. Martina", 3, 10000000, 2500000));
        this.fields.add(new Building("Stara radnica", 4, 10000000, 3000000));
        this.fields.add(new Building("Primacialny palac", 5, 15000000, 5000000));
        this.fields.add(new Building("Grasalkovicov palac", 6, 15000000, 5000000));
        this.fields.add(new Prison("Prison", 7));
        this.fields.add(new Building("Michalska veza s branou", 8, 5000000, 2000000));
        this.fields.add(new Chance("Chance", 9));
        this.fields.add(new Building("Mirbachov palac", 10, 15000000, 5000000));
        this.fields.add(new Building("Hrad Devin", 11, 25000000, 9000000));
        this.fields.add(new Fees("Pay fees!", 12));
        this.fields.add(new Building("Slavin", 13, 20000000, 5000000));
        this.fields.add(new Chance("Chance", 14));
        this.fields.add(new Building("Modry kostol", 15, 10000000, 2000000));
        this.fields.add(new Building("Cumil", 16, 1000000, 300000));
        this.fields.add(new Building("UFO", 17, 2000000, 500000));
        this.fields.add(new Building("SND", 18, 8000000, 2000000));
        this.fields.add(new Police("Police!", 19));
        this.fields.add(new Building("Arena Ondreja Nepelu", 20, 13000000, 4000000));
        this.fields.add(new Chance("Chance", 21));
        this.fields.add(new Building("Kotolna", 22, 500000, 150000));
        this.fields.add(new Building("Aupark", 23, 8000000, 3000000));
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
