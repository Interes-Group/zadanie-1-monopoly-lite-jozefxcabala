package sk.stuba.fei.uim.oop;

import java.util.Random;

public class Player{
    private String name;
    private String color;
    private String figure;
    private int id;
    private boolean status; //true - in game , false - out of game
    private Field actualField;
    private int money;
    private boolean newLap;
    private int lapInPrison;

    public Player(){
        System.out.println("I create player!");
    }

    public Player(String name, String color, String figure, int id, int money, Field startPosition) {
        this.name = name;
        this.color = color;
        this.figure = figure;
        this.id = id;
        this.money = money;
        this.status = true;
        this.actualField = startPosition;
        this.newLap = false;
        this.lapInPrison = 0;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return String.format("Player: %d\nName: %s\nColor: %s\nFigure: %s\nPosition: %s\nMoney: %d\n", this.getId(), this.getName(), this.getColor(), this.getFigure(), this.getActualField().getName(), this.getMoney());
    }
}
