
/*  - Here we have an object used to represent the playing deck.
    - Contains the cards in an array list and keeps track of the number of cards.
    - Contains a 'shuffle' method which allows the deck to be shuffled.
 */


import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deckList = new ArrayList();



    // Constructor ->

    public Deck() {


    }



    public void shuffleDeck() {

        int i;
        int n = deckList.size();

        for (i = 0; i < (n - 1); i++) {

            Random rand = new Random();

            int j = rand.nextInt(n - 1) + i;

            Card iIndex = deckList.remove(i);
            Card jIndex = deckList.remove(j);

            deckList.add(i, jIndex);
            deckList.add(j, iIndex);

        }

    }




    // Accessors ->

    public Card getNextCard() {

        return deckList.remove(0);
    }


    public void addCard(Card card) {

            deckList.add(card);
    }


    public int size() {

        return deckList.size();
    }


}
