package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Board;
import com.aurionpro.model.Cell;
import com.aurionpro.model.CellAlreadyMarkedException;
import com.aurionpro.model.MarkType;
import com.aurionpro.model.ResultAnalyzer;

public class GameTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        Board board = new Board();
        ResultAnalyzer resultAnalyzer = new ResultAnalyzer(board);
        MarkType currentPlayerMark = MarkType.X;
        boolean gameInProgress = true;

        System.out.println("Welcome to Tic-Tac-Toe!");

        while (gameInProgress) {
            displayBoard(board);

            int move;
            do {
                System.out.println("Player " + currentPlayerMark + ", enter your move (0-8): ");
                move = sc.nextInt();
            } while (move < 0 || move > 8 || !board.getCells()[move].isEmpty());

            try {
                board.setCellMarked(move, currentPlayerMark);
            } catch (CellAlreadyMarkedException e) {
                System.out.println("Invalid move. The cell is already marked.");
                continue;
            }

            if (resultAnalyzer.horizontalWinCheck(currentPlayerMark) ||
                resultAnalyzer.verticalWinCheck(currentPlayerMark) ||
                resultAnalyzer.diagonalWinCheck(currentPlayerMark)) {
                displayBoard(board);
                System.out.println("Player " + currentPlayerMark + " wins!");
                gameInProgress = false;
            } else if (resultAnalyzer.getBoard().isBoardFull()) {
                displayBoard(board);
                System.out.println("It's a draw!");
                gameInProgress = false;
            }

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