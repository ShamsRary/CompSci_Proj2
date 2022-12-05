/*
Sudoku is a game with a board that must be solved.
 */
public class Sudoku {
    //level is used to select the premade boards
    private int level;
    //Sudoku board
    private int[][] board;//9 row and 9 column;
    //Copy of Sudoku board and is used to solve
    private int [][] copyBoard;


    /*
    Constructor represents a board that is being set/created and the copy board is a copy of board
    that does not directly refer to it.
     */
    public Sudoku(int [][] board) {
        this.board = board;
        this.copyBoard = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            this.copyBoard[i] = board[i].clone();
        }
    }


    /*
    sets the board to copy board without directly referring to it.
     */
    public int[][] remake(){
        this.board = new int[copyBoard.length][];
        for (int i = 0; i < copyBoard.length; i++) {
            this.board[i] = copyBoard[i].clone();
        }

        return copyBoard;
    }


    /*
    Constructor represents a board that is being set from a premade copy. The copy is dettermind
    by level and the copy board is a copy of board that does not directly refer to it.
     */
    public Sudoku(int level) {
        this.level = level;
        this.board = boardCreator();
        this.copyBoard = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            this.copyBoard[i] = board[i].clone();
        }
        }

    /*
    Sets the board to a premade one based on the level of difficulty the user choose.
     */
    public int[][] boardCreator() {
        if (level == 1) {
            board = new int[][]{
                    {8, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 3, 6, 0, 0, 0, 0, 0},
                    {0, 7, 0, 0, 9, 0, 2, 0, 0},
                    {0, 5, 0, 0, 0, 7, 0, 0, 0},
                    {0, 0, 0, 0, 4, 5, 7, 0, 0},
                    {0, 0, 0, 1, 0, 0, 0, 3, 0},
                    {0, 0, 1, 0, 0, 0, 0, 6, 8},
                    {0, 0, 8, 5, 0, 0, 0, 1, 0},
                    {0, 9, 0, 0, 0, 0, 4, 0, 0}
            };
        } else if (level == 2) {
            board = new int[][]{
                    {0, 0, 0, 8, 0, 1, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 4, 3},
                    {5, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 7, 0, 8, 0, 0},
                    {0, 0, 0, 0, 0, 0, 1, 0, 0},
                    {0, 2, 0, 0, 3, 0, 0, 0, 0},
                    {6, 0, 0, 0, 0, 0, 0, 7, 5},
                    {0, 0, 3, 4, 0, 0, 0, 0, 0},
                    {0, 0, 0, 2, 0, 0, 6, 0, 0},

            };

            }else if(level == 3){
            board = new int[][]{
                    {7, 0, 2, 0, 5, 0, 6, 0, 0},
                    {0, 0, 0, 0, 0, 3, 0, 0, 0},
                    {1, 0, 0, 0, 0, 9, 5, 0, 0},
                    {8, 0, 0, 0, 0, 0, 0, 9, 0},
                    {0, 4, 3, 0, 0, 0, 7, 5, 0},
                    {0, 9, 0, 0, 0, 0, 0, 0, 8},
                    {0, 0, 9, 7, 0, 0, 0, 0, 5},
                    {0, 0, 0, 2, 0, 0, 0, 0, 0},
                    {0, 0, 7, 0, 4, 0, 2, 0, 3}
            };

            }else {
            board = new int[][]{
                    {8, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 3, 6, 0, 0, 0, 0, 0},
                    {0, 7, 0, 0, 9, 0, 2, 0, 0},
                    {0, 5, 0, 0, 0, 7, 0, 0, 0},
                    {0, 0, 0, 0, 4, 5, 7, 0, 0},
                    {0, 0, 0, 1, 0, 0, 0, 3, 0},
                    {0, 0, 1, 0, 0, 0, 0, 6, 8},
                    {0, 0, 8, 5, 0, 0, 0, 1, 0},
                    {0, 9, 0, 0, 0, 0, 4, 0, 0}
            };
        }
        return board;
    }


    /*
    Plays the game by making sure that the users inputs follows the rules of sudoku
     */
    public int[][] playGame(int row, int collum, int number){
        if(check(board, number, row, collum) && board[row][collum] == 0){
            copyBoard[row][collum] = number;
            winCheck();
            return copyBoard;
        }else{

            System.out.println("You cant place this number here due to the rules of sudoku.");
            winCheck();
            return copyBoard;
        }
    }


    /*
    Checks to see if the user has beaten the sudoku board by seeing if there are any
    0s in the Copyboard.
     */
    public void winCheck(){
        int counter = 0;
        for (int row1 = 0; row1 < 9; row1++) {
            for (int collum1 = 0; collum1 < 9; collum1++) {
                if(copyBoard[row1][collum1] == 0){
                    counter ++;
                }
            }
        }
        if(counter == 0){
            System.out.println("You win type 999 into any parameter to exit!!!");
            System.out.println("You win type 999 into any parameter to exit!!!");
            System.out.println("You win type 999 into any parameter to exit!!!");

        }
    }


//    public void print() {
//        for (int row = 0; row < 9; row++) {
//            for (int collum = 0; collum < 9; collum++) {
//                System.out.print(board[row][collum] + " | ");
//            }
//            System.out.println();
//        }
//    }

    /*
    Seth gave advice to use enhanced loops to pint out the copy board and the board
     */
    public void printCopy() {
        for (int[] row : copyBoard) {
            for (int collum : row) {
                System.out.print(collum + " | ");
            }
            System.out.println();
        }
    }

    /*
    Seth gave advice to use enhanced loops to pint out the copy board and the board
     */
    public void print() {
        for (int[] row : board) {
            for (int collum : row) {
                System.out.print(collum + " | ");
            }
            System.out.println();
        }
    }

    public String toString(){//overriding the toString() method
        return level+" "+board+" "+copyBoard;
    }

    /*
    looks through the 2d list and checks for a number in that row.
     */
    public boolean inRow(int[][] board, int number, int row){
        for (int row1 = 0; row1 < 9; row1++) {
            if (board[row][row1] == number) {
                return true;
            }
        }
        return false;
    }

    /*
        looks through the 2d list and checks for a number in that collum.
     */
    public boolean inCollum(int[][] board, int number, int collum) {
        for (int collum1 = 0; collum1 < 9; collum1++) {
            if (board[collum1][collum] == number) {
                return true;
            }
        }
        return false;
    }


    /*
        looks through the 2d list and checks for a number in that box.
     */
    public boolean inBox(int[][] board, int number, int row, int collum) {
        int boxRow = row - row % 3;
        int boxCollum = collum - collum % 3;
        for (int r = boxRow; r < boxRow + 3; r++) {
            for (int c = boxCollum; c < boxCollum + 3; c++) {
                if (board[r][c] == number) {
                    return true;
                }
            }
        }
        return false;
    }


    /*
    Uses the previous 3 functions to see if a number is a valid placement for
    the sudoku. However, just because a number is a valid placement does not
    mean it is the correct placement.
     */
    public boolean check(int[][] board, int number, int row, int collum) {
        return !inBox(board, number, row, collum) && !inCollum(board, number, collum) && !inRow(board, number, row);
    }

    /*
    solves the board by going through each row and column and by trying in numbers that
    are valid fo placement. Then goes to the next 0 anc checks for valid placement
    if none then it will set that previous valid placement to another number and so on
    by using recursion. Program continues until board is solved.
     */
    public boolean solve(int[][] board) {
        for(int row = 0; row < 9; row ++){
            for(int collum = 0; collum < 9; collum ++){
                if (board[row][collum] == 0){
                    for(int num1_9 = 1;  num1_9 <= 9; num1_9 ++){
                        if(check(board, num1_9, row, collum)) {
                            board[row][collum] = num1_9;
                            if(solve(board)){
                                return true;
                            }else{
                                board[row][collum] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }



}





