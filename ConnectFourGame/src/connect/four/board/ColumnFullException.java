
package connect.four.board;

/**
 * SER 216 - Group Project
 * 
 * <p>This class sets up a custom exception for when a column of the Board class is full and the user attempts
 * to play within that column.
 * 
 * @author SER-216 Instructors
 * @version 8/7/2017
 */
public class ColumnFullException extends IndexOutOfBoundsException {
	
	/**
	 * Constructor. Runs the exception with the designated string contained in message.
	 * 
	 * @param message
	 */
    public ColumnFullException(String message) {
	super(message);
    }
    
    /**
	 * Default Constructor. Runs the exception when no string is designated.
	 * 
	 * @param message
	 */
    public ColumnFullException() {
	super("Played in a full column.");
    }
}
