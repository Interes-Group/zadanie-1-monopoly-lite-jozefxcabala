package sk.stuba.fei.uim.oop;

import java.security.Key;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Game {
    final int entryCash = 10000000;
    final int newLapCash = 1000000;
    private int numberOfPlayers = 0;
    private ArrayList<Player> players;
    private Board board;
    private Player winner;

    Game() {
        System.out.println("[INFO]: Welcome to Monopoly!");
        gameInicialization();
        this.winner = game();
        System.out.printf("[%s]: You are winner!\n", this.winner.getName());
        System.out.println(this.winner.toString());
    }

    private Player game(){
        int numberOfLaps = 1;
        while(checkWinner()) {
            System.out.printf("[LAP %d]\n------------------------------\n", numberOfLaps);
            gameOneStep();

            if(!checkWinner())
                break;

            numberOfLaps += 1;
        }

        return findWinner();
    }

    private void gameOneStep(){
        for(int i = 0; i < this.numberOfPlayers; i++) {
            if(this.players.get(i).isStatus()) {
                System.out.printf("[%s]: Is your turn! Press enter...", this.players.get(i).getName());
                KeyboardInput.readString();
                System.out.print("[INFO]: info about player before his turn\n");
                if (!this.checkPrison(players.get(i))) {
                    System.out.println(players.get(i).toString());
                    changePosition(players.get(i));
                    doAction(players.get(i));
                    checkPlayerStatus(players.get(i));
                } else {
                    System.out.printf("[%s]: You are in prison! [%d] laps yet!\n", this.players.get(i).getName(), this.players.get(i).getLapInPrison());
                }
                System.out.print("[INFO]: info about player after his turn\n");
                System.out.println(players.get(i).toString());

                if(!checkWinner())
                    break;
            }
        }
    }

    private void checkNewLap(Player player){
        if(player.isNewLap() && player.isStatus()) {
            System.out.printf("[%s]: You start new lap! +%d€ on your account!\n", player.getName(), this.newLapCash);
            player.setMoney(player.getMoney() + this.newLapCash);
            player.setNewLap(false);
        }
    }

    private void returnProperties(Player player){
        for(int i = 0; i < player.getProperties().size(); i++){
            player.getProperties().get(i).action(player, this.board);
        }
    }

    private void checkPlayerStatus(Player player){
        if(player.getMoney() < 0){
            System.out.printf("[%s]: You lost!\n", player.getName());
            player.setStatus(false);
            returnProperties(player);
            player.getProperties().clear();
        }
    }

    private boolean checkWinner(){
        int numberOfActivePlayers = 0;
        for(int i = 0; i < this.numberOfPlayers; i++){
            if(this.players.get(i).isStatus()) {
                numberOfActivePlayers += 1;
            }
        }

        return numberOfActivePlayers != 1;
    }

    private Player findWinner(){
        for(int i = 0; i < this.numberOfPlayers; i++)
            if(this.players.get(i).isStatus()){
                return this.players.get(i);
            }
        return null;
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
        player.getActualField().action(player, this.board);
        checkNewLap(player);
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
        System.out.printf("[%s]: Hadzes kockou! Press enter...", player.getName());
        KeyboardInput.readString();
        System.out.printf("[%s]: hodil kockou cislo[%d]\n", player.getName(), dice);
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
        while(this.numberOfPlayers < 2) {
            this.numberOfPlayers = KeyboardInput.readInt("[INFO]: Enter number of players");
            if(this.numberOfPlayers < 2)
                System.out.println("[INFO]: You enter wrong input! Try again!");

        }
        this.players = new ArrayList<>();

        for(int i = 0; i < this.numberOfPlayers; i++){
            this.players.add(new Player(KeyboardInput.readString("[INFO]: Entry name of player").toUpperCase(Locale.ROOT), KeyboardInput.readString("[INFO]: Entry color of player").toLowerCase(Locale.ROOT),
                    KeyboardInput.readString("[INFO]: Entry figure of player").toLowerCase(Locale.ROOT), this.entryCash, board.getFields().get(0)));
        }
    }

    private void printPlayers(){
        System.out.println("[INFO]: All players info\n");
        for(int i = 0; i < this.numberOfPlayers; i++){
            System.out.println(this.players.get(i).toString());
        }
    }

    private void printBoard(){
        System.out.println("[INFO]: Board info\n");
        for(int i = 0; i < this.board.getSizeOfBoard(); i++){
            System.out.println(this.board.getFields().get(i).toString());
        }
    }

    private void printPackOfCards(){
        System.out.println("[INFO]: All cards in pack info");
        for(int i = 0; i < this.board.getCards().getSizeOfPackOfCards(); i++){
            System.out.println(this.board.getCards().getCard().toString());
        }
    }
}
