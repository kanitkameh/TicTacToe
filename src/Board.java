
public class Board {
	
	char[][] board;
	private boolean firstLoad;
	private int numberOfSquare; //used to show the number of the cell on launch
	
	public Board(int rows, int cols) {
		board = new char[rows][cols];
		firstLoad=true;
		numberOfSquare=0;
	}
	//prints the board in a table with all of its content
	void showBoard() {
		for(int row=0;row<board.length;row++) {
			for(int col=0;col<board[0].length;col++) {
				if(firstLoad) {
					System.out.print(" "+numberOfSquare++ +" "+"|");
				}else {
					System.out.print(" "+board[row][col]+" "+"|");
				}
			}
			System.out.println();
			if(row!=board.length-1) {
				for(int i=0;i<board[0].length;i++)
				System.out.print("--- ");
			}
			System.out.println();
		}
		firstLoad=false;
	}
	
	char[][] getBoard(){
		return board;
	}
	//sets a sign in the board
	boolean ticASquare(int position,char sign) {
		//checks if the requested position is bigger than the max number of cells
		if(position>board.length*board[0].length-1) {
			System.out.println("You entered a too big number...Try again!");
			return false;
		}
		int i =0;
		boolean hasSuccesfullyTicked = false;
		for(int row = 0;row<board.length;row++) {
			for(int col = 0;col<board[0].length;col++) {
				if(i==position) {
					if((char)board[row][col]=='\u0000') {
						board[row][col]=sign;
						hasSuccesfullyTicked = true;
						Game.turns--;
					}else {
						System.out.println("Another player has occupied this fiel...Try other one!");
						hasSuccesfullyTicked = false;
					}
				}
				i++;
			}
		}
		return hasSuccesfullyTicked;
	}
	
	void setBoard(char[][] board) {
		this.board = board;
	}
	boolean checkForWins() {
		//goes through all elements and calls on them checkForHorizontal,Vertical and Diagonal win on this box(works)
		for(int row=0;row<board.length;row++) {
			for(int col=0;col<board[0].length;col++) {
				//checks if non empty player has 3 signs in a row, column or horizontal
				if(board[row][col]!='\u0000'&&(checkHorizontal(row, col) || checkVertical(row, col) || checkDiagonal(row, col))) {
					System.out.println("Player "+board[row][col]+" wins");
					return true;
				}
			}
		}
		return false;
	}
	//all checking methods will be implemented to determine win on 3 ticks
	private boolean checkDiagonal(int row, int col) {
		if(col<=board[0].length-3&&row<=board.length-3) {
			if(board[row][col]==board[row+1][col+1] && board[row][col]==board[row+2][col+2]) {
				System.out.println("There is a win there");
				return true;
			}
		}
		if(col<=board[0].length-3&&row>=2) {
			if(board[row][col]==board[row-1][col+1] && board[row][col]==board[row-2][col+2]) {
				System.out.println("There is a win there");
				return true;
			}
		}
		return false;
	}
	private boolean checkVertical(int row, int col) {
 		if(row<=board.length-3) {
			if(board[row][col]==board[row+1][col] && board[row][col]==board[row+2][col]) {
				System.out.println("There is a win there");
				return true;
			}
		}
 		return false;
	}
	private boolean checkHorizontal(int row, int col) {
		if(col<=board[0].length-3) {
			if(board[row][col]==board[row][col+1] && board[row][col]==board[row][col+2]) {
				System.out.println("There is a win there");
				return true;
			}
		}
		return false;
	}
}
