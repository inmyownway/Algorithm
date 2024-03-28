import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;


public class Main {
	  static final int INF = 987654321;
	static int[][] board;
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N= Integer.parseInt(bf.readLine());
		int M= Integer.parseInt(bf.readLine());
		
		board = new int[N][N];

		

		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
	
						board[i][j]=100000*N;
			
				
				if(i==j)
					board[i][j]=0;
			
			}
		
		}
		
		for(int i=0;i<M;i++)
		{
			st= new StringTokenizer(bf.readLine());
			
			int to =Integer.parseInt(st.nextToken());
			int from =Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			board[to-1][from-1]=Math.min(board[to-1][from-1],d);
		}
		for(int k=0;k<N;k++)
		{
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(board[i][j] > board[i][k]+board[k][j])
						{
							board[i][j]=board[i][k]+board[k][j];
						}
					
				}
			}
		}
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(board[i][j]==100000*N)
					board[i][j]=0;
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	
	
		
	}
}