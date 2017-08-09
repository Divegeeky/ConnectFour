
package connect.four.player;

import connect.four.board.ReadWritableBoard;
import connect.four.player.ComputerPlayer.FirstMoveException;

public interface Player {
    String getName();
    void performPlay(ReadWritableBoard board) throws FirstMoveException;
}
