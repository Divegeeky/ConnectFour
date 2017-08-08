package connect.four.board;
import connect.four.player.Player;
import java.util.Arrays;

/**
 * SER 216 - Group Project
 * 
 * <p>This class produces an mxn game board from user input. It has functionality to place
 * a game piece, clear the board, return player objects.
 * 
 * @author Jonathon Ross, SER-216 Instructors
 * @version 8/7/2017
 */
public class Board implements ReadWritableBoard {
    private Player[][] m_contents;
    private int m_moveCount;
    
    /**
     * Constructor for a Board object. To be used when no previous board exists. Creates a mxn Player array. Will throw a NegativeArraySizeException if
     * either width or height are a negative number.
     * 
     * @param width
     * @param height
     */
	public Board(int width, int height) throws NegativeArraySizeException {
    	if(width < 0)
    	{
    		throw new NegativeArraySizeException("The width was negative. Please enter a number >= 0");
    	}
    	else if(height < 0){
    		throw new NegativeArraySizeException("The height was negative. Please enter a number >= 0");
    	}
    	else
    	{
    		m_contents = new Player[width][height];
    	}
        m_moveCount = 0;
    }
	
	/**
	 * Constructor for a Board object. This is to be used if there is already an existing Board that needs to be 
	 * used to set up a new Board.
	 *  
	 * @param copy
	 */
    public Board(ReadableBoard copy) {
    	
    	//Copies a Board Object
    	
        if (copy instanceof Board) {
        	Board copyB = (Board) copy;
            m_moveCount = copyB.getMoveCount();
            int l = copyB.getWidth();
            int m = copyB.getHeight();
            m_contents = new Player[l][m];
            for (int i = 0; i != l; ++i) {
                m_contents[i] = Arrays.copyOf(copyB.mContentsArray(i), m);
            }
        } 
        
        // Copies any other ReadableBoard Object
        
        else {
        	int l = copy.getWidth();
            int m = copy.getHeight();
            m_contents = new Player[l][m];
            m_moveCount = copy.getMoveCount();
            for (int i = 0; i != l; ++i) {
                for (int j = 0; j != m; ++j) {
                    m_contents[i][j] = copy.whoPlayed(i, j);
                }
            }
        }
    }
    
    /**
     * Method returns the Player object stored within the mxn array that is located at [x][y].
     * 
     * @param x
     * @param y
     */
    public @Override Player whoPlayed(int x, int y) {
    	if(x < 0 || x > (getWidth()-1) || y < 0 || y > (getHeight()-1)){
    		return null;
    	}
    	else
    		return m_contents[x][y];
    }
    /**
     * Method returns the width of the Board object.
     */
    public @Override int getWidth() {
        return m_contents.length;
    }
    /**
     * Method returns the height of the Board object.
     */
    public @Override int getHeight() {
        return m_contents[0].length;
    }
    
    /**
     * Method simulates placing a game piece in the board. Stores Player p into the appropriate index within
     * the column designated by x.
     * 
     * @param x
     * @param p
     */
    public @Override void play(int x, Player p) throws ColumnFullException{
        int y = getColumnHeight(x);
        
        //Checks to see if the column is full
        
        if (y == m_contents[x].length) {
            throw new ColumnFullException();
        }
        m_contents[x][y] = p;
        m_moveCount += 1;
    }
    
    /**
     * Method gets the number of game pieces within the column designated by x.
     * 
     * @param x
     */
    public @Override int getColumnHeight(int x){
        int y = 0;
	int l = m_contents[0].length;
        for(int i = 0; i < l; i++) {
        	if(m_contents[x][i] != null) {
        		y += 1;
        	}
        }
        return y;
    }
    
    /**
     * Clears the current board by setting each column to a new Player array.
     */
    public @Override void clear() {
        int l = m_contents.length;
        int m = m_contents[0].length;
        for (int i = 0; i != l; ++i) {
            m_contents[i] = new Player[m];
        }
	m_moveCount = 0;
    }
    
    /**
     * Method returns the moveCount
     */
    public @Override int getMoveCount() {
        return m_moveCount;
    }
    
    /**
     * Method returns the entire column designated by x.
     * 
     * @param x
     * @return
     */
    public Player[] mContentsArray(int x) {
    	return m_contents[x];
    }
}
