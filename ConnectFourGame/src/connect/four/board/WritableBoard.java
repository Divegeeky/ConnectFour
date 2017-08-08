
package connect.four.board;

import connect.four.player.Player;

/**
 * SER 216 - Group Project
 * 
 * <p>This class set the minimum required methods for a class that implements WritableBoard.
 * 
 * @author SER-216 Instructors
 * @version 8/7/2017
 */

public interface WritableBoard {
    void play(int x, Player p);
    void clear();
}
