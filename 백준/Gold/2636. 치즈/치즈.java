import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[][] board;
	static int res;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		

		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
	
		int time=0;
		int res=0;
		while(true)
		{	
			res=resCheck();
			bfs(0,0);
			time++;
			//print(board);
			if(check()) break;
		}
		System.out.println(time);
		System.out.println(res);
	}
	
	public static void bfs(int x,int y)
	{
		Queue<int []> q = new LinkedList<>();
		
		boolean[][] visited= new boolean[N][M];
		
		q.add(new int[] {x,y});
		visited[x][y]=true;
		
		while(!q.isEmpty())
		{
			int[] now = q.poll();
		
			
			for(int i=0;i<4;i++)
			{
				int nx = now[0]+dx[i];
				int ny= now[1]+dy[i];
				
				if(isBoundary(nx, ny) && !visited[nx][ny])
				{
					if(board[nx][ny]==0)
					{
						q.add(new int[] {nx,ny});
						visited[nx][ny]=true;
					}
					else if(board[nx][ny]==1)
					{
						
						visited[nx][ny]=true;
					}
				}
				
			}
			
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(visited[i][j])
				{
					board[i][j]=0;
				}
			}
		}
	}
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<N && y>=0 && y<M;
	}
	public static boolean check()
	{
		boolean flag= true;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if (board[i][j]==1)
					flag=false;
			}
		}
		return flag;
	}
	public static int resCheck()
	{
		int cnt=0;
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if (board[i][j]==1)
					cnt++;
			}
		}
		return cnt;
	}
	public static void print(int[][] a)
	{
		for(int[] b:a )
		{
			System.out.println(Arrays.toString(b));
		}
	}

}