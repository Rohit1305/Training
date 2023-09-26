package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultAnalyzerTest {

	ResultAnalyzer analyzer;
	Board board;

	@BeforeEach
	public void init() {
		
		analyzer = new ResultAnalyzer();
		board = analyzer.getBoard();
	}

	// @Test
	// void test() {
	// fail("Not yet implemented");
	// }

	@Test
	void testHorizontalWinCheck_firstRow() throws CellAlreadyMarkedException {
		board.setCellMarked(0, MarkType.O);
		board.setCellMarked(1, MarkType.O);
		board.setCellMarked(2, MarkType.O);

		analyzer.horizontalWinCheck();
		assertEquals(ResultType.WIN, analyzer.getResult());

	}

	@Test
	void testHorizontalWinCheck_secondRow() throws CellAlreadyMarkedException {
		board.setCellMarked(3, MarkType.O);
		board.setCellMarked(4, MarkType.O);
		board.setCellMarked(5, MarkType.O);

		analyzer.horizontalWinCheck();
		assertEquals(ResultType.WIN, analyzer.getResult());
	}

	@Test
	void testHorizontalWinCheck_thirdRow() throws CellAlreadyMarkedException {
		board.setCellMarked(6, MarkType.O);
		board.setCellMarked(7, MarkType.O);
		board.setCellMarked(8, MarkType.O);

		analyzer.horizontalWinCheck();
		assertEquals(ResultType.WIN, analyzer.getResult());
	}

	@Test
	void testVerticalWinCheck_firstColumn() throws CellAlreadyMarkedException {
		board.setCellMarked(0, MarkType.O);
		board.setCellMarked(3, MarkType.O);
		board.setCellMarked(6, MarkType.O);

		analyzer.verticalWinCheck();
		assertEquals(ResultType.WIN, analyzer.getResult());
	}

	@Test
	void testVerticalWinCheck_secondColumn() throws CellAlreadyMarkedException {
		board.setCellMarked(1, MarkType.O);
		board.setCellMarked(4, MarkType.O);
		board.setCellMarked(7, MarkType.O);

		analyzer.verticalWinCheck();
		assertEquals(ResultType.WIN, analyzer.getResult());
	}

	@Test
	void testVerticalWinCheck_thirdColumn() throws CellAlreadyMarkedException {
		board.setCellMarked(2, MarkType.O);
		board.setCellMarked(5, MarkType.O);
		board.setCellMarked(8, MarkType.O);

		analyzer.verticalWinCheck();
		assertEquals(ResultType.WIN, analyzer.getResult());
	}

	@Test
	void testdiagonalWinCheck_firstDiagonal() throws CellAlreadyMarkedException {
		board.setCellMarked(0, MarkType.O);
		board.setCellMarked(4, MarkType.O);
		board.setCellMarked(8, MarkType.O);

		analyzer.diagonalWinCheck();
		assertEquals(ResultType.WIN, analyzer.getResult());
	}

	@Test
	void testdiagonalWinCheck_secondDiagonal() throws CellAlreadyMarkedException {
		board.setCellMarked(2, MarkType.O);
		board.setCellMarked(4, MarkType.O);
		board.setCellMarked(6, MarkType.O);

		analyzer.diagonalWinCheck();
		assertEquals(ResultType.WIN, analyzer.getResult());
	}

	@Test
	 void testDraw() throws CellAlreadyMarkedException{
	  board.setCellMarked(0, MarkType.X);
	  board.setCellMarked(1, MarkType.O);
	  board.setCellMarked(2, MarkType.X);
	  board.setCellMarked(3, MarkType.X);
	  board.setCellMarked(4, MarkType.X);
	  board.setCellMarked(5, MarkType.O);
	  board.setCellMarked(6, MarkType.O);
	  board.setCellMarked(7, MarkType.X);
	  board.setCellMarked(8, MarkType.O);
	  
	  analyzer.analyzeResult();

	  assertEquals(ResultType.DRAW, analyzer.getResult());
	}

}
