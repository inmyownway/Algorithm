import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
	static int M,N;
	static int[][] board;
	static int[][] dp;
	static int answer;
	static int[] dx = {0,1,-1,0};
	static int[] dy = {1,0,0,-1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		

		dp= new int[M][N];
				board= new int[M][N];
		for(int i=0;i<M;i++)
		{
			for(int j=0;j<N;j++)
			{
				dp[i][j]=-1;
			}
		}
		for(int i=0;i<M;i++) {
			st= new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
				
			}
		}
		System.out.println(dfs(0,0));
		
		
	}

	
	public static int dfs(int x,int y)
	{
		if(x==M-1 && y==N-1) 
		{
			
			return 1;
		}
		if(dp[x][y]!=-1)
		{
			return dp[x][y];
		}
		dp[x][y]=0;
		for(int i=0;i<4;i++)
		{
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(isBoundary(nx, ny) && (board[x][y]>board[nx][ny]))
			{

		
				dp[x][y] += dfs(nx, ny);
			}
			
		}
		return dp[x][y];
	}
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<M && y>=0&& y<N;
	}
}