package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CellTest {

	Cell cell;

	@Disabled
	public void test() {
		fail("Not yet implemented");
	}

	@BeforeEach
	public void init() {
		cell = new Cell(MarkType.EMPTY);
		System.out.println("BE");
	}

	@Test
	public void testCellIsEmpty() {
		assertTrue(cell.isEmpty());
	}
	@Test
	public void testMarkXOrOToCell() throws CellAlreadyMarkedException {
		cell.setMark(MarkType.X);
		assertEquals(MarkType.X, cell.getMark());
//		cell.setMark(MarkType.O);
//		assertEquals(MarkType.O, cell.getMark());
	}
    @Test
    public void testCannotMarkAgain() throws CellAlreadyMarkedException {
        cell.setMark(MarkType.X);
        assertThrows(CellAlreadyMarkedException.class, () -> {
            cell.setMark(MarkType.O);
        });
        assertEquals(MarkType.X, cell.getMark());
    }
	



}
