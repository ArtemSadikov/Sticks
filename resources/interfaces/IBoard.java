package interfaces;

import components.Cell;
import components.Player;
import types.CellType;

import java.util.ArrayList;

public interface IBoard {
    void printBoard();
    Cell getCell(int row, int col);
    void setCell(int row, int col, CellType type);
}
