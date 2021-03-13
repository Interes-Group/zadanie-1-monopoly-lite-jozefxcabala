package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class Card {
    private int id;
    private String name;
    private String description;
    private int action;

    public Card(int id, String name, String description, int action) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.action = action;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Id of card: %d\nName of card: %s\nDescription of card: %s\n", this.getId(), this.getName(), this.getDescription());
    }
}
