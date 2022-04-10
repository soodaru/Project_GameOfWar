/**
 * SYST 17796 Project
 */
package ProjectCode;

import BaseCode.Card;

/**
 *
 * @author Ayah, Arushi, Kate, and Ariel - April 2022
 */
public class StandardCard extends Card {
    /**
     * Sets all possible suits of a standard deck of cards
     */
    public enum Suit {
        HEART, DIAMOND, SPADE, CLUB
    }
    
    /**
     * Sets all possible ranks of a standard deck of cards and assigns int values for comparisons
     */
    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), 
        NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);
        
        private final int cardValue;
        
        Rank(int cardValue) {
            this.cardValue = cardValue;
        }
               
        public int getCardValue() {
            return this.cardValue;
        }
    }
    
    private final Suit suit;
    private final Rank rank;
    
    /**
     * Constructor creates StandardCard object with given rank and suit
     * @param rank is card's value
     * @param suit
     */
    public StandardCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    /**
     * @return the suit of the card
     */
    public Suit getSuit() {
        return this.suit;
    }

    /**
     * @return the rank of the card
     */
    public Rank getRank() {
        return rank;
    }
    
    public int getCardValue() {
        return rank.getCardValue();
    }
    
    /**
     * @return the String of card's rank and suit
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
    
}
