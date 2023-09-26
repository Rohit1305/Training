package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class BoardTest {
	Board board;

	@Test
	@Disabled
	void test() {
		fail("Not yet implemented");
	}

	@BeforeEach
	public void init() {
		board = new Board();
		System.out.println("BE");
	}

	@Test
	public void testInitiallyEmpty() {
		Cell[] cells = board.getCells();
		for (Cell cell : cells) {
			assertTrue(cell.isEmpty());
		}
	}

	@Test
	public void testAtParticularLocation() throws CellAlreadyMarkedException {
		board.setCellMarked(7, MarkType.X);
		Cell cell = board.getCells()[7];
		assertEquals(MarkType.X, cell.getMark());
	}

	@Test
	public void testBoardIsFull() throws CellAlreadyMarkedException {
		for (int i = 0; i < 9; i++) {
			if (i == 3) {
				board.setCellMarked(i, MarkType.X);
				continue;
			}
			board.setCellMarked(i, MarkType.X);
		}
		assertTrue(board.isBoardFull());
	}

	@Test
	public void testInvalidLocationException() {
		assertThrows(IllegalArgumentException.class, () -> {
			board.setCellMarked(-1, MarkType.X);
		});
	}

	@Test
	public void testMarkCellTwice() {
		assertDoesNotThrow(() -> {
			board.setCellMarked(3, MarkType.X);
			assertThrows(CellAlreadyMarkedException.class, () -> board.setCellMarked(3, MarkType.O));
		});
	}

}
