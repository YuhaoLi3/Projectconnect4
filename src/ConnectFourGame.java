import java.util.*;
import java.util.Scanner;
public class ConnectFourGame {
    private static SymbolManager symbolManager = new SymbolManager();
    private int placementCounter = 0;
    public void start() {
        Board board = new Board(6, 7);
        Scanner scanner = new Scanner(System.in);
        symbolManager.displayAvailableSymbols();
        GamePiece player1Piece = new Players(chooseSymbol(scanner, "Player 1"));
        symbolManager.displayAvailableSymbols();
        GamePiece player2Piece = new Players(chooseSymbol(scanner, "Player 2"));
        boolean player1Turn = true;
        boolean isGameOver = false;
        boolean player1HasSpecial = false;
        boolean player2HasSpecial = false;
        Random random = new Random();
        while (!isGameOver) {
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
            GamePiece currentPlayerPiece;
            if (player1Turn) {
                currentPlayerPiece = player1Piece;
            } else {
                currentPlayerPiece = player2Piece;
            }
            if ((player1Turn && player1HasSpecial) || (!player1Turn && player2HasSpecial)) {
                System.out.println("You have a Special Game Piece. Do you want to use it? (yes/no)");
                String response = scanner.next();
                if (response.equalsIgnoreCase("yes")) {
                    currentPlayerPiece = new SpecialGamePiece(currentPlayerPiece.getSymbol()); // Assuming getSymbol() gives the player's symbol
                    GamePiece specialSymbol = currentPlayerPiece;
                    if (player1Turn) {
                        player1HasSpecial = false;
                    } else {
                        player2HasSpecial = false;
                    }
                }
            }

            boolean placed = board.placePiece(column, currentPlayerPiece);
            if (!placed) {
                System.out.println("Column full. Try again.");
                continue;
            }

            placementCounter++;
            // Offer SpecialGamePiece after 5 placements
            if (placementCounter == 5) {
                if (random.nextBoolean()) {
                    player1HasSpecial = true;
                    System.out.println("Player 1 has received a Special Game Piece!");
                } else {
                    player2HasSpecial = true;
                    System.out.println("Player 2 has received a Special Game Piece!");
                }
            }
            if (board.checkWin(currentPlayerPiece)) {
                board.printBoard();
                if (player1Turn) {
                    System.out.println("Player 1 wins!");
                    System.out.println("       /\\\n" +
                            "         /  \\          ___/  \\\n" +
                            "        /    \\________/       \\\n" +
                            "       /      ^    ^      \\     /\\\n" +
                            "~~~~~~\\    (o)      (o)    /~~~~~~\n" +
                            "~~~~~~/ \\     vvvvvvvv     / \\~~~~~~\n" +
                            "      /   \\_____________/   \\\n" +
                            "     /\\   / \\   ||||   / \\   /\\/\\\n" +
                            "    /  \\_/   \\__||||__/   \\_/  \\\n" +
                            "   /     \\_____[||]_____/     \\\n" +
                            "  /       \\___[||]___/       \\\n" +
                            " /          ||||||          \\\n" +
                            "/          (oooooo)          \\\n" +
                            "\\________/~~~~~~~~~~\\________/");
                } else {
                    System.out.println("Player 2 wins!");
                    System.out.println("       /\\\n" +
                            "         /  \\          ___/  \\\n" +
                            "        /    \\________/       \\\n" +
                            "       /      ^    ^      \\     /\\\n" +
                            "~~~~~~\\    (o)      (o)    /~~~~~~\n" +
                            "~~~~~~/ \\     vvvvvvvv     / \\~~~~~~\n" +
                            "      /   \\_____________/   \\\n" +
                            "     /\\   / \\   ||||   / \\   /\\/\\\n" +
                            "    /  \\_/   \\__||||__/   \\_/  \\\n" +
                            "   /     \\_____[||]_____/     \\\n" +
                            "  /       \\___[||]___/       \\\n" +
                            " /          ||||||          \\\n" +
                            "/          (oooooo)          \\\n" +
                            "\\________/~~~~~~~~~~\\________/");
                }
                isGameOver = true;
                break;

            } else {
                player1Turn = !player1Turn;
            }

        }
    }

    private static String chooseSymbol(Scanner scanner, String player) {
        System.out.println(player + ", choose your emoji by number: ");
        int num = scanner.nextInt();
        String chosenSymbol = symbolManager.chooseSymbol(num);
        while (chosenSymbol == null) {
            System.out.println("Error, please choose another number.");
            num = scanner.nextInt();
            chosenSymbol = symbolManager.chooseSymbol(num);
        }
        return chosenSymbol;
    }
}
