package interfaces;

import components.Cell;
import components.Link;

public interface IPlayer {
    Link findLink(Cell cell) throws Exception;
}
