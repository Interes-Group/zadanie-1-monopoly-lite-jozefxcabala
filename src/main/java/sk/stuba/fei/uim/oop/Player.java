package sk.stuba.fei.uim.oop;

public class Player{
    private String name;
    private String color;
    private String figure;
    private int id;
    private boolean status; //true - in game , false - out of game
    private int position;
    private int money;
    //private Building properties;

    public Player(){
        System.out.println("I create player!");
    }

    public Player(String name, String color, String figure, int id, boolean status, int position, int money) {
        this.name = name;
        this.color = color;
        this.figure = figure;
        this.id = id;
        this.status = status;
        this.position = position;
        this.money = money;
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return String.format("Player: %d\nName: %s\nColor: %s\nFigure: %s\nPosition: %d\nMoney: %d\n", this.getId(), this.getName(), this.getColor(), this.getFigure(), this.getPosition(), this.getMoney());
    }
}
