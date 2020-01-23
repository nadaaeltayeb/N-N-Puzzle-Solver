import java.util.*;

public class AStar {
	
	private int count=0;
	
	public AStar(Board initial)
	{
		PriorityQueue<Node> pq =new PriorityQueue<Node>();
		Node min;
		pq.add(new Node(initial));
		
		while(true)
		{
			min=pq.poll();
			System.out.println();
			
				for(int i=0;i<min.board.tiles.length;i++)
				{
					for(int j=0;j<min.board.tiles.length;j++)
					{
						System.out.print(min.board.tileAt(i,j)+"  ");
					}
					System.out.println();
				}
			
			if(min.board.isGoal())
			{
				//System.out.println(min.board.manhattan());
				count=min.g;
				break;
			}
			for(Board b : min.board.neighbours())
			{
				/*if(pq.contains(min))
				{
				    //pq.poll();
					continue;
				}*/
				

				if(min.parent==null ||  !b.equal(min.parent.board)  )    
				{
					pq.add(new Node(b,min,min.g+1));
				}
			}
		}
		
	}
	
	public int getCount()
	{
		return count;
	}

}
