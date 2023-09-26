package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Board;
import com.aurionpro.model.Cell;
import com.aurionpro.model.Game;
import com.aurionpro.model.MarkType;
import com.aurionpro.model.Player;
import com.aurionpro.model.ResultAnalyzer;
import com.aurionpro.model.ResultType;

public class GameTesting {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Tic-Tac-Toe!");

        Player player1 = new Player("Player 1", MarkType.X);
        Player player2 = new Player("Player 2", MarkType.O);

        ResultAnalyzer resultAnalyzer = new ResultAnalyzer();
        Game game = new Game(new Player[]{player1, player2}, resultAnalyzer);

        while (!game.isGameOver()) {
            displayBoard(game.getAnalyzer().getBoard());

            Player currentPlayer = game.getCurrentPlayer();
            System.out.print(currentPlayer.getName() + ", enter your move (0-8): ");
            int move = sc.nextInt();

            game.play(move);
        }

        displayBoard(game.getAnalyzer().getBoard());
        ResultType gameResult = resultAnalyzer.getResult();
        if (gameResult == ResultType.WIN) {
            System.out.println(game.getCurrentPlayer().getName() + " wins!");
        } else if (gameResult == ResultType.DRAW) {
            System.out.println("It's a draw!");
        }

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
