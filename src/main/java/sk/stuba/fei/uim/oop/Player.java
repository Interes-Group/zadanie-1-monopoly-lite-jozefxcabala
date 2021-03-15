package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class Player{
    private final String name;
    private final String color;
    private final String figure;
    private boolean status; //true - in game , false - out of game
    private Field actualField;
    private int money;
    private boolean newLap;
    private int lapInPrison;
    private ArrayList<Field> properties;

    public Player(String name, String color, String figure, int money, Field startPosition) {
        this.name = name;
        this.color = color;
        this.figure = figure;
        this.money = money;
        this.status = true;
        this.actualField = startPosition;
        this.newLap = false;
        this.lapInPrison = 0;
        this.properties = new ArrayList<>();
    }

    public ArrayList<Field> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Field> properties) {
        this.properties = properties;
    }

    public int getLapInPrison() {
        return lapInPrison;
    }

    public void setLapInPrison(int lapInPrison) {
        this.lapInPrison = lapInPrison;
    }

    public boolean isNewLap() {
        return newLap;
    }

    public void setNewLap(boolean newLap) {
        this.newLap = newLap;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getFigure() {
        return figure;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Field getActualField() {
        return actualField;
    }

    public void setActualField(Field position) {
        this.actualField = position;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    private StringBuilder getStringOfProperties(){
        StringBuilder properties = new StringBuilder();
        for (Field property : this.properties) {
            properties.append(property.getName());
            properties.append("-");
        }
        if(properties.length() > 0)
            properties.deleteCharAt(properties.length() - 1);

        return properties;
    }

    @Override
    public String toString() {
        return String.format("\n[%s]:\nColor: %s\nFigure: %s\nPosition: %s\nMoney: %d €\nLap in prison: %d\nProperties: %s\n", this.getName(),
                this.getColor(), this.getFigure(), this.getActualField().getName(), this.getMoney(), this.getLapInPrison(), getStringOfProperties());
    }
}
