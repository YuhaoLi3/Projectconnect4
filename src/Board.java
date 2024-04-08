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
                printDragonTopBorder();
                for (GamePiece[] row : grid) {
                        for (GamePiece cell : row) {
                                if (cell == null) {
                                        System.out.print("_    ");
                                } else {
                                        String symbol = ((GamePiece) cell).getSymbol();
                                        System.out.print(symbol);
                                        //this help create the space between the emojis because sometimes they have different spaces.
                                        int space = 4 - symbol.codePointCount(0, symbol.length());
                                        for (int i = 0; i < space; i++) {
                                                System.out.print(" ");
                                        }
                                }
                        }
                        System.out.println();
                }
                printDragonBottomBorder();
        }
        public boolean checkWin(GamePiece piece){
                for(int row = 0;row<grid.length;row++){
                        for (int col = 0; col < grid[0].length - 3; col++) {
                                if (grid[row][col] == piece && grid[row][col + 1] == piece &&
                                        grid[row][col + 2] == piece && grid[row][col + 3] == piece) {
                                        return true;
                                }

                        }
                }
                for (int col = 0; col < grid[0].length; col++) {
                        for (int row = 0; row < grid.length - 3; row++) {
                                if (grid[row][col] == piece && grid[row + 1][col] == piece &&
                                        grid[row + 2][col] == piece && grid[row + 3][col] == piece) {
                                        return true;
                                }
                        }
                }
                for (int row = 0; row < grid.length - 3; row++) {
                        for (int col = 0; col < grid[0].length - 3; col++) {
                                if (grid[row][col] == piece && grid[row + 1][col + 1] == piece &&
                                        grid[row + 2][col + 2] == piece && grid[row + 3][col + 3] == piece) {
                                        return true;
                                }
                        }
                }
                for (int row = 3; row < grid.length; row++) {
                        for (int col = 0; col < grid[0].length - 3; col++) {
                                if (grid[row][col] == piece && grid[row - 1][col + 1] == piece &&
                                        grid[row - 2][col + 2] == piece && grid[row - 3][col + 3] == piece) {
                                        return true;
                                }
                        }
                }
                return false;
        }

        private void printDragonTopBorder() {
                System.out.print("       /\\\n" +
                        "         /  \\          ___/  \\\n" +
                        "        /    \\________/       \\\n" +
                        "       /      ^    ^      \\     /\\\n" +
                        "~~~~~~\\    (o)      (o)    /~~~~~~\n" +
                        "~~~~~~/ \\     vvvvvvvv     / \\~~~~~~\n");
        }

        private void printDragonBottomBorder() {
                System.out.println( "   /     \\_____[||]_____/     \\\n" +
                        "  /       \\___[||]___/       \\\n" +
                        " /          ||||||          \\\n" +
                        "/          (oooooo)          \\\n" +
                        "\\________/~~~~~~~~~~\\________/");
        }

}



