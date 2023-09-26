package com.aurionpro.model;

public class ResultAnalyzer {

	private Board board;
	private ResultType result;

	public ResultAnalyzer() {
		super();
		this.board = new Board();
		this.setResult(ResultType.PROGRESS);
	}

	public Board getBoard() {
		return board;
	}

	public ResultType analyzeResult() {
		horizontalWinCheck();
		verticalWinCheck();
		diagonalWinCheck();
		if (result != result.WIN) {
			if (!board.isBoardFull()) {
				result = ResultType.PROGRESS;
			} else {
				result = ResultType.DRAW;
			}
		}
		return result;
	}

	public ResultType getResult() {
		return result;
	}

	public void setResult(ResultType result) {
		this.result = result;
	}

	public void horizontalWinCheck() {
		for (int row = 0; row < 3; row++) {
			if ((board.getCells()[row * 3].getMark() == MarkType.X
					&& board.getCells()[row * 3 + 1].getMark() == MarkType.X
					&& board.getCells()[row * 3 + 2].getMark() == MarkType.X)) {
				result = ResultType.WIN;
			}
			if ((board.getCells()[row * 3].getMark() == MarkType.O
					&& board.getCells()[row * 3 + 1].getMark() == MarkType.O
					&& board.getCells()[row * 3 + 2].getMark() == MarkType.O)) {
				result = ResultType.WIN;
			}
		}
	}

	public void verticalWinCheck() {
		for (int col = 0; col < 3; col++) {
			if (board.getCells()[col].getMark() == MarkType.X && board.getCells()[col + 3].getMark() == MarkType.X
					&& board.getCells()[col + 6].getMark() == MarkType.X) {
				result = ResultType.WIN;
			}

			if (board.getCells()[col].getMark() == MarkType.O && board.getCells()[col + 3].getMark() == MarkType.O
					&& board.getCells()[col + 6].getMark() == MarkType.O) {
				result = ResultType.WIN;
			}
		}
	}

	public void diagonalWinCheck() {
		if ((board.getCells()[0].getMark() == MarkType.X && board.getCells()[4].getMark() == MarkType.X
				&& board.getCells()[8].getMark() == MarkType.X)
				|| (board.getCells()[2].getMark() == MarkType.X && board.getCells()[4].getMark() == MarkType.X
						&& board.getCells()[6].getMark() == MarkType.X)) {
			result = ResultType.WIN;
		}

		if ((board.getCells()[0].getMark() == MarkType.O && board.getCells()[4].getMark() == MarkType.O
				&& board.getCells()[8].getMark() == MarkType.O)
				|| (board.getCells()[2].getMark() == MarkType.O && board.getCells()[4].getMark() == MarkType.O
						&& board.getCells()[6].getMark() == MarkType.O)) {
			result = ResultType.WIN;
		}

	}

}
