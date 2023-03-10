package comp1721.cwk2;

import comp1721.cwk2.Card.Suit;
import comp1721.cwk2.Card.Rank;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A class to represent the deck of playing cards.
 *
 * <p>This class is used to create a standard deck of 52 playing cards
 * that will be used in the program to simulate a game of poker. </p>
 *
 * @author Aodhan Gallagher
 */
public class Deck extends CardCollection {

    /**
     * Creates an empty deck of cards and populates it with each individual playing card.
     */
    public Deck() {
        super();
        
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                add(new Card(rank, suit));
            }
        }
    }

    /**
     * A method that gets ("deals") the first card in the deck.
     *
     * @return the first ("top") card in the deck.
     */
    public Card deal() {
        if (cards.size() == 0) {
            throw new CardException("You cannot deal from an empty deck");
        }

        Card topCard = cards.get(0);
        cards.remove(0);

        return topCard;
    }

    /**
     * Uses the shuffle method from the Collections package to
     * shuffle the order of the cards in the deck.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }
}