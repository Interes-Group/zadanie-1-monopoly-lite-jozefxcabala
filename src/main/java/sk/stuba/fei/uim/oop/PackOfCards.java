package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class PackOfCards {
    private final int sizeOfPackOfCards = 10;
    final ArrayList<Card> cards;
    private int actualCardIndex;

    public PackOfCards() {
        this.cards = new ArrayList<>();
        this.actualCardIndex = 0;

        this.cards.add(new PoliceCard("Ops! Police :(", "Bol si chyteny policiou, musis ist do vazenia!"));
        this.cards.add(new BonusCard( "Bonus!", "Dostavas 2 000 000 € od banky!", 2000000));
        this.cards.add(new BonusCard("Bonus!", "Dostavas 1 000 000 € od banky!",1000000));
        this.cards.add(new FineCard( "Pokuta!", "Musis zaplatit pokutu 2 000 000 €!", 2000000));
        this.cards.add(new FineCard("Pokuta!", "Musis zaplatit pokutu 3 000 000 €!", 3000000));
        this.cards.add(new StartCard( "Chod na start!", "Presun sa na start a prevezmi si peniaze z banky!"));
        this.cards.add(new PoliceCard( "Ops! Police :(", "Bol si chyteny policiou, musis ist do vazenia!"));
        this.cards.add(new BonusCard( "Bonus!", "Dostavas 1 000 000 € od banky!", 1000000));
        this.cards.add(new BonusCard( "Bonus!", "Dostavas 1 500 000 € od banky!",1500000));
        this.cards.add(new FineCard( "Pokuta!", "Musis zaplatit pokutu 5 000 000 €!", 5000000));

    }

    public int getSizeOfPackOfCards() {
        return sizeOfPackOfCards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card getCard(){
        Card firstCard = this.cards.get(this.actualCardIndex % this.sizeOfPackOfCards);
        this.actualCardIndex += 1;

        return firstCard;
    }
}
