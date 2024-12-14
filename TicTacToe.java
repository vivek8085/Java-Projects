package Level2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        boolean playAgain;

        do {
            initializeBoard(board);
            char currentPlayer = 'X';
            boolean gameWon = false;

            while (true) {
                displayBoard(board);
                System.out.println("Player " + currentPlayer + ", enter your move (row and column): ");
                
                int row = -1, col = -1;
                boolean validInput = false;

                // Input validation for row and column
                while (!validInput) {
                    try {
                        row = scanner.nextInt() - 1;
                        col = scanner.nextInt() - 1;
                        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                            validInput = true;
                        } else {
                            System.out.println("Invalid move. Try again.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter valid integers for row and column.");
                        scanner.next(); // Clear the invalid input
                    }
                }

                board[row][col] = currentPlayer;

                if (checkWinner(board, currentPlayer)) {
                    displayBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameWon = true;
                    break;
                }

                if (isBoardFull(board)) {
                    displayBoard(board);
                    System.out.println("It's a draw!");
                    break;
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }

            System.out.print("Play again? (true/false): ");
            playAgain = scanner.nextBoolean();
        } while (playAgain);

        scanner.close();
    }

    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    private static void displayBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-----");
        }
    }

    private static boolean checkWinner(char[][] board, char player) {
        for (int i = 0; i < 3; i++)
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player)
                return true;

        for (int j = 0; j < 3; j++)
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player)
                return true;

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return true;

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return true;

        return false;
    }

    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }
}