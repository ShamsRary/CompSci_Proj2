import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //main menu
        boolean gamePlaying = true;
        while (gamePlaying) {
            System.out.println("Pick a choice.");
            System.out.println("1 = Play Sudoku.");
            System.out.println("2 = Rules of Sudoku.");
            System.out.println("3 = Sudoku solver.");
            System.out.println("4 = Print existing boards.");
            System.out.println("5 = Create and solve new Board.");
            System.out.print("9 = End game simulation.\n");
            int choice = scan.nextInt();

            if (choice == 9) {
                //exits game
                gamePlaying = false;
                String end = "Thanks for playing" + (int) (Math.random() * 100);
                System.out.println(end);


            } else if (choice == 1) {
                //plays sudoku
                System.out.println("\nLets play Sudoku.\n");
                System.out.println("Pick a level of difficulty 1, 2, or 3\n");

                //set board
                int level = scan.nextInt();
                Sudoku game = new Sudoku(level);
                System.out.println(game);

                boolean playing = true;
                while (playing) {

                    game.printCopy();
                    System.out.println("To exit type 999 for any parameter.");
                    System.out.println("Type in the row of where you would like to add the number 0-8");
                    int row = scan.nextInt();
                    System.out.println("Type in the collum of where you would like to add the number 0-8");
                    int collum = scan.nextInt();
                    System.out.println("Type a number 1-9");
                    int number = scan.nextInt();
                    if (row == 999 || collum == 999 || number == 999) {
                        playing = false;

                    }else if(!(row < 9 && row >= 0 && collum < 9 && collum >= 0 && number > 0 && number <=9)){
                        System.out.println("Wrong inputs. Try again.");
                    } else {
                        game.playGame(row, collum, number);
                    }
                }

            } else if (choice == 2) {
                System.out.println("\nRule 1 - Each row must contain the numbers from 1 to 9, without repetitions.");
                System.out.println("Rule 2 - Each column must contain the numbers from 1 to 9, without repetitions.");
                System.out.println("Rule 3 - The digits can only occur once per block.");
                System.out.println("Rule 4 - The sum of every single row, column and box must equal 45.\n");

            } else if (choice == 3) {
                //sets board and then solves
                System.out.print("Type a number to select a board\n");
                int level = scan.nextInt();
                Sudoku game1 = new Sudoku(level);
                game1.print();
                int[][] board = game1.boardCreator();
                game1.solve(board);
                System.out.println("\nThe board solved is.\n");
                game1.print();
                System.out.println();

            } else if (choice == 4) {
                //prints all boards
                Sudoku board1 = new Sudoku(1);
                Sudoku board2 = new Sudoku(2);
                Sudoku board3 = new Sudoku(3);

                System.out.println("Board 1 is");
                board1.print();

                System.out.println("Board 2 is");
                board2.print();

                System.out.println("Board 3 is");
                board3.print();

            } else if (choice == 5) {
                System.out.println("Type in your board");
                int[][] board = {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0}
                };

                Sudoku createdGame = new Sudoku(board);
                boolean creating = true;
                while (creating) {
                    //sets board and applies the rules of sudoku

                    createdGame.printCopy();
                    createdGame.remake();

                    System.out.println("To exit type 999 for any parameter.");

                    System.out.println("Type in the row of where you would like to add the number 0-8");
                    int row = scan.nextInt();

                    System.out.println("Type in the collum of where you would like to add the number 0-8");
                    int collum = scan.nextInt();

                    System.out.println("Type a number 1-9");
                    int number = scan.nextInt();

                    if (row == 999 || collum == 999 || number == 999) {
                        creating = false;

                    //}else if(row < 9 && row > 0 && collum ){


                    } else {
                        createdGame.playGame(row, collum, number);
                    }

                }
                //solves board that was created if there is a possible solution
                System.out.println();
                int[][] newBoard = createdGame.remake();
                createdGame.solve(newBoard);
                createdGame.printCopy();

                }else{
                    System.out.println("\nError Wrong Input try again.\n");
            }
        }
    }
}