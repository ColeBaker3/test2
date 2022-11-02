/**
* All the ui for the connect four game
*
* @author William Baker
* @version 10/25/22
*/

package ui;
import core.Board;
import java.util.Scanner;

public class Connect4TextConsole {

    public Connect4TextConsole(){}

    Scanner scanner = new Scanner(System.in);

    /**
    * Asks for user input and checks if its valid
    *
    * @param  player1turn: A boolean to indicate the players turn.
    * @param  gameBoard: A board object to use.
    * @return int to column they selected
    */
    public int getColumn(boolean player1turn, Board gameBoard){
        int col = 0;
        char piece;
        if(player1turn){
            piece = 'X';
        } else{
            piece = 'O';
        }
        System.out.println("Player " + piece + " - your turn. Choose a number from 1-7.");
        boolean validChoice = false;
        while(!validChoice){
            try{
                col = scanner.nextInt();
                if(col < 1 || col > 7){
                    System.out.println("Please enter a valid number 1-7: ");
                }
                else if(!gameBoard.columnOpen(col - 1)){
                    System.out.println("Column is full. Choose another: ");
                }
                else{
                    validChoice = true;
                }
            } catch (Exception e){
                System.out.println("Please enter a valid Integer.");
                scanner.nextLine();
            }
        }

        return col - 1;
    }

    /**
    * Prints the current board
    *
    * @param  gameBoard: A board object to print.
    */
    public void printBoard(Board gameBoard){
        for(int y = 0; y < gameBoard.getBoardHeight(); y++){
            for(int x = 0; x < gameBoard.getBoardWidth(); x++){
                System.out.print("|");
                System.out.print(gameBoard.getBoard()[x][y]);
            }
            System.out.print("|\n");
            
        }
    }

    public void printComputerMove(){
        System.out.println("Computer's move.");
    }

    /**
    * Prints of the winner or if its a tie.
    *
    * @param  player: A boolean to indicate the player that won.
    * @param  tie: A boolean to indicate if they tied.
    */
    public void printWinner(boolean player, boolean tie){

        if(tie){
            System.out.println("Game is a tie!");
        }else{
            if(player){
                System.out.println("Player O Won the Game!");
            }
            else{
                System.out.println("Player X Won the Game!");
            }
         }

    }

    /**
    * Gets type of game being played
    * @return boolean of the game type - Computer = false; Player = true;
    */
    public boolean getGameType(){
        String playerType;
        boolean validChoice = false;

        while(!validChoice){
            try{
                playerType = scanner.next();
                if(playerType.equals("C")){
                    return false;
                }
                else if(playerType.equals("P")){
                    return true;
                }
                else{
                    System.out.println("Please enter a valid choice. P - Player; C - Computer.");
                }
            } catch(Exception e){
                System.out.println("Not a valid entry.");
            }
        }

        return false;
    }


}
