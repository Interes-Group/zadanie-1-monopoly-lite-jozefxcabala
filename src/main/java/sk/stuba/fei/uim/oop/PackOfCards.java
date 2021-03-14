package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class PackOfCards {
    private int sizeOfPackOfCards = 10;
    final ArrayList<Card> cards;

    public PackOfCards() {
        this.cards = new ArrayList<>();

        this.cards.add(new Card(0, "Ops! Police :(", "Bol si chyteny policiou, musis ist do vazenia!", 6));
        this.cards.add(new Card(1, "Bonus!", "Dostavas 500€ od banky!", 500));
        this.cards.add(new Card(2, "Bonus!", "Dostavas 2000€ od banky!",2000));
        this.cards.add(new Card(3, "Pokuta!", "Musis zaplatit pokutu 500€!", 500));
        this.cards.add(new Card(4, "Pokuta!", "Musis zaplatit pokutu 2000€!", 2000));
        this.cards.add(new Card(5, "Darcek!", "Kazdy hrac ti musi dat 1000€!", 1000));
        this.cards.add(new Card(6, "Ops! Police :(", "Bol si chyteny policiou, musis ist do vazenia!", 6));
        this.cards.add(new Card(7, "Bonus!", "Dostavas 500€ od banky!", 500));
        this.cards.add(new Card(8, "Bonus!", "Dostavas 2000€ od banky!",2000));
        this.cards.add(new Card(9, "Pokuta!", "Musis zaplatit pokutu 1500€!", 1500));
    }

    public int getSizeOfPackOfCards() {
        return sizeOfPackOfCards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card getCard(){
        System.out.println("Potiahol si tuto kartu!");
        Card firstCard = this.cards.get(0);
        this.cards.remove(0);
        this.sizeOfPackOfCards -= 1;
        return firstCard;
    }
}
