import java.util.LinkedList;

public class Board {

	public int [][] tiles;
    private int blank=0;
    //private int manhttandis ;
   
    public Board(int [][]tiles)
    {
    	this.tiles=tiles;
    }
 

    public int hamming()
    {
    	int count=0;
    	for(int i=0;i<tiles.length;i++)
    	{
    		for(int j=0;j<tiles.length;j++)
    		{
    			if(tiles[i][j]!=tiles.length*i+j+1 && tiles[i][j]!=blank)
    			{
    				count++;
    			}
    		}
    	}
    	return count;
    }
    private boolean isSpace(int block) {
        return block == blank;
    }
    public int manhattan() {
        int sum = 0;
        for (int row = 0; row < tiles.length; row++) 
            for (int col = 0; col < tiles.length; col++)
            {
            	int val=tiles[row][col];
            	if(val!=0)
            	{
            		int x=(val-1)/tiles.length;
            		int y=(val-1)%tiles.length;
            		int dx=row-x;
            		int dy=col-y;
            		sum+=Math.abs(dx)+Math.abs(dy);
            	}
            }
        return sum;
        }

    public int tileAt(int row,int col)
    {
    	return tiles[row][col];
    }
    public boolean isGoal()
    {
    	for(int i=0;i<tiles.length;i++)
    	{
    		for(int j=0;j<tiles.length;j++)
    		{
    			if(tiles[i][j]!=tiles.length*i+j+1 && tiles[i][j]!=blank )
    			{
    				return false;
    			}
    		}
    	}
    	//return manhattan()==0;
    	return true;
    }
    private int[][] copy(int[][] blocks) {
        int[][] copy = new int[blocks.length][blocks.length];
        for (int row = 0; row < blocks.length; row++)
            for (int col = 0; col < blocks.length; col++)
                copy[row][col] = blocks[row][col];

        return copy;
    }
    public int [][] swap(int row1,int col1,int row2,int col2)
    {
    	int[][] copy = new int[tiles.length][tiles.length];
        for (int row = 0; row < tiles.length; row++)
            for (int col = 0; col < tiles.length; col++)
                copy[row][col] = tiles[row][col];
        int tmp = copy[row1][col1];
        copy[row1][col1] = copy[row2][col2];
        copy[row2][col2] = tmp;

        return copy;
    }
    public Iterable<Board> neighbours()
    {
        LinkedList<Board>childrens=new LinkedList<Board>();
    	int [] location=getBlankSpace();
    	int row=location[0];
    	int col=location[1];
    	int length=tiles.length;
    	if(row > 0)
    	{
    		childrens.add(new Board(swap(row, col, row-1, col)));
    	}
    	if(row < length-1) 
    	{
    		childrens.add(new Board(swap(row, col, row+1, col)));
    	}
    	if(col > 0)
    	{
    		childrens.add(new Board(swap(row, col, row, col-1)));
    	}  
    	if(col < length-1)
    	{
    		childrens.add(new Board(swap(row, col, row, col+1)));
    	}
    	return childrens;
    }
    int [] getBlankSpace()
    {
    	int [] location=new int[2];
    	for(int i=0;i<tiles.length;i++)
    	{
    		for(int j=0;j<tiles.length;j++)
    		{
    			if(tiles[i][j]==blank)
    			{
    				location[0]=i;
    				location[1]=j;
    				break;
    			}
    		}
    	}
    	return location;
    }
    
    public boolean equal(Board y) {
        for (int row = 0; row < tiles.length; row++)
            for (int col = 0; col < tiles.length; col++)
                if ( y.tiles[row][col] != this.tiles[row][col]) return false;

        return true;
    }
  /*  public boolean isSolvable() {
    	boolean ret=true;
    	int blank_row=0;
    	int invensions=0;
    	int count=0;
    	//-1 as we don't take blank
    	int [] Tiles=new int[(tiles.length*tiles.length)-1];
    	
    	for(int i=0 ; i<tiles.length ; i++) {
    		for(int j=0 ; j<tiles.length ; j++) {
    			if(tiles[i][j]==0) {
    				blank_row=i;
    				continue;
    			}
    			else {
    				Tiles[count]=tiles[i][j];
    				count++;
    			}
    		}
    	}
    	
    	for(int i=0 ; i<(tiles.length*tiles.length)-2 ; i++) {
    		for(int j=i+1 ; j<(tiles.length*tiles.length)-1 ; j++) {
    			if(Tiles[i]>Tiles[j]) {
    				invensions++;
    			}
    		}
    	}
    	
    	if(tiles.length %2==0) {
    		if((invensions+blank_row)%2==0) {
    			return false;
    		}
    	}
    	else {
    		if(invensions%2 !=0) {
    			return false;
    		}
    	}
    	if(ret) {
    		//manhattan();
    	}
    	return true;
    }
	*/
  
}
