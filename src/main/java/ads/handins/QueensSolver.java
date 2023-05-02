package ads.handins;

import java.util.Arrays;

public class QueensSolver{

    /**
     * This method solves the nQueens problem.
     *
     * @param size int
     * @return arr of booleans with places containing queens set to true and empty spaces containing false
     */
    public boolean[][] createBoard(int size) {
        boolean[][] board = new boolean[size][size];

        //@TODO delete – redundant code, boolean is already initialized as false
        for(int i = 0; i<size; i++) {
            Arrays.fill(board[i], false);
        }

        return board;
    }

    public boolean insertQueens(boolean[][] board, int col, int n) {
        if(n == 1) {
            throw new IllegalArgumentException("Trival solution");
        }
        if(n<4) {
            throw new IllegalArgumentException("Solutions only for n > 3");
        }
        if(col == n)
        {
            return true;
        }
        for(int row = 0; row<n; row++) {
            if(isSafe(board, row, col)) {
                board[row][col] = true;
                if(insertQueens(board, col+1, n)) {
                    return true;
                }
                board[row][col] = false;
            }
        }
        return false;
    }

    /**
     * This method takes in a given state of a board and two coordinates, X and Y, and determines if it is legal to put
     * the queen there.
     *
     * @param board square array of booleans
     * @param x     x coordinate of where one wants to put the queen
     * @param y
     * @return
     */
    public static boolean isSafe(boolean[][] board, int x, int y) {
        //Input validation
        if(x<0 || y<0 || board.length != board[0].length) {
            throw new IllegalArgumentException();
        }
        //Horizontal checks
        for(int i = 0; i<board[0].length; i++) {
            if(board[x][i]) {
                return false;
            }
        }
        //Vertical checks
        for(int i = 0; i<board[0].length; i++) {
            if(board[i][y]) {
                return false;
            }
        }
        //Left-up diagonal check
        int xIndex = x;
        int yIndex = y;
        while(xIndex>=0 && yIndex>=0) {
            if(board[xIndex][yIndex]) {
                return false;
            }
            xIndex--;
            yIndex--;
        }

        //Left-down diagonal check
        xIndex = x;
        yIndex = y;
        while(xIndex<board.length && yIndex>=0) {
            if(board[xIndex][yIndex]) {
                return false;
            }
            xIndex++;
            yIndex--;
        }

        //Right-up diagonal check
        xIndex = x;
        yIndex = y;
        while(xIndex>=0 && yIndex<board.length) {
            if(board[xIndex][yIndex]) {
                return false;
            }
            xIndex--;
            yIndex++;
        }

        //Right-down diagonal check
        xIndex = x;
        yIndex = y;
        while(xIndex<board.length && yIndex<board[0].length) {
            if(board[xIndex][yIndex]) {
                return false;
            }
            xIndex++;
            yIndex++;
        }

        return true;
    }

    //Utility method – tests not required
    public void printBoard(boolean[][] board) {
        String occ = "";
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board.length; j++) {
                if(board[i][j]){
                    occ="Q";
                } else {
                    occ = "X";
                }
                System.out.print(occ + " ");
            }
            System.out.println();
        }
    }
}
