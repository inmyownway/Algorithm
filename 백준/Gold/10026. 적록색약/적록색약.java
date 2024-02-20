import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int cntR,cntG,cntB;
	static char[][] board;
	static int cntRG;
	
	
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{

	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		
		N=Integer.parseInt(bf.readLine());
		
		board = new char[N][N];
		visited = new boolean[N][N];
		
		
		for(int i =0;i<N;i++)
		{
			String str = bf.readLine();
			for(int j=0;j<N;j++)
			{
				board[i][j]=str.charAt(j);
			}
		}
		
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(!visited[i][j])
				{
					bfs(i,j,board[i][j]);
					
					if(board[i][j]=='R')
					{
						cntR+=1;
					}
					else if (board[i][j]=='G')
					{
						cntG+=1;
						
					}
					else if (board[i][j]=='B')
					{
						cntB+=1;
						
					}
					
				
				}
			}
		}

		
	
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(board[i][j]=='R') 
					board[i][j]='G';

			}
			
		}
		
		
		visited = new boolean[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
		
				
				if(!visited[i][j])
				{
				
					bfs(i,j,board[i][j]);
					if(board[i][j]=='G')
						cntRG++;
					
				}
			}
			
		}


		System.out.println(cntR+cntG+cntB+" "+(cntRG+cntB));
		
	}

	public static void bfs(int x,int y,char color)
	{
		int cnt=0;
		
		Queue<int[]> q= new LinkedList<>();
		q.add(new int[]{x,y});
		
		visited[x][y]=true;
		
		while(!q.isEmpty())
		{
			int[] now= q.poll();
			
			for(int i=0;i<4;i++)
			{
				int nx=now[0]+dx[i];
				int ny=now[1]+dy[i];
				
				if(isBoundary(nx, ny) && !visited[nx][ny] && board[nx][ny]==color)
				{
					q.add(new int[] {nx,ny});
					visited[nx][ny]=true;
					
					
					
				}
				
			}
		}


		
		
		
	}
	
	public static boolean isBoundary(int x,int y)
	{
		return x>=0&& x<N && y>=0 && y<N;
	}
}