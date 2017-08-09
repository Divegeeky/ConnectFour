
package connect.four.player;

import connect.four.board.ReadWritableBoard;
import java.util.Random;

/**
 * This class is not used for the GUI
 * @author SER 216 Team 8
 *
 */
public class RandomPlayer implements Player {
    @Override
    public String getName() {
        return "Computer";
    }
    @Override
    public void performPlay(ReadWritableBoard board) {
	int width = board.getWidth();
	int height = board.getHeight();
	Random rand = new Random();
        int x = rand.nextInt(width);
        if (board.whoPlayed(x, height-1) != null) {
	    int chosenX = (x + 1) % width;
	    while (board.whoPlayed(chosenX, height-1) != null && chosenX != x) {
		chosenX = (x + 1) % width;
	    }
	    x = chosenX;
	}
	board.play(x, this);
    }
}
