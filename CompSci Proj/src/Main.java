import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        boolean gamePlaying = true;
        while(gamePlaying){
            System.out.println("Pick a choice.");
            System.out.println("1 = Play Sudoku.");
            System.out.println("2 = Rules of Sudoku.");
            System.out.println("3 = Sudoku solver.");
            System.out.println("4 = Make Board.");
            System.out.println("5 = Print exsiting boards.");
            System.out.println("9 = End game simulation.\n");
            int choice = scan.nextInt();
            if (choice == 9) {
                gamePlaying = false;
            }else if(choice == 1){
                System.out.println("\nLets play Sudoku.\n");
                System.out.println("Needs to be added properly.");

//                //Sudoku game1 = new Sudoku(2, board);
//                Sudoku game1 = new Sudoku(2);
//                //System.out.println(game1.boardCreator());
//                game1.print();
//                System.out.println("fjkfh");
//                int [][] board = game1.boardCreator();
//                game1.solve(board);
//                game1.print();
//                System.out.println("fjkfhss");

            }else if(choice == 2){
                System.out.println("\nRule 1 - Each row must contain the numbers from 1 to 9, without repetitions.");
                System.out.println("Rule 2 - Each column must contain the numbers from 1 to 9, without repetitions.");
                System.out.println("Rule 3 - The digits can only occur once per block.");
                System.out.println("Rule 4 - The sum of every single row, column and nonet must equal 45.\n");
            }else if(choice == 3){
                System.out.println("Type a number to select a board");
                int level = scan.nextInt();
                Sudoku game1 = new Sudoku(level);

                game1.print();
                int [][] board = game1.boardCreator();
                game1.solve(board);
                System.out.println("The board solved is.");
                game1.print();

            }else if(choice == 4){
                System.out.println("Needs to be added properly.");

            }else if(choice == 5){
                Sudoku board1 = new Sudoku(1);
                Sudoku board2 = new Sudoku(2);
                Sudoku board3 = new Sudoku(3);
                Sudoku board4 = new Sudoku(999);

                System.out.println("Board 1 is");
                board1.print();
                System.out.println("Board 2 is");
                board2.print();
                System.out.println("Board 3 is");
                board3.print();
                System.out.println("Board 4 is");
                board4.print();
            }else{
                System.out.println("\nError Wrong Input try again.\n");
            }
        }
        System.out.println("Thanks for playing.");
    }
}