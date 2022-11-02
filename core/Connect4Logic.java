/**
* All the game logic for the connect four game.
*
* @author William Baker
* @version 10/25/22
*/

package core;

public class Connect4Logic {
    int totalPieces = 0;

    public Connect4Logic() {
    }

    /**
     * Player makes a move
     *
     * @param player1Turn:  A boolean to indicate the players turn
     * @param columnChoice: A int to determine where to put the next piece
     * @param gameBoard:    A board object to use.
     */
    public void playerMove(boolean player1Turn, int columnChoice, Board gameBoard) {
        char piece;
        if (player1Turn) {
            piece = 'X';
        } else {
            piece = 'O';
        }

        addPiece(piece, columnChoice, gameBoard);
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

    /**
     * Checks if player won
     *
     * @param player1turn: A boolean to indicate the players turn
     * @param gameBoard:   A board to check.
     * @return if they won or not
     */
    public boolean checkWin(Boolean player1turn, Board gameBoard) {

        char player;
        if (player1turn) {
            player = 'X';
        } else {
            player = 'O';
        }

        if (horizontalCheck(player, gameBoard)) {
            return true;
        }

        if (verticalCheck(player, gameBoard)) {
            return true;
        }

        if (leftToRightDiag(player, gameBoard)) {
            return true;
        }

        if (rightToLeftDiag(player, gameBoard)) {
            return true;
        }

        return false;
    }

    /**
     * Checks if players tie
     *
     * @return if they tied or not
     */
    public boolean checkTie() {
        return totalPieces == 42;
    }

    /**
     * Checks if player has four in a row horizontally
     *
     * @param player:    A char to indicate the player.
     * @param gameBoard: A board object to add the piece to.
     * @return if they won or not
     */
    public boolean horizontalCheck(char player, Board gameBoard) {
        int winTracker = 4;

        for(int y = 0; y < gameBoard.HEIGHT; y++){
            for (int x = 0; x < gameBoard.WIDTH; x++) {
                if (gameBoard.getBoard()[x][y] == player) {
                    winTracker--;
                    if (win(winTracker)) {
                        return true;
                    }
                } else {
                    winTracker = 4;
                }
            }
            winTracker = 4;
        }
        return false;
    }

    /**
     * Checks if player has four in a row vertically
     *
     * @param player:    A char to indicate the player.
     * @param gameBoard: A board object to add the piece to.
     * @return if they won or not
     */
    public boolean verticalCheck(char player, Board gameBoard) {
        int winTracker = 4;

        for(int x = 0; x < gameBoard.WIDTH; x++){
            for (int y = 0; y < gameBoard.HEIGHT; y++) {
                if (gameBoard.getBoard()[x][y] == player) {
                    winTracker--;
                    if (win(winTracker)) {
                        return true;
                    }
                } else {
                    winTracker = 4;
                }
            }

            winTracker = 4;
        }

        return false;
    }

    /**
     * Checks if player has four in a row diagonally left to right
     *
     * @param player:    A char to indicate the player.
     * @param gameBoard: A board object to add the piece to.
     * @return if they won or not
     */
    public boolean leftToRightDiag(char player, Board gameBoard) {
        int winTracker = 4;

        for (int column = 0; column < gameBoard.WIDTH - 3; column++) {
            int x, y;
            for (x = column, y = 0; x < gameBoard.WIDTH && y < gameBoard.HEIGHT; x++, y++) {
                if (gameBoard.board[x][y] == player) {
                    winTracker--;
                    if (win(winTracker)) {
                        return true;
                    }
                } else {
                    winTracker = 4;
                }
            }
        }

        winTracker = 4;

        for (int row = 1; row < gameBoard.HEIGHT - 3; row++) {
            int x, y;
            for (x = 0, y = row; x < gameBoard.WIDTH && y < gameBoard.HEIGHT; x++, y++) {
                if (gameBoard.board[x][y] == player) {
                    winTracker--;
                    if (win(winTracker)) {
                        return true;
                    }
                } else {
                    winTracker = 4;
                }
            }
        }

        return false;
    }

    /**
     * Checks if player has four in a row diagonally right to left
     *
     * @param player:    A char to indicate the player.
     * @param gameBoard: A board object to add the piece to.
     * @return if they won or not
     */
    public boolean rightToLeftDiag(char player, Board gameBoard) {
        int winTracker = 4;

        for (int column = gameBoard.WIDTH - 1; column > 2; column--) {
            int x, y;
            for (x = column, y = 0; x >= 0 && y < gameBoard.HEIGHT; x--, y++) {
                if (gameBoard.board[x][y] == player) {
                    winTracker--;
                    if (win(winTracker)) {
                        return true;
                    }
                } else {
                    winTracker = 4;
                }
            }
        }

        winTracker = 4;

        for (int row = 1; row < gameBoard.HEIGHT - 3; row++) {
            int x, y;
            for (x = gameBoard.WIDTH - 1, y = row; x >= 0 && y < gameBoard.HEIGHT; x--, y++) {
                if (gameBoard.board[x][y] == player) {
                    winTracker--;
                    if (win(winTracker)) {
                        return true;
                    }
                } else {
                    winTracker = 4;
                }
            }
        }

        return false;
    }

    /**
     * Helper method to check if they have four in a row or not.
     * @param tracker int of current pieces in a row
     * @return boolean of if they won or not
     */
    public boolean win(int tracker) {
        return tracker <= 0;
    }

}