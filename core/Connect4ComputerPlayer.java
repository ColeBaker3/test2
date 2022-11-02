package core;

import java.util.Random;

public class Connect4ComputerPlayer {

    public Connect4ComputerPlayer() {};
    
    int totalPieces = 0;
    Random random = new Random();

    /**
     * Ai makes moves at random
     *
     * @param gameBoard:    A board object to use.
     */
    public void aiMove(Board gameBoard) {
        char piece = 'O';
        int columnChoice;
        boolean validMove = false;

        while(!validMove){
            columnChoice = random.nextInt(0,6);
            validMove = addPiece(piece, columnChoice, gameBoard);
        }
    }

    /**
     * Adds piece to the board
     *
     * @param piece:     A char to indicate what piece.
     * @param column:    A int to determine where to put the next piece.
     * @param gameBoard: A board object to add the piece to.
     * @return if the piece was added
     */
    public boolean addPiece(char piece, int column, Board gameBoard) {
        for (int i = gameBoard.HEIGHT - 1; i >= 0; i--) {
            if (gameBoard.getBoard()[column][i] == ' ') {
                gameBoard.getBoard()[column][i] = piece;
                totalPieces++;
                return true;
            }
        }
        return false;
    }

    public boolean checkTie(){
        return totalPieces >= 21;
    }

    public boolean checkIfCanWin(Board gameBoard){

        return false;
    }

}
