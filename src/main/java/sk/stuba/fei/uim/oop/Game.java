package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    final int entryCash = 2000;
    final int newLapCash = 2000;
    private int numberOfPlayers;
    private ArrayList<Player> players;
    private Board board;
    private Player winner;

    Game() {
        System.out.println("Welcome to Monopoly!\n");
        gameInicialization();
        this.winner = game();
    }

    private Player game(){
        int i = 0;
        while(i < 10) {
            gameOneStep();
            i++;
        }

        return players.get(0);
    }

    private void gameOneStep(){
        for(int i = 0; i < this.numberOfPlayers; i++) {
            if(!this.checkPrison(players.get(i))) {
                changePosition(players.get(i));
                doAction(players.get(i));
            }
            System.out.println(players.get(i).toString());
        }
    }

    private void checkNewLap(Player player){
        if(player.isNewLap()) {
            player.setMoney(player.getMoney() + this.newLapCash);
            player.setNewLap(false);
        }
    }

    private boolean checkPrison(Player player){
        if(player.getLapInPrison() > 0){
            player.setLapInPrison(player.getLapInPrison()-1);
            return true;
        }
        else
            return false;
    }

    private void doAction(Player player){
        checkNewLap(player);
        player.getActualField().action(player, this.board);
    }

    private void gameInicialization(){
        this.winner = null;
        this.board = new Board();
        playerInicialization();

        printPlayers();
    }

    private int rollTheDice(){
        Random rand = new Random();
        return rand.nextInt(6) + 1;
    }

    private void changePosition(Player player){
        int dice = this.rollTheDice();
        System.out.printf("Hrac[%s] hodil kockou cislo: %d\n", player.getName(), dice);
        if((player.getActualField().getPosition() + dice) < this.board.getSizeOfBoard()) {
            player.setActualField(this.board.getFieldByPosition(player.getActualField().getPosition() + dice));
            player.setNewLap(false);
        }
        else {
            player.setActualField(this.board.getFieldByPosition(player.getActualField().getPosition() + dice - this.board.getSizeOfBoard()));
            player.setNewLap(true);
        }
    }

    private void playerInicialization(){
        this.numberOfPlayers = KeyboardInput.readInt("Enter number of players");
        this.players = new ArrayList<>();

        for(int i = 0; i < this.numberOfPlayers; i++){
            this.players.add(new Player(KeyboardInput.readString("Entry name of player"), KeyboardInput.readString("Entry color of player"),
                    KeyboardInput.readString("Entry figure of player"), i,  this.entryCash, board.getFields().get(0)));
            System.out.println();
        }
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
        for(int i = 0; i < this.board.getCards().getSizeOfPackOfCards(); i++){
            System.out.println(this.board.getCards().getCard().toString());
        }
    }
}
