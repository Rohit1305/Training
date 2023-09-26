
package com.aurionpro.test;

import com.aurionpro.model.*;

public class GameTest1 {
	public static void main(String[] args) {
		Board board = new Board();
		ResultAnalyzer resultAnalyzer = new ResultAnalyzer(board);
		MarkType currentPlayerMark = MarkType.X;
		boolean gameInProgress = true;

		System.out.println("Welcome to Tic-Tac-Toe!");

		int[] moves = { 0, 1, 3, 4, 6 };

		for (int move : moves) {
			displayBoard(board);

			// Set the current player's mark on the board
			try {
				board.setCellMarked(move, currentPlayerMark);
			} catch (CellAlreadyMarkedException e) {
				System.out.println("Invalid move. The cell is already marked.");
				continue;
			}

			//win or draw
			if (resultAnalyzer.horizontalWinCheck(currentPlayerMark)
					|| resultAnalyzer.verticalWinCheck(currentPlayerMark)
					|| resultAnalyzer.diagonalWinCheck(currentPlayerMark)) {
				displayBoard(board);
				System.out.println("Player " + currentPlayerMark + " wins!");
				gameInProgress = false;
				break; 
			} else if (resultAnalyzer.getBoard().isBoardFull()) {
				displayBoard(board);
				System.out.println("It's a draw!");
				gameInProgress = false;
				break; 
			}

			// Switch 
			currentPlayerMark = (currentPlayerMark == MarkType.X) ? MarkType.O : MarkType.X;
		}

		System.out.println("Thanks for playing Tic-Tac-Toe!");
	}

	public static void displayBoard(Board board) {
		Cell[] cells = board.getCells();
		System.out.println("-------------");
		for (int i = 0; i < 9; i += 3) {
			System.out.print("| ");
			for (int j = i; j < i + 3; j++) {
				System.out.print(cells[j].getMark() + " | ");
			}
			System.out.println("\n-------------");
		}
	}
}