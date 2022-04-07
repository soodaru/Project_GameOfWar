/**
 * SYST 17796 Project
 */
package ProjectCode;

import BaseCode.GroupOfCards;
import ProjectCode.StandardCard.Rank;
import ProjectCode.StandardCard.Suit;
import java.util.ArrayList;

/**
 *
 * @author Ayah, Arushi, Kate, and Ariel
 */
public class Deck extends GroupOfCards {
    protected final ArrayList<StandardCard> deck;
    
    public Deck(int size) {
        super(size);
        deck = new ArrayList();
        super.cards = deck;
        createDeck();
        super.shuffle();
    }
    
    /**
     * Creates deck by iterating through every suit and rank enum to create StandardCard object
     */
    private void createDeck() {
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
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
     * Deals cards from deck to given player's hand
     * @param hand is player's hand to deal cards from deck
     */
    public void dealHand(PlayerHand hand) {
        for (int i = 0; i < hand.getHandSize(); i++) {
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
    
}