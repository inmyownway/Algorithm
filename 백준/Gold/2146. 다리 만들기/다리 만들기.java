import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] board;
	static boolean[][] numV;
	static int idx;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static int answer=Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N= Integer.parseInt(bf.readLine());
		
		board= new int[N][N];
		
		numV= new boolean[N][N];
		
		for(int i=0;i<N;i++)
		{
			st= new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		// 처음 넘버 각각 초기화
		
		idx=2;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(board[i][j]==1)
				{
					board[i][j]=idx;
					numBfs(i,j);
					idx++;
				}
			}
		}
		
	
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				
				if(board[i][j]!=0)
					
					bfs(i,j);
			
			}
		}
//		for(int[]b:board)
//		{
//			System.out.println(Arrays.toString(b));
//		}
		System.out.println(answer);
		
	}
	public static void bfs(int x,int y)
	{
		int num= board[x][y];
		boolean[][] v= new boolean[N][N];
			
		v[x][y]=true;
		
		Queue<int[] > q = new LinkedList<>();
		
		q.add(new int[] {x,y,0});
		
		while(!q.isEmpty())
		{
			int[] now =q.poll();
		
			for(int i=0;i<4;i++)
			{
				int nx = now[0]+dx[i];
				int ny= now[1]+dy[i];
				
				if(isBoundary(nx, ny) && !v[nx][ny])
				{
					if(board[nx][ny]==0)
					{
						v[nx][ny]=true;
						q.add(new int[] {nx,ny,now[2]+1});
					}
					else if(board[nx][ny]!= num && board[nx][ny]!=0)
					{
						
						answer=Math.min(answer, now[2]);
						
						return;
					}
					
				}
			}
			
		}
	}
	public static void numBfs(int x,int y)
	{
		boolean[][] v= new boolean[N][N];
		
		v[x][y]=true;
		
		Queue<int[] > q = new LinkedList<>();
		
		q.add(new int[] {x,y});
		
		while(!q.isEmpty())
		{
			int[] now =q.poll();
			
			for(int i=0;i<4;i++)
			{
				int nx = now[0]+dx[i];
				int ny= now[1]+dy[i];
				
				if(isBoundary(nx, ny) && board[nx][ny]==1)
				{
					board[nx][ny]=idx;
					q.add(new int[] {nx,ny});
				}
			}
			
		}
	}
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<N && y>=0 && y<N;
	}

}