import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static int N,M;
	static int[][] board;
	static boolean[][] v;
	static int answer=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		board= new int[N][M];
		for(int i=0;i<N;i++)
		{
			st= new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		v= new boolean[N][M];
		
		dfs(0,0,0);
		System.out.println(answer);
		
	}
	public static void dfs(int x,int y,int sum)
	{
		if(x==N)
		{
			answer=Math.max(answer, sum);
			return;
		}
		
        
		
		if(v[x][y]==false)
		{
			// first
			if( isBoundary(x, y-1) && isBoundary(x+1, y) && !v[x][y-1] && !v[x+1][y])
			{
				v[x][y]=true;
				v[x][y-1]=true;
				v[x+1][y]=true;
				if(y==M-1)
				{
					dfs(x+1,0,sum+(board[x][y]*2 + board[x][y-1] +board[x+1][y]));
				}
				else
				{
					dfs(x,y+1,sum+(board[x][y]*2 + board[x][y-1] +board[x+1][y]));

				}
				v[x][y]=false;
				v[x][y-1]=false;
				v[x+1][y]=false;
			}
			// second
			if( isBoundary(x, y-1) && isBoundary(x-1, y) && !v[x][y-1] && !v[x-1][y])
			{
				v[x][y]=true;

				v[x][y-1]=true;
				v[x-1][y]=true;
				if(y==M-1)
				{
					dfs(x+1,0,sum+(board[x][y]*2 + board[x][y-1] +board[x-1][y]));
				}
				else
				{
					dfs(x,y+1,sum+(board[x][y]*2 + board[x][y-1] +board[x-1][y]));

				}		v[x][y]=false;
				v[x][y-1]=false;
				v[x-1][y]=false;
			
				
			}
			
			// third
			
			if( isBoundary(x, y+1) && isBoundary(x-1, y) && !v[x][y+1] && !v[x-1][y])
			{
				v[x][y]=true;

				v[x][y+1]=true;
				v[x-1][y]=true;
				if(y==M-1)
				{
					dfs(x+1,0,sum+(board[x][y]*2 + board[x][y+1] +board[x-1][y]));
				}
				else
				{
					dfs(x,y+1,sum+(board[x][y]*2 + board[x][y+1] +board[x-1][y]));

				}		v[x][y]=false;
				v[x][y+1]=false;
				v[x-1][y]=false;
			
				
			}
			
			// fourth
			
			if( isBoundary(x, y+1) && isBoundary(x+1, y) && !v[x][y+1] && !v[x+1][y])
			{
				v[x][y]=true;

				v[x][y+1]=true;
				v[x+1][y]=true;
				if(y==M-1)
				{
					dfs(x+1,0,sum+(board[x][y]*2 + board[x][y+1] +board[x+1][y]));
				}
				else
				{
					dfs(x,y+1,sum+(board[x][y]*2 + board[x][y+1] +board[x+1][y]));

				}		v[x][y]=false;
				v[x][y+1]=false;
				v[x+1][y]=false;
			
				
			}
			
			
		}
		
	
		if(y==M-1)
		{
			dfs(x+1,0,sum);
		}
		else
		{
			dfs(x,y+1,sum);
		}
	}
	
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<N && y>=0 && y<M;
		
	}
}