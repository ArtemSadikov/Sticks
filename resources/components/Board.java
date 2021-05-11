package components;

import interfaces.IBoard;
import types.CellType;

import java.io.Serializable;

public class Board implements IBoard, Serializable {
    private Cell[][] board;
    private Link[] links;
    private int size;
    private final static int MIN_SIZE = 3;

    public Board(int size) throws Exception {
        if (size >= MIN_SIZE) {
            initBoard(size);
        } else {
            throw new Exception("Size must be greater than 3");
        }
    }

    private void initBoard(int size) {
        this.size = size;
        this.board = new Cell[size][size];
        for (int row = 0; row < this.size; row++) {
            for (int col = 0; col < this.size; col++) {
                this.board[row][col] = new Cell(row, col, CellType.EMPTY);
            }
        }
    }

    public void setNewLink(Link link) {
        Link[] temp = this.links;
        Link[] result = new Link[this.links.length + 1];
        System.arraycopy(temp, 0, result, 0, result.length - 1);
        result[result.length - 1] = link;
        this.links = result;
    }

    @Override
    public void printBoard() {
        for (Cell[] row : this.board) {
            for (Cell col : row) {
                System.out.print(col.getType().getType() + " ");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public Cell getCell(int row, int col) {
        return this.board[row][col];
    }

    @Override
    public void setCell(int row, int col, CellType type) {
        this.board[row][col].setType(type);
    }
}
