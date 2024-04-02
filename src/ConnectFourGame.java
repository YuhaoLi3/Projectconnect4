import java.util.Scanner;
import java.util.ArrayList;

public class ConnectFourGame {
        private ArrayList<String> choices = new ArrayList<>();
        public void start() {
            Board board = new Board(6, 7);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Player 1, choose your piece symbol: ");
            String player1Symbol = scanner.nextLine();
            GamePiece player1Piece = new Players(player1Symbol);

            System.out.println("Player 2, choose your piece symbol: ");
            String player2Symbol = scanner.nextLine();
            GamePiece player2Piece = new Players(player2Symbol);

            boolean player1Turn = true;
            while (true) {
                board.printBoard();
                if (player1Turn) {
                    System.out.println("Player 1, choose a column (0-6): ");
                } else {
                    System.out.println("Player 2, choose a column (0-6): ");
                }
                int column = scanner.nextInt();
                if (column < 0 || column > 6) {
                    System.out.println("Invalid column. Please choose a column between 0 and 6.");
                    continue;
                }
                boolean placed;
                if (player1Turn) {
                    placed = board.placePiece(column, player1Piece);
                } else {
                    placed = board.placePiece(column, player2Piece);
                }

                if (!placed) {
                    System.out.println("Column full. Try again.");
                    continue;
                }

                // i will add win condition here. it takes alot of thinking.

                player1Turn = !player1Turn;
            }
    }



}
