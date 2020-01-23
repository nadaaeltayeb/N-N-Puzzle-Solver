

public class Node implements Comparable<Node>{

	public Board board;
	public int g=0;
	public int f;
	public Node parent; 
	public int hamming=0;
	public int manhattan=0; 
	public Node(Board board)
	{
		this.board=board;
		parent=null;
	}
	public Node(Board board,Node parent,int g)
	{
		this.board=board;
		this.parent=parent;
		this.g=g;
		manhattan=board.manhattan()+g;
		hamming=board.hamming()+g;
	}
	
	
	
	@Override
	public int compareTo(Node that) {
		// TODO Auto-generated method stub
		
		//return (this.board.manhattan()-that.board.manhattan())+(this.g-that.g);
		if(this.manhattan-that.manhattan > 0)
			return 1;
			return -1;
	}
	public int getHamming()
	{
		return g+board.hamming();
	}
	public int getManhattan()
	{
		return g+board.manhattan();
	}
	 
}
