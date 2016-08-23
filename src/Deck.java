
/*  - Here we have an object used to represent the playing deck.
    - Contains the cards in an array list and keeps track of the number of cards.
    - Contains a 'shuffle' method which allows the deck to be shuffled.
 */


import java.util.ArrayList;

public class Deck {

    private int numCards = 0;
    private ArrayList<Card> deckList = new ArrayList();

    // Constructor ->
    public Deck() {


    }



    public void shuffleDeck() {




    }


    // Accessors ->
    public int getNumCards() {
        return numCards;
    }

    public Card getNextCard() {

        if(deckList.size() != 0) {
            this.numCards--;
            return deckList.remove(0);
        } else {
            return null;
        }
    }

    public void addCard(Card card) {

        if (deckList.size() < 54) {
            deckList.add(card);
            this.numCards++;
        }
    }


}
