import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static int N,M,X;
	static int[][] board;
	static int MAX= Integer.MAX_VALUE/4;
	static int answer= Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		X= Integer.parseInt(st.nextToken())-1;
		board =new int[N][M];
		
		
			for(int j=0;j<M;j++)
			{
				st= new StringTokenizer(bf.readLine());
				int x= Integer.parseInt(st.nextToken());
				int y= Integer.parseInt(st.nextToken());
				int d= Integer.parseInt(st.nextToken());
				board[x-1][y-1]=d;
			}
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(i!=j  && board[i][j]==0)
				{
					board[i][j]=MAX;
				}
			}
		}
		
		for(int k=0;k<N;k++)
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
			
				if(i!=j)
					
				{
					board[i][j]=Math.min(board[i][j],board[i][k]+board[k][j]);
				}
			}
		}
		
		
		for(int i=0;i<N;i++)
		{
		
		
			
				answer= Math.max(answer, board[i][X]+board[X][i]);
			
		
		}
	System.out.println(answer);
	}
}