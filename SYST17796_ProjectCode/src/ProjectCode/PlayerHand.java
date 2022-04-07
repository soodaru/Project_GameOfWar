/**
 * SYST 17796 Project
 */
package ProjectCode;

import java.util.ArrayList;

/**
 *
 * @author Ayah, Arushi, Kate, and Ariel
 */
public class PlayerHand extends Deck {
    private ArrayList<StandardCard> hand;
    
    public PlayerHand(int size) {
        super(size);
        hand = new ArrayList();
        cards = hand;
    }
    
    /**
     * Adds card to end of hand
     * @param card is added to PlayerHand
     */
    public void addCardToHand(StandardCard card) {
        if (card == null) {
            // Throws excpetion if null object is passed to method
            throw new NullPointerException("Can't add a null card to a cards.");
        }
        hand.add(card);
    }
    
    /**
     * Adds all cards to end of player's hand
     * @param cards are added to PlayerHand
     */
    public void addCards(ArrayList<StandardCard> cards) {
        hand.addAll(cards);
    }
    
    /**
     * Draws any number of cards from player's hand
     * @param numCards to be drawn from hand 
     * @return ArrayList of cards drawn
     */
    public ArrayList<StandardCard> drawCards(int numCards) {
        if (numCards > hand.size()) {
            return null;
        }

        ArrayList<StandardCard> draw = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            draw.add(hand.remove(0));
        }

        return draw;
    }
    
    /**
     * Draws top card from player's hand
     * Returns null if hand size is empty
     * @return StandardCard from top of hand
     */
    public StandardCard drawTopCard() {
        if (hand.size() < 1) {
            return null;
        }
        
        return hand.remove(0);
    }
    
    /**
     * @return int size of player's hand
     */
    public int getHandSize() {
        return hand.size();
    }
}