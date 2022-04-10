/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package BaseCode;

import ProjectCode.PlayerHand;
import ProjectCode.StandardCard;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modifiers Ayah, Arushi, Kate, and Ariel - April 2022
 */
public final class Deck {

    //The group of deck, stored in an ArrayList
    private ArrayList<StandardCard> deck = new ArrayList();
    private int size;//the size of the grouping

    public Deck(int size) {
        this.size = size;
        deck = new ArrayList();
        createDeck();
        shuffle();
    }
    
    public void shuffle() {
        Collections.shuffle(deck);
    }
    
    /**
     * Creates deck by iterating through every suit and rank enum to create StandardCard object
     */
    private void createDeck() {
        for (StandardCard.Suit s : StandardCard.Suit.values()) {
            for (StandardCard.Rank r : StandardCard.Rank.values()) {
                deck.add(new StandardCard(r, s));
            }
        }
    }
    
    /**
     * Deals cards from deck
     * @return StandardCard that is dealt from deck
     */
    public StandardCard dealCard() {
        return deck.remove(deck.size() - 1);
    }
    
    /**
     * Deal number of cards entered by user to a player's hand
     * @param hand to deal cards to
     */
    public void dealHand(PlayerHand hand) {  
        for (int i = 0; i < hand.getSize(); i++) {
            hand.addCardToHand(dealCard());
        }
    }
    
    /**
     * Adds cards to beginning of deck
     * @param card is card to be added to deck
     */
    public void addCard(StandardCard card) {
        deck.add(0, card);
    }

    /**
     * @return the size of the deck
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size of the deck
     */
    public void setSize(int size) {
        this.size = size;
    }

}//end class
