import java.util.Arrays;
import java.util.Scanner;
public class Board {
        public String[][] grid;
        private Scanner scan;

        public Board(){
                this.grid = new String[8][8];
                this.scan = new Scanner(System.in);
        }
        public void start(){
//                System.out.println("welcome to yuhao's connect 4 game!~!");
//                System.out.println("what will player 1 be?: ");
//                String player1Piece = scan.nextLine();
//                Player1.setPiece(player1Piece);
//                System.out.println("what will player 2 be?: ");
//                String player2Piece = scan.nextLine();
//                Player2.setPiece(player2Piece);
                System.out.println(Arrays.deepToString(grid).replace("],", "],\n"));


        }


}
