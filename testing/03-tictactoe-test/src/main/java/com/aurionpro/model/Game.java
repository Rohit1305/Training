package com.aurionpro.model;

import java.util.Arrays;

public class Game {

	private Player currentPlayer;
	private Player[] players;
	private Board board;
	private ResultAnalyzer analyzer;

	public Game(Player[] players, ResultAnalyzer analyzer) {
		this.players = players;
		this.currentPlayer = players[0];
		this.analyzer = analyzer;
		this.board = analyzer.getBoard();
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public ResultAnalyzer getAnalyzer() {
		return analyzer;
	}

	public void setAnalyzer(ResultAnalyzer analyzer) {
		this.analyzer = analyzer;
	}

	public void play(int loc) {
		try {
			board.setCellMarked(loc, getCurrentPlayer().getType());
			ResultType gameResult = analyzer.analyzeResult();
			if (gameResult == ResultType.WIN) {
				System.out.println(getCurrentPlayer().getName() + " wins!");
			} else if (gameResult == ResultType.DRAW) {
				System.out.println("It's a draw!");
			} else if (gameResult == ResultType.PROGRESS) {
				switchPlayer();
			}
		} catch (CellAlreadyMarkedException e) {
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	} 

	private void switchPlayer() {
		int currentIndex = Arrays.asList(players).indexOf(currentPlayer);
		int nextIndex = (currentIndex + 1) % players.length;
		currentPlayer = players[nextIndex];

	}

	public boolean isGameOver() {
		return analyzer.getResult() != ResultType.PROGRESS;
	}

}
