
package connect.four.board;

import connect.four.player.Player;
import java.util.Arrays;

public class Board implements ReadWritableBoard {
    private Player[][] m_contents;
    private int m_moveCount;
    
    public Player mContents(int x, int y) {
    	return m_contents[x][y];
    }
    public
    public int getM_moveCount() {
		return m_moveCount;
	}
	public void setM_moveCount(int m_moveCount) {
		this.m_moveCount = m_moveCount;
	}
	public Board(int width, int height) {
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
    public Board(ReadableBoard copy) {
        if (copy instanceof Board) {
        	Board copyB = (Board) copy;
            m_moveCount = copyB.m_moveCount;
            int l = copyB.m_contents.length;
            int m = copyB.m_contents[0].length;
            m_contents = new Player[l][m];
            for (int i = 0; i != l; ++i) {
                m_contents[i] = Arrays.copyOf(copyB.m_contents[i], m);
            }
        } else {
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
    public @Override Player whoPlayed(int x, int y) {
    	if(x < 0 || x > (getWidth()-1) || y < 0 || y > (getHeight()-1)){
    		return null;
    	}
    	else
    		return m_contents[x][y];
    }
    public @Override int getWidth() {
        return m_contents.length;
    }
    public @Override int getHeight() {
        return m_contents[0].length;
    }
    public @Override void play(int x, Player p) {
        int y = getColumnHeight(x);
        if (y == m_contents[x].length) {
            throw new ColumnFullException();
        }
        m_contents[x][y] = p;
        m_moveCount += 1;
    }
    
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
    public @Override void clear() {
        int l = m_contents.length;
        int m = m_contents[0].length;
        for (int i = 0; i != l; ++i) {
            m_contents[i] = new Player[m];
        }
	m_moveCount = 0;
    }
    public @Override int getMoveCount() {
        return m_moveCount;
    }
}
