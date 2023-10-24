package Lab5;

import java.util.Iterator;

public class TicTacToe {
	private static final char EMPTY = ' ';
	private char[][] board;
//…
	public TicTacToe(char[][] board) {
		super();
		this.board = board;
	}
	
	/*
	* This method checks all rows and returns true if any of 
	them are marked with
	* all of a single player's markers.
	* Otherwise, returns false.
	*/
	public boolean checkRows() {
	//TODO
		boolean result= false;
		for (int i = 0; i < board.length; i++) {
			if(checkOneRow(i)) {
				result=true;
				break;}
		}
	return result;
	}
	
	private boolean checkOneRow(int i) {
		// TODO Auto-generated method stub
		for (int j = 0; j < board[0].length-1; j++) {
			if (board[i][j]!= board[i][j+1]) {
				return false;
			}
		}
		return true;
	}

	/*
	* This method checks all columns and returns true if any 
	of them are marked
	* with all of a single player's.
	* Otherwise, returns false.
	*/
	public boolean checkColumns() {
	//TODO
		boolean result= false;
		for (int i = 0; i < board[0].length; i++) {
			if(checkOneColumns(i)) {
				result=true;
				break;}
		}
	return result;
	}

	private boolean checkOneColumns(int i) {
		for (int j = 0; j < board.length-1; j++) {
			if (board[j][i]!= board[j+1][i]) {
				return false;
			}
		}
		return true;
	}

	
	/*
	* This method checks both diagonals and returns true if 
	any of them are marked
	* with all of a single player's markers. Otherwise, 
	returns false.
	*/
	public boolean checkDiagonals() {
		boolean result= true;
	
	return checkBotttoRight()||checkLefttoBot();
	}
	private boolean checkLefttoBot() {
		// TODO Auto-generated method stub
		for (int i = 0; i < board.length-1; i++) {
			if (board[i][i]!= board[i+1][i+1]) {
				return false;
			}
		}
		return true;
	}
	private boolean checkBotttoRight() {
		// TODO Auto-generated method stub
		for (int i = 0; i < board.length-1; i++) {
			int j=board.length-i-1;
			if (board[i][j]!= board[i+1][j-1]) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkBoard() {
		return checkColumns()||checkDiagonals()||checkRows();
	}
	
	public static void main(String[] args) {
		char[][]board= {{'x','o','o'},{'o','x','x'},{'x','o','o'}};
		TicTacToe ex= new TicTacToe(board);
//		System.out.println(ex.checkRows());
//		System.out.println(ex.checkColumns());
//		System.out.println(ex.checkDiagonals());
		System.out.println(ex.checkBoard());
	}
}