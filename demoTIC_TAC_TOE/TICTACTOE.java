package demoTIC_TAC_TOE;

import java.util.Scanner;

public class TICTACTOE {

	public static void main(String[] args) {
		char[][] board = new char[3][3];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = ' ';
			}
		}
		int count = 0;
		char player = 'X';
		boolean gameover = false;
		try (Scanner scanner = new Scanner(System.in)) {
			while (!gameover) {
				PrintBoard(board);
				System.out.println("player   " + player + "  enter:row n col");
				int row = scanner.nextInt();
				if(row>board.length) {
					System.out.println("Invalidmove.Tryagain!");
					break;
				}
				int col = scanner.nextInt();
				if(col>board[0].length) {
					System.out.println("Invalidmove.Tryagain!");
					break;
				}

				System.out.println();
				
				

				if (board[row][col] == ' ') {
					board[row][col] = player;
                                     count++;
					gameover = havewon(board, player);
					if (gameover) {
						System.out.println("player   " + player + "  has won");
						PrintBoard(board);
					} else {
						player = (player == 'X') ? 'O' : 'X';
					}
				} 
				
				else {
					if(count>8) {
					System.out.println("MATCH DRAW");
					break;}
					else {System.out.println("Invalidmove.Tryagain!");
					break;
										}
				}
				
			}
			//	PrintBoard(board);
		}
	}
	

	public static boolean havewon(char[][] board, char player) {
		for (int row = 0; row < board.length; row++) {
			if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
				return true;
			}
		}
		for (int col = 0; col < board[0].length; col++) {
			if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
				return true;
			}
		}
		if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		}
		if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			return true;
		}
		return false;
	}

	public static void PrintBoard(char[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] + " | ");
			}
			System.out.println();
		}
	}
}
