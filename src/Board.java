import java.util.Scanner;
public class Board extends Players{
        private String[][] grid;
        private Scanner scan;

        public Board(){
                this.grid = new String[8][8];
                this.scan = new Scanner(System.in);
        }
        public void start(){
                System.out.println("welcome to yuhao's connect 4 game!~!");
                System.out.println("what will player 1 be?: ");
                String player1Piece = scan.nextLine();
                System.out.println("what will player 2 be?: ");
                String player2Piece = scan.nextLine();

        }

}
