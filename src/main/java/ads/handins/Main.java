package ads.handins;

public class Main{
    public static void main(String[] args) {
        QueensSolver board = new QueensSolver();
        int n = 10;
        boolean[][] gameBoard = board.createBoard(n);
        board.insertQueens(gameBoard, 0, n);
        board.printBoard(gameBoard);
    }
}