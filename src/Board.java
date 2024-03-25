import java.util.Scanner;

public class Board {
        private GamePiece[][] grid;
        private Scanner scan;

        public Board(int rows, int columns) {
                this.grid = new GamePiece[rows][columns];
                this.scan = new Scanner(System.in);
        }

        public boolean placePiece(int column, GamePiece piece) {
                for (int i = grid.length - 1; i >= 0; i--) {
                        if (grid[i][column] == null) {
                                grid[i][column] = piece;
                                return true;
                        }
                }
                return false; // Column is full
        }

        public void printBoard() {
                for (GamePiece[] row : grid) {
                        for (GamePiece cell : row) {
                                if (cell == null) {
                                        System.out.print("_    ");
                                } else {
                                        String symbol = ((GamePiece) cell).getSymbol();
                                        System.out.print(symbol);
                                        int space = 4 - symbol.length();
                                        for (int i = 0; i <= space; i++) {
                                                System.out.print(" ");
                                        }
                                }
                        }
                        System.out.println();
                }
        }
}



