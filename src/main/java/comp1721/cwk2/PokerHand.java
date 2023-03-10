package comp1721.cwk2;

import java.util.List;
import java.util.ArrayList;

/**
 * A class to represent the player's hand of playing cards.
 *
 * <p>This class is used to create a standard player's hand of 5 playing cards
 * that will be used in the program to simulate a game of poker. </p>
 *
 * @author Aodhan Gallagher
 */
public class PokerHand extends CardCollection {
    public static int FULL_SIZE = 5;
    private int noOfCards;
    private String[] input;
    
    /**
     * Creates an empty poker hand.
     */
    public PokerHand() {
        super();
    }

    /**
     * Creates a poker hand and populates it with the cards stated in the "message" parameter.
     *
     * @param string A string containing cards to be added to the poker hand.
     */
    public PokerHand(String string) {
        super();

        input = string.split(" ", 0);

        noOfCards = input.length;

        for (int i = 0; i < noOfCards; i++) {
            Card card = new Card(input[i]);

            add(card);
        }
    }

    /**
     * Overrides the add method to add error checking.
     *
     * <p>This method overrides the previously defined add method from
     * CardCollections.java and adds necessary error checking. </p>
     *
     * @param card The card to be added
     */
    @Override
    public void add(Card card) {
        if (contains(card) == true) {
            throw new CardException("Card already exists in hand");
        }

        if (size() == FULL_SIZE) {
            throw new CardException("Poker hand is full");
        }

        cards.add(card);
    }

    /**
     * Overrides the toString() method and adds cards to a string
     * with no whitespace at the end of the string
     *
     * <p>This method overrides the toString() method to add cards
     * from the poker hand to a string and if it is the last card,
     * whitespace is not added, else if it isn't the last card,
     * whitespace is added. </p>
     *
     * @return the string to be outputted
     */
    @Override
    public String toString() {
        String handOutput = "";

        for (int i = 0; i < cards.size(); i++) {
            if (i >= cards.size()-1) {
                handOutput += cards.get(i).toString();
            }
            else {
                handOutput += cards.get(i).toString() + " ";
            }
        }

        return handOutput;
    }

    /**
     * Overrides the discard method to add error checking.
     *
     * <p>This method overrides the previously defined discard method from
     * CardCollections.java and adds necessary error checking. </p>
     */
    @Override
    public void discard() {
        if(cards.isEmpty() == true) {
            throw new CardException("Cannot discard from an empty hand");
        }
        cards.clear();
    }

    /**
     * Empties the poker hand by discarding all of the cards and returning them to the deck.
     *
     * @param deck the card deck where the cards should be added to.
     */
    public void discardTo(Deck deck) {
        for (Card i : cards) {
            deck.add(i);
        }
        
        discard();
    }

    /**
     * Predicate method to check if the player's poker hand contains a pair.
     *
     * @return a boolean value dependent on if the poker hand contains a pair or not.
     */
    public boolean isPair() {
        if (cards.size() != FULL_SIZE) {
            return false;
        }

        int pairCount = 0;

        for (int i = 0; i < FULL_SIZE-1; i++) {
            for (int j = i+1; j < FULL_SIZE; j++) {
                if  (cards.get(i).getRank().toString().equals(cards.get(j).getRank().toString()) && i != j) {
                    pairCount += 1;
                }
            }
        }

        if (pairCount == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Predicate method to check if the player's poker hand contains two pairs.
     *
     * @return a boolean value dependent on if the poker hand contains two pairs or not.
     */
    public boolean isTwoPairs() {
        if (cards.size() != FULL_SIZE) {
            return false;
        }

        int pairCount = 0;

        for (int i = 0; i < FULL_SIZE-1; i++) {
            for (int j = i+1; j < FULL_SIZE; j++) {
                if  (cards.get(i).getRank().toString().equals(cards.get(j).getRank().toString()) && i != j) {
                    pairCount += 1;
                }
            }
        }

        if (pairCount == 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Predicate method to check if the player's poker hand contains a three of a kind.
     *
     * @return a boolean value dependent on if the poker hand contains a three of a kind or not.
     */
    public boolean isThreeOfAKind() {
        if (cards.size() != FULL_SIZE) {
            return false;
        }

        int rankCount = 0;

        for (int i = 0; i < FULL_SIZE-1; i++) {
            for (int j = i+1; j < FULL_SIZE; j++) {
                if  (cards.get(i).getRank().toString().equals(cards.get(j).getRank().toString()) && i != j) {
                    rankCount += 1;
                }
            }
        }

        if (rankCount == 3) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Predicate method to check if the player's poker hand contains a four of a kind.
     *
     * @return a boolean value dependent on if the poker hand contains a four of a kind or not.
     */
    public boolean isFourOfAKind() {
        if (cards.size() != FULL_SIZE) {
            return false;
        }

        int rankCount = 0;

        for (int i = 0; i < FULL_SIZE-1; i++) {
            for (int j = i+1; j < FULL_SIZE; j++) {
                if  (cards.get(i).getRank().toString().equals(cards.get(j).getRank().toString()) && i != j) {
                    rankCount += 1;
                }
            }
        }

        if (rankCount >= 4) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Predicate method to check if the player's poker hand contains a full house.
     *
     * @return a boolean value dependent on if the poker hand contains a full house or not.
     */
    public boolean isFullHouse() {
        return false;
    }

    /**
     * Predicate method to check if the player's poker hand contains a flush.
     *
     * @return a boolean value dependent on if the poker hand contains a flush or not.
     */
    public boolean isFlush() {
        if (cards.size() != FULL_SIZE) {
            return false;
        }

        int suitCount = 0;
        String firstSuit = cards.get(0).getSuit().toString();

        for (int i = 1; i < FULL_SIZE; i++) {
            if  (cards.get(i).getSuit().toString().equals(firstSuit)) {
                suitCount += 1;
            }
        }

        if (suitCount >= 4) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Predicate method to check if the player's poker hand contains a straight.
     *
     * @return a boolean value dependent on if the poker hand contains a straight or not.
     */
    public boolean isStraight() {
        return false;
    }
}