import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;import javax.crypto.spec.IvParameterSpec;

public class Solution {
	static int N,K;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx= new int[] {0,0,-1,1};
	static int[] dy= new int[] {1,-1,0,0};
	static int answer;
	public static void main(String[] args) throws IOException
	{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st;
		
		int testCase= Integer.parseInt(bf.readLine());
		
		for(int tc=1;tc<=testCase;tc++)
		{
			
			st= new StringTokenizer(bf.readLine());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			int top=0;
			board= new int[N][N];
			visited = new boolean[N][N];
			for(int i=0;i<N;i++)
			{
				st=new StringTokenizer(bf.readLine());
				for(int j=0;j<N;j++)
				{
					board[i][j]=Integer.parseInt(st.nextToken());
					top=Math.max(top, board[i][j]);
				}
				
			}
			
			answer=Integer.MIN_VALUE;
			// 최대값이면 시작
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(board[i][j]==top)
					{
						visited[i][j]=true;
						dfs(i,j,1,board[i][j],K);
						visited[i][j]=false;
						
						
					}
				}
			}
			
			System.out.println("#"+tc+" "+answer);
		}
		
	}
	public static void dfs(int x,int y,int length,int height,int k)
	{
		answer=Math.max(answer, length);
		
		
		for(int i=0;i<4;i++)
		{
			int nx=x+dx[i];
			int ny=y+dy[i];
			
			if(!isBoundarty(nx, ny) || visited[nx][ny]) continue;
			
			// 깍을수 없음
			if(k==0)
			{
				if(height>board[nx][ny])
				{	visited[nx][ny]=true;
					dfs(nx,ny,length+1,board[nx][ny],k);
					visited[nx][ny]=false;
				}
				
			}
			else 
			{ 
				if(height>board[nx][ny])
				{	visited[nx][ny]=true;
					dfs(nx,ny,length+1,board[nx][ny],k);
					visited[nx][ny]=false;
				}
				else if(height>board[nx][ny]-K)
				{
					visited[nx][ny]=true;
					dfs(nx,ny,length+1,board[x][y]-1,0);
					visited[nx][ny]=false;
				}
				
			}
			
		}
		
		
		
	}
	public static boolean isBoundarty(int x,int y)
	{
		return x>=0&&x<N&&y>=0&&y<N;
		
	}
}