import java.io.*;
import java.util.*;
public class Main {
	
	
	public static void main(String[] args) throws Exception
	{
		long start=System.currentTimeMillis();
		
		
		File file=new File("C:\\Users\\nanon\\eclipse-workspace"
				+ "\\N_PUZZLE\\src\\Solvable Puzzles\\8 Puzzle (4).txt");
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(file);
		int n=sc.nextInt();
		System.out.println(n);
		
		int [][]board=new int[n][n];
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				board[i][j]=sc.nextInt();
				System.out.print(board[i][j]+"  ");
			}
			System.out.println();
		}
	
		Board initial=new Board(board);
		/*if(initial.isSolvable()) {
			System.out.println("Solvable.");
			AStar solve=new AStar(initial);
			System.out.println("# Steps = "+solve.getCount());
		}
		else {
			System.out.println("Not Solvable.");
			return;
		}
		*/
		AStar solve=new AStar(initial);
		
		System.out.print("Min number of moves = ");
		System.out.println(solve.getCount());
		
		long finish=System.currentTimeMillis();
		//Date duration=new Date((start-finish)/1000);
		System.out.println("Execution time = "+(finish-start)/1000 +" Seconds " + (finish-start) + " MilliSeconds");
	}

}
