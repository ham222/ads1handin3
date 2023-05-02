import ads.handins.QueensSolver;
import org.junit.Test;
import org.junit.*;

import static org.junit.Assert.*;

public class Tests{

    QueensSolver queensSolver;

    @Before
    public void setUp() {
        queensSolver = new QueensSolver();
    }

    @Test
    public void testPutQueensSizeIsZero() {
        // Test case 1: Trivial solution for n = 1
        boolean[][] board1 = new boolean[1][1];
        assertThrows(IllegalArgumentException.class, () -> queensSolver.insertQueens(board1, 0, 1));
    }

    @Test
    public void testPutQueensSizeIsThree(){
        // Test case 2: Invalid input for n = 3
        boolean[][] board2 = new boolean[3][3];

        assertThrows(IllegalArgumentException.class,()->queensSolver.insertQueens(board2, 0, 3));
    }

    @Test
    public void testPutQueens() {
        // Test case 3: Non-trivial solution for n = 4
        boolean[][] board3 = new boolean[4][4];
        assertTrue(queensSolver.insertQueens(board3, 0, 4));
    }

    @Test
    public void testIsSafe() {
        boolean[][] board1 = new boolean[3][3];
        board1[0][0] = true;

        boolean result1 = queensSolver.isSafe(board1, 0, 1);
        assertFalse(result1);

        boolean result2 = queensSolver.isSafe(board1, 1, 1);
        assertFalse(result2);

        boolean result3 = queensSolver.isSafe(board1, 2, 0);
        assertFalse(result3);
    }

    @Test
    public void isAllFalseWhenInstantiated() {
        QueensSolver solver = new QueensSolver();
        var board = solver.createBoard(8);
        for(int i = 0; i<8; i++) {
            for(int j = 0; j<8; j++) {
                assertFalse(board[i][j]);
            }
        }
    }

    @Test
    public void testCreateBoard() {
        QueensSolver solver = new QueensSolver();
        boolean[][] board = solver.createBoard(4);
        assertEquals(4, board.length);
        assertEquals(4, board[0].length);
        for(int i = 0; i<4; i++) {
            for(int j = 0; j<4; j++) {
                assertFalse(board[i][j]);
            }
        }
    }

}
