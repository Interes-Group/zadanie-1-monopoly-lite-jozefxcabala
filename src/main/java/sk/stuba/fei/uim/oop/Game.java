package sk.stuba.fei.uim.oop;

import java.security.Key;
import java.util.ArrayList;

public class Game {
    final int entryCash = 2000;
    private int numberOfPlayers;
    private ArrayList<Player> players;
    private PackOfCards cards;
    private Board board;

    Game() {
        System.out.println("Welcome to Monopoly!\n");
        gameInicialization();
        printPlayers();
        printBoard();
        printPackOfCards();
        System.out.println(cards.getCard().toString());
        printPackOfCards();
    }

    private void gameInicialization(){
        playerInicialization();
        this.board = new Board();
        this.cards = new PackOfCards();
    }

    private void playerInicialization(){
        this.numberOfPlayers = KeyboardInput.readInt("Enter number of players");
        this.players = new ArrayList<>();

        for(int i = 0; i < this.numberOfPlayers; i++){
            this.players.add(new Player(KeyboardInput.readString("Entry name of player"), KeyboardInput.readString("Entry color of player"),
                    KeyboardInput.readString("Entry figure of player"), i, true, 1, this.entryCash));
            System.out.println();
        }
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    private void printPlayers(){
        for(int i = 0; i < this.numberOfPlayers; i++){
            System.out.println(this.players.get(i).toString());
        }
    }

    private void printBoard(){
        for(int i = 0; i < this.board.getSizeOfBoard(); i++){
            System.out.println(this.board.getFields().get(i).toString());
        }
    }

    private void printPackOfCards(){
        for(int i = 0; i < this.cards.getSizeOfPackOfCards(); i++){
            System.out.println(this.cards.getCards().get(i).toString());
        }
    }
}
