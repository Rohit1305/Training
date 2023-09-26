package com.aurionpro.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Board {
	private Cell[] cells = new Cell[9];

    public Board() {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell(MarkType.EMPTY);
        }
    }

    public boolean isBoardFull() {
        for (Cell cell : cells) {
            if (cell.isEmpty()) {
                return false; 
            }
        }
        return true; 
    }

    public void setCellMarked(int loc, MarkType mark) throws CellAlreadyMarkedException {
        if (loc < 0 || loc >= cells.length) {
            throw new IllegalArgumentException("Invalid cell location");
        }
        
        if (cells[loc].isEmpty()) {
            cells[loc].setMark(mark);
        } else {
            throw new CellAlreadyMarkedException("Cell is already marked.");
        }
    }

    
    
    
    public Cell[] getCells() {
        return cells;
    }
    


}
