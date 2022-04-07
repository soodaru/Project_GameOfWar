/**
 * SYST 17796 Project
 */package ProjectCode;

import BaseCode.Game;
import BaseCode.Player;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Ayah, Arushi, Kate, and Ariel
 */
public class War extends Game {
    Scanner input = new Scanner(System.in);
    War warGame;
    public Player winner;
    private Player player1;
    private Player player2;
    private Deck deck;
    ArrayList<StandardCard> pile = new ArrayList();
    int maxRounds, numRounds, numGames = 1;
    int numPlayer1Won, numPlayer2Won;
    
    public War(String name) {
        super(name);     
    }
    
    /**
     * Starts game by creating Player, Deck, and PlayerHand objects
     * Sets each player's names and deals Deck evenly to each PlayerHand
     */
    public void startGame() {
        try {
            // Sets first round to round 1
            numRounds = 1;
        
            // Prints game number
            for (int i = 0; i < 10; i++)
                System.out.print("----------");

            System.out.println("\n\t\t\t\t\tWAR GAME #" + numGames + ":");

            for (int i = 0; i < 10; i++)
                System.out.print("----------");

            // Prompts user for max number of rounds
            do {
                System.out.print("\nWar can be a long game. What is the max number of rounds you would like to play? ");
                maxRounds = input.nextInt();
                input.nextLine();
                
                if (maxRounds < 0)
                    System.out.println("Invalid entry. Please enter positie integer for maxiumum number of rounds.");
            } while (maxRounds < 0);
        

            // Create new deck of cards
            deck = new Deck(52);

            // Get players to play War
            player1 = getPlayers().get(0);
            player2 = getPlayers().get(1);

            // Create player hands
            player1.setHand(new PlayerHand(26));
            player2.setHand(new PlayerHand(26));

            // Deal cards to hands
            dealHand(player1.getHand());    
            dealHand(player2.getHand());  

            // Prints each player's hands for testing
            /*
            System.out.println("Player 1:");
            for (int i = 0; i < 26; i++) {
                System.out.println(player1.getHand().getCards().get(i).toString());
            }
            System.out.println("\nPlayer 2:");
            for (int i = 0; i < 26; i++) {
                System.out.println(player2.getHand().getCards().get(i).toString());
            }
            */

            // Prints number of cards in each player's hand
            handSizeUpdate();

            // Starts main portion of game
            play();
        } catch (InputMismatchException e) {
            System.err.println("Invalid entry. Must enter integer for max number of rounds.");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    /**
     * Loops the battle() method until winner is declared
     * Checks size of each player's PlayerHand between each round 
     * Declares winner if one player's hand is empty
     */
    @Override
    public void play() {
        while (battle()) {
            if (player1.getHand().getHandSize() == 0) {
                // Player 2 wins
                winner = player2;
                numPlayer2Won++;
                break;
            } else if (player2.getHand().getHandSize() == 0) {
                // Player 1 wins
                winner = player1;
                numPlayer1Won++;
                break;
            } else if (numRounds > maxRounds) {
                if (player1.getHand().getHandSize() > player2.getHand().getHandSize()) {
                    winner = player1;
                    numPlayer1Won++;
                    break;
                } else if (player1.getHand().getHandSize() < player2.getHand().getHandSize()) {
                    winner = player2;
                    numPlayer2Won++;
                    break;
                } else {
                    winner = null;
                }
            }
        }
        declareWinner();  
    }
    
    /**
     * Models a round in a War card game
     * Each player draws a card and the player with the higher value gets all cards added to their hand
     * If the cards are equal in value, the war() method is invoked
     * @return boolean literal1 to reiterate through loop in play() method
     */
    private boolean battle() {
        System.out.println("\nRound " + numRounds + ":");
        player1.play();
        StandardCard player1DrawCard = player1.getHand().drawTopCard();
        if (player1DrawCard == null) {
            // Returns false if player 1 has no cards in their hand to draw
            return false;
        }
        
        // Displays card drawn from player 1's hand
        System.out.println(player1.getName() + " drew a " + player1DrawCard.toString());
        
        player2.play();
        StandardCard player2DrawCard = player2.getHand().drawTopCard();
        if (player2DrawCard == null) {
            // Returns false if player 2 has no cards in their hand to draw
            return false;
        }
        // Displays card drawn from player 2's hand
        System.out.println(player2.getName() + " drew a " + player2DrawCard.toString() + "\n");
        
        // Invokes compare() method to determine winner of the battle
        compare(player1DrawCard, player2DrawCard, pile);
            
        // Returns true if both player 1 and player 2 can draw a card from their hand
        return true;
    }
    
    /**
     * Ensure that the playerID is unique
     *
     * @param player1Draw is the top card drawn from player 1's hand
     * @param player2Draw is the top card drawn from player 2's hand
     * @param pile is the cards to be added to the player's hand if war() method is invoked
     */
    private void compare(StandardCard player1Draw, StandardCard player2Draw, ArrayList<StandardCard> pile) {   
        // Increments number of rounds every time players compare cards
        numRounds++;

        // If player 1 draws the higher card, all cards are added to player 1's hand
        if (player1Draw.getCardValue() > player2Draw.getCardValue()) {
            player1.getHand().addCardToHand(player1Draw);
            player1.getHand().addCardToHand(player2Draw);
            
            if (!pile.isEmpty()) {
                // pile is not empty if war() method is invoked and cards from pile are added to player 1's hand
                player1.getHand().addCards(pile);
                System.out.println(player1.getName() + " wins the war! All cards were added to your hand.");
            } else {
                // pile is empty if war() method is not invoked
                System.out.println(player1.getName() + " wins this battle! All cards were added to your hand.");
            }

            handSizeUpdate();
        // If player 2 draws the higher card, all cards are added to player 2's hand
        } else if (player1Draw.getCardValue() < player2Draw.getCardValue()) {
            player2.getHand().addCardToHand(player1Draw);
            player2.getHand().addCardToHand(player2Draw);
            
            // pile is not empty if war() method is invoked and cards from pile are added to player 1's hand
            if (!pile.isEmpty()) {
                player2.getHand().addCards(pile);
                System.out.println(player2.getName() + " wins the war! All cards were added to your hand.");
            } else {
                // pile is empty if war() method is not invoked
                System.out.println(player2.getName() + " wins this battle! All cards were added to your hand.");
            }

            handSizeUpdate();
        } else {
            System.out.println("War! Draw 3 cards face down and 1 card face up.");
            pile.add(player1Draw);
            pile.add(player2Draw);
            war(pile);
        }
    }
    
    /**
     * Invoked when both players draw cards of the same value
     * Each player draws 3 cards face down and adds to pile then draw 1 card face up
     * Winner of the war adds all 10 cards to their hand
     * @param pile contains cards drawn before and during war until a player wins the war
     */
    private void war(ArrayList<StandardCard> pile) {
        if (player1.getHand().getHandSize() < 4) {
            winner = player2;
            numPlayer2Won++;
            System.out.println(player1.getName() + " doen't have enough cards in their hand.");
            declareWinner();
        } else if (player2.getHand().getHandSize() < 4) {
            winner = player1;
            numPlayer1Won++;
            System.out.println(player2.getName() + " doen't have enough cards in their hand.");
            declareWinner();
        }
        
        // Adds 3 cards from each player's hand to pile
        pile.addAll(player1.getHand().drawCards(3));
        pile.addAll(player2.getHand().drawCards(3));
        
        // Draws top card from each player's hand
        StandardCard player1DrawCard = player1.getHand().drawTopCard();
        StandardCard player2DrawCard = player2.getHand().drawTopCard();
        
        // Displays cards drawn
        System.out.println(player1.getName() + " drew a " + player1DrawCard.toString());
        System.out.println(player2.getName() + " drew a " + player2DrawCard.toString() + "\n");
        
        // Passes top cards drawn and pile to compare() method
        compare(player1DrawCard, player2DrawCard, pile);
        //numRounds--;
        pile.removeAll(pile);
    }
    
    /**
     * Deal 26 cards to each hand in alternating order
     * @param hand to deal cards to
     */
    private void dealHand(PlayerHand hand) {  
        for (int i = 0; i < hand.getSize(); i++) {
            hand.addCardToHand(deck.dealCard());
        }
    }
    
    /**
     * Declares winner when a player runs out of cards
     */
    @Override
    public void declareWinner() {
        if (winner == null)
            System.out.println("\nIt's a tie after " + (numRounds-1) + " rounds!");
        else 
            System.out.println("\n" + winner.getName() + " won this game after " + (numRounds-1) + " rounds!");
        
        System.out.println("\nScore Board:\nPlayer\t\tGames Won");
        System.out.println(player1.getName() + "\t\t" + numPlayer1Won);
        System.out.println(player2.getName() + "\t\t" + numPlayer2Won);
        
        System.out.print("\nPress enter to play again or enter anything to quit.\nPlay again? ");
        String playAgain = input.nextLine();

        if (!playAgain.equals("") || !playAgain.isEmpty()) {
            System.out.println("You quit the game.");
        } else {
            numGames++;
            startGame();
        }
    }
    
    /**
     * Prints number of cards in each player's hand after each round
     */
    private void handSizeUpdate() {
        System.out.println("\n" + player1.getName() + " has " + player1.getHand().getHandSize() + " cards in their hand.");
        System.out.println(player2.getName() + " has " + player2.getHand().getHandSize() + " cards in their hand.");
        for (int i = 0; i < 10; i++)
            System.out.print("----------");
    }
}