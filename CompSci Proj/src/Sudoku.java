public class Sudoku {
    private int level;

    private int[][] board;//9 row and 9 column;

    private int [][] copyBoard;

    public Sudoku(int [][] board) {
        this.board = board;
        this.copyBoard = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            this.copyBoard[i] = board[i].clone();
        }
    }

    public int[][] remake(){
        this.board = new int[copyBoard.length][];
        for (int i = 0; i < copyBoard.length; i++) {
            this.board[i] = copyBoard[i].clone();
        }

        return copyBoard;
    }

    public Sudoku(int level) {
        this.level = level;
        this.board = boardCreator();

        this.copyBoard = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            this.copyBoard[i] = board[i].clone();
        }


        }

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

    public void printCopy() {
        for (int[] row : copyBoard) {
            for (int collum : row) {
                System.out.print(collum + " | ");
            }
            System.out.println();
        }
    }

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




    public boolean inRow(int[][] board, int number, int row){
        for (int row1 = 0; row1 < 9; row1++) {
            if (board[row][row1] == number) {
                return true;
            }
        }
        return false;
    }

    public boolean inCollum(int[][] board, int number, int collum) {
        for (int collum1 = 0; collum1 < 9; collum1++) {
            if (board[collum1][collum] == number) {
                return true;
            }
        }
        return false;
    }

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

    public boolean check(int[][] board, int number, int row, int collum) {
        return !inBox(board, number, row, collum) && !inCollum(board, number, collum) && !inRow(board, number, row);
    }

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





