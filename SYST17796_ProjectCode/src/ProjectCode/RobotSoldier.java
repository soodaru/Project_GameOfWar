/**
 * SYST 17796 Project
 */
package ProjectCode;

import BaseCode.Player;
/**
 *
 * @author Ayah, Arushi, Kate, and Ariel
 */
public class RobotSoldier extends Player {
    
    /**
     * Constructor passes name parameter to parent constructor
     */
    public RobotSoldier(String name) {
        super(name);
    }
    
    /**
     * Method is empty as RobotSoldier models PC as player
     * PC does not need to be prompted to draw a card
     */
    @Override
    public void play() {}
}
