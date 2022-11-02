/**
* Board object for the connect four game.
*
* @author William Baker
* @version 10/25/22
*/

package core;

public class Board {

    final int WIDTH = 7;
    final int HEIGHT = 6;
    char[][] board;

    public Board(){
        board = new char[WIDTH][HEIGHT];
        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[x].length; y++){
                board[x][y] = ' ';
            }
        }
    }

    
    /** 
     * @param column the column the person wants to put their piece
     * @return boolean the column number
     */
    public boolean columnOpen(int column){
        for(int i = 0; i < HEIGHT; i++){
            if(board[column][i] == ' '){
                return true;
            }
        }
        return false;
    }

    
    /** 
     * @return int boards width
     */
    public int getBoardWidth(){
        return WIDTH;
    }

    
    /** 
     * @return int boards height
     */
    public int getBoardHeight(){
        return HEIGHT;
    }

    
    /** 
     * gets the game board
     * @return char[][]
     */
    public char[][] getBoard() {
        return board;
    }

}
