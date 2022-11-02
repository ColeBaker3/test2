/**
* Main game loop for the connect four game.
*
* @author William Baker
* @version 10/25/22
*/

import core.*;
import ui.*;

/**
 *
 * Main
 */
public class Main {
    // Global variables
    boolean isPlaying = true;
    boolean player1turn = true;
    boolean tie = false;
    int columnChoice;

    Board gameBoard = new Board();
    Connect4Logic gamelogic = new Connect4Logic();
    Connect4ComputerPlayer computerPlayer = new Connect4ComputerPlayer();
    Connect4TextConsole gameText = new Connect4TextConsole();
    
    
    /** main function starts game
     * @param args
     */
    public static void main(String[] args) {
        
        Main Game = new Main();
        boolean gameType = Game.getGameType();  // Computer is false, Player is true;

        if(gameType){
            Game.gameVsHuman();
        }
        else{
            Game.gameVsComputer();
        }

        Game.printResult();
    }

    /**
     * If true than starts a game vs human - false for computer
     * @return boolean to decide which game to start
     */
    public boolean getGameType(){
        System.out.println("Begin Game.\n Enter 'P' if you want to play against another player; Enter 'C' to play against computer.");
        boolean player = gameText.getGameType();
        return player;
    }

    /**
     * starts a game vs the computer
     */
    public void gameVsComputer(){
        while(isPlaying){
            gameText.printBoard(gameBoard);
            if(player1turn){
                columnChoice = gameText.getColumn(player1turn, gameBoard);
                gamelogic.playerMove(player1turn, columnChoice, gameBoard);
            }
            else{
                gameText.printComputerMove();
                computerPlayer.aiMove(gameBoard);
            }

            if(gamelogic.checkWin(player1turn, gameBoard)){
                isPlaying = false;
            }
            else if(computerPlayer.checkTie()){
                isPlaying = false;
                tie = true;
            }

            if(player1turn){
                player1turn = false;
            }else{
                player1turn = true;
            }
        }
    }

    /**
     * starts a game vs another human
     */
    public void gameVsHuman(){
        while(isPlaying){
            gameText.printBoard(gameBoard);
            columnChoice = gameText.getColumn(player1turn, gameBoard);
            gamelogic.playerMove(player1turn, columnChoice, gameBoard);
            if(gamelogic.checkWin(player1turn, gameBoard)){
                isPlaying = false;
            }
            else if(gamelogic.checkTie()){
                isPlaying = false;
                tie = true;
            }

            if(player1turn){
               player1turn = false;
            }else{
             player1turn = true;
            }

        }
    }

    /**
     * prints the winner or tie
     */
    public void printResult(){
        gameText.printBoard(gameBoard);
        gameText.printWinner(player1turn, tie);
    }
}
