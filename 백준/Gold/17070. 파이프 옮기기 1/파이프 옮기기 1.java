import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] board;
	static boolean[][] visited;
	static int[] dx= {0,1,1};
	static int[] dy= {1,0,1};
	static int answer=0;
	// 오,위,대각
	
	public static void main(String[] args) throws IOException {
	
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		visited = new boolean[N][N];		
		
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		if(board[N-1][N-1]==1)
		{
			System.out.println(0);
		}

		else {
		bfs();
		System.out.println(answer);
		}
	}
	// 오,위,대각
	public static void bfs()
	{
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,1,0});

		
		while(!q.isEmpty())
		{
			int[] now= q.poll();
			
			int x=now[0];
			int y=now[1];
			int d= now[2];
			
			if(x==N-1 && y==N-1)
			{
				answer++;
				continue;
			}
				
			
			for(int i=0;i<3;i++)
			{
				int nx= x+dx[i];
				int ny=y+dy[i];
					
				if(isBoundary(nx, ny) && board[nx][ny]==0) {
				if(i==0 && (d== 0 ||d==2))
				{
					q.add(new int[] {nx,ny,i});
				}
				else if(i==1 && (d== 1 ||d==2))
				{
					q.add(new int[] {nx,ny,i});
				}
				else if(i==2)
				{
					if(isBoundary(x+1, y) && isBoundary(x, y+1) && board[x+1][y]==0 && board[x][y+1]==0)
					{
						q.add(new int[] {nx,ny,i});
					}
				}

					
				}
					
						
				
				}
				
			}
		}
		
		
	
		
	
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<N && y>=0 && y<N;
	}

}