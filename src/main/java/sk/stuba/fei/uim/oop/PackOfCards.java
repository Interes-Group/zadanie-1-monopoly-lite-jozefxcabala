package sk.stuba.fei.uim.oop;

import java.util.ArrayList;

public class PackOfCards {
    private final int sizeOfPackOfCards = 10;
    final ArrayList<Card> cards;
    private int actualCardIndex;

    public PackOfCards() {
        this.cards = new ArrayList<>();
        this.actualCardIndex = 0;

        this.cards.add(new PoliceCard("Ops! Police :(", "You are arrested, go to jail!"));
        this.cards.add(new BonusCard( "Bonus!", "The bank will give you 2 000 000 € !", 2000000));
        this.cards.add(new BonusCard("Bonus!", "The bank will give you 1 000 000 € !!",1000000));
        this.cards.add(new FineCard( "Fine!", "Pay 2 000 000 € fine!", 2000000));
        this.cards.add(new FineCard("Fine!", "Pay 3 000 000 € fine!", 3000000));
        this.cards.add(new StartCard("Go to the start!", "Go to the start and collect money from the bank!"));
        this.cards.add(new PoliceCard( "Ops! Police :(", "You are arrested, go to jail!"));
        this.cards.add(new BonusCard( "Bonus!", "The bank will give you 1 000 000 € !", 1000000));
        this.cards.add(new BonusCard( "Bonus!", "The bank will give you 1 500 000 € !",1500000));
        this.cards.add(new FineCard( "Fine!", "Pay 5 000 000 € fine!", 5000000));

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
