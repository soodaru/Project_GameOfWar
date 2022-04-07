/**
 * SYST 17796 Project
 */
package ProjectCode;

import BaseCode.Player;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Ayah, Arushi, Kate, and Ariel
 */
public class MainPlayMode {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            War game = new War("War");
            ArrayList<Player> playerList = new ArrayList();
            String player1Name, player2Name;
            int opponent;

            // Gives user choice of opponent
            System.out.println("Welcome to War!\n\nChoose your opponent:");
            System.out.println("1) Play aginst PC\n2) Play aginst another player");

            // Prompts user for correct entry until 1 or 2 is entered
            do {
                System.out.print("Opponent: ");
                opponent = input.nextInt();
                input.nextLine();

                if (opponent != 1 && opponent != 2) {
                    System.out.println("\nInvalid entry. Please select 1 or 2.");
                }
            } while (opponent != 1 && opponent != 2);

            // Prompts player 1 for their name
            do {
                System.out.print("\nPlayer 1, please enter your name: ");
                player1Name = input.nextLine();
            } while (player1Name.length() == 0);
            
            Soldier player1 = new Soldier(player1Name);
            playerList.add(player1);

            // Prompts player 2 for their name if opponent is another person
            if (opponent == 2) {
                do {
                    System.out.print("\nPlayer 2, please enter your name: ");
                    player2Name = input.nextLine();
                } while (player2Name.length() == 0);

                Soldier player2 = new Soldier(player2Name);
                playerList.add(player2);    
            } else {
                RobotSoldier player2 = new RobotSoldier("PC");
                playerList.add(player2);
            }
            
            // Sets player and starts game
            game.setPlayers(playerList);
            game.startGame();
        } catch (InputMismatchException e) {
            System.err.println("InputMismatchException: Must enter an integer to select an opponent.");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}