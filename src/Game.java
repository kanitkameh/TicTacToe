
import java.util.Scanner;
import static org.fusesource.jansi.Ansi.*;
import org.fusesource.jansi.AnsiConsole;

public class Game {
	static public int turns;
	public Game() {
		//suitable for additional game settings
	}
	void startGame() {
		AnsiConsole.systemInstall();
		clrScr();
		int row=0;
		int col=0;
		char p1char = 0;
		char p2char = 0;
		Scanner input = new Scanner(System.in);
		
		while(row<3) {
		System.out.println("Enter row count greater than 2:");
		row = input.nextInt();
		}
		
		while(col<3) {
		System.out.println("Enter column count greater than 2:");
		col = input.nextInt();
		}
		
		while(p1char==0||(p1char>=48&&p1char<=57)) { //checks if the char is not empty or a number
			System.out.println("Player 1, please choose your char(Numbers are not allowed):");
			p1char = input.next().charAt(0);
		}

		while(p2char==0||(p2char>=48&&p2char<=57)) { //checks if the char is not empty or a number
			System.out.println("Player 2, please choose your char(Numbers are not allowed):");
			p2char = input.next().charAt(0);
		}
		
		
		
		Board board = new Board(row,col);//you can set custom board size
		Player p1 = new Player(p1char);//you can set custom player symbol
		Player p2 = new Player(p2char);
		
		clrScr();
		board.showBoard();
		
		turns = row*col;
		while(turns>0) {
			System.out.println("Player "+p1char+", choose your number\n");
			//checks if there is already sign at that position
			while(!board.ticASquare(input.nextInt(), p1.getSign())); 
			clrScr();
			board.showBoard();
			if(board.checkForWins()) {
				break;
			}else if(turns==0) {
				System.out.println("It's a tie");
				break;
			}
			System.out.println("Player "+p2char+", choose your number\n");
			//same thing with the second player
			while(!board.ticASquare(input.nextInt(), p2.getSign()));
			clrScr();
			board.showBoard();	
			if(board.checkForWins()) {
				break;
			}else if(turns==0) {
				System.out.println("It's a tie");
				break;
			}
			
		}
		input.close();
	}
	
	public void clrScr() {
		System.out.println(ansi().eraseScreen().cursor(0, 0)); //clears screen and resets cursor
	}

}
