
package connect.four.board;

import connect.four.player.Player;
/**
 * SER 216 - Group Project
 * 
 * <p>This class sets the minimum methods that all classes implementing it must contain.
 * 
 * @author SER-216 Instructors
 * @version 8/7/2017
 */
public interface ReadableBoard {
    Player whoPlayed(int x, int y);
    int getWidth();
    int getHeight();
    int getColumnHeight(int x);
    int getMoveCount();
}
