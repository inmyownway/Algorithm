import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] board;
	static long[][][] dp;
	public static void main(String[] args) throws IOException
	{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
	
		N= Integer.parseInt(st.nextToken());
		
		board= new int[N+1][N+1];
		dp =new long[N+1][N+1][3];
		
		for(int i=1;i<N+1;i++)
		{
			
			
			st= new StringTokenizer(bf.readLine());
			
			for(int j=1;j<N+1;j++)
			{
				board[i][j]= Integer.parseInt(st.nextToken());
			}
			
			
		}
	
		
		dp[1][2][0]=1;
		
		
		 for(int i=1;i<=N;i++)
		 {
			 for(int j=2;j<=N;j++)
			 {
				 	if(i==1 &&j==2)
				 		continue;
				 	
				 	
				 	 long[] left= dp[i][j-1];
				 	long[] leftup =dp[i-1][j-1];
				 	long[] up= dp[i-1][j];
					 
				
				 	long[] cur =dp[i][j];
					  cur[0] = left[0]+left[1];
					 cur[1] = leftup[0]+leftup[1]+leftup[2];
					 if(board[i][j-1] == 1 || board[i-1][j]==1)
					 {
						 cur[1]=0;
					 }
					 cur[2] = up[1]+up[2];
					 if(board[i][j]==1)
						 {
							 
							 cur[0]=0;
							 cur[1]=0;
							 cur[2]=0;
						 }
					 
//					 if(board[i][j-1] == 1 || board[i-1][j]==1)
//					 {
//						 cur[0]=0;
//						 cur[1]=0;
//						 cur[2]=0;
//					 }
//					 else if(board[i][j]==0)
//					 {
//						 			 
//					
//					 }
//				
//					 else if(board[i][j]==1)
//					 {
//						 
//						 cur[0]=0;
//						 cur[1]=0;
//						 cur[2]=0;
//					 }
//					 
			 }
		 }
		

		System.out.println(dp[N][N][0]+dp[N][N][1]+dp[N][N][2]);

		
		
		
	}
}