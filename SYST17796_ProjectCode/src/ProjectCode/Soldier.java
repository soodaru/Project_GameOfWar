/**
 * SYST 17796 Project
 */
package ProjectCode;

import BaseCode.Player;
import java.util.Scanner;
/**
 *
 * @author Ayah, Arushi, Kate, and Ariel - April 2022
 */
public class Soldier extends Player {
    private Scanner input = new Scanner(System.in);
    
    /**
     * Constructor passes name parameter to parent constructor
     * @param name of player
     */
    public Soldier(String name) {
        super(name);
    }
    
    /**
     * Prompts user to press enter to draw a card
     * User can enter any string to quit instead
     */
    @Override
    public void play() {
        System.out.println("\n" + getName() + ", press enter to draw a card or enter anything to quit.");
        System.out.print("Draw? ");      
        String entry = input.nextLine();

        if (!entry.equals("") || !entry.isEmpty()) {
            System.out.println("You quit the game.");
            System.exit(0);
        }
    }
}
