import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static final int N=5;
	static int[][][] board;
	static int[] rotateCnt;
	static int[][][] copyBoard;
	static int[] orderIdx;
	static boolean[] v;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static int[] hx= {1,-1};
	static int answer=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
	
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		board= new int[5][5][5];
		
		for(int h=0;h<N;h++)
		{
			for(int i=0;i<N;i++)
			{
				st= new StringTokenizer(bf.readLine());
				for(int j=0;j<N;j++)
				{
					board[h][i][j]=Integer.parseInt(st.nextToken());
				}
			}
		}
		
		
		
		for(int a=0;a<N;a++)
		{
			for(int b=0;b<N;b++)
			{
				for(int c=0;c<N;c++)
				{
					for(int d=0;d<N;d++)
					{
						for(int e=0;e<N;e++)
						{
							rotateCnt = new int[] {a,b,c,d,e};
							
							simulation(rotateCnt);
						}
					}
				}
			}
		}
		if(answer==Integer.MAX_VALUE)
			answer=-1;
		
			System.out.println(answer);
		
	}
	private static void simulation(int[] rotateCnt) {
	
		copyBoard= new int[5][5][5];
		for(int h=0;h<N;h++)
		{
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					copyBoard[h][i][j]=board[h][i][j];
				}
			}
		}
		
		for(int idx= 0; idx<rotateCnt.length;idx++)
		{
			int cnt = rotateCnt[idx];
			
			
			rotate(cnt,idx);
			
		}
		
		// 다 돌려짐 
		// 이제 순서 조정 
		orderIdx= new int[] {0,1,2,3,4};
		v= new boolean[5];
		perm(0);
		
	}
	public static void perm(int depth)
	
	{
		if(depth==N)
		{
			// 만들어짐 
			
			// 순서 재조정 해야함 
			
			int[][][] finalBoard = new int[5][5][5];
			
			int idx=0;
			//System.out.println(Arrays.toString(orderIdx));
			for(int h=0;h<N;h++)
			{
				for(int i=0;i<N;i++)
				{
					for(int j=0;j<N;j++)
					{
						finalBoard[h][i][j]=copyBoard[orderIdx[h]][i][j];
					}
				}
			}
			
			int t= bfs(finalBoard);
			
			
			if(t!=-1)
				{
					answer= Math.min(answer, t);
			
				}	
			return;
		}
		
		for(int i=depth;i<N;i++)
		{
			swap(i,depth);
			perm(depth+1);
			swap(i,depth);
		}
		
	}
	
	private static int bfs(int[][][] finalBoard) {
	
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,0,0});
		
		if(finalBoard[0][0][0]==0)
			return -1;
		
		
		
		boolean[][][] visited= new boolean[N][N][N];
		visited[0][0][0]=true;
		while(!q.isEmpty())
		{
			int[] now = q.poll();
			
			int h= now[0];
			int x= now[1];
			int y= now[2];
			int cnt =now[3];
			
			if(x==4 && y==4 && h==4)
			{
				return cnt;
			}
			
			
			for(int idx=0;idx<4;idx++)
			{
				int nx= x+dx[idx];
				int ny= y+dy[idx];
				
				if(isBoundary(nx, ny) && finalBoard[h][nx][ny]==1 && visited[h][nx][ny]==false)
				{
					visited[h][nx][ny]=true;
					q.add(new int[] {h,nx,ny,cnt+1});
					
				}
			}
			
			for(int idx=0;idx<2;idx++)
			{
				int nh = h+hx[idx];
				if(nh>=0 && nh<N && finalBoard[nh][x][y]==1 && visited[nh][x][y]==false)
				{
					visited[nh][x][y]=true;
					q.add(new int[] {nh,x,y,cnt+1});
				}
			}
			
			
		}
		
		return -1;

	}
	public static void swap(int x,int y)
	{
		int temp= orderIdx[x];
		orderIdx[x]=orderIdx[y];
		orderIdx[y]=temp;
	}
	private static void rotate(int cnt, int idx) 
	{
		// idx번째 사각형 
		// 시계방향으로 cnt 만큼 돌리기
		
		// 1 2 3    		7 4 1
		// 4 5 6  ->  8 5 2
		// 7 8 9       9 6  3
		for(int i=0;i<cnt;i++)
		{
		 int[][] tempBoard = new int[N][N];//copy(idx);
			for(int x=0;x<N;x++)
			{
				for(int y=0;y<N;y++)
				{
						tempBoard[x][y]=copyBoard[idx][N-1-y][x];
				}
			}
			// copyBoard 에 temp 다시넣기 
			
			for(int a=0;a<N;a++)
			{
				for(int b=0;b<N;b++)
				{
					copyBoard[idx][a][b]=tempBoard[a][b];
				}
			}
			
			
		}
		
		
	}
	private static int[][] copy(int idx)
	{
		int[][] t= new int[N][N];
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				t[i][j]=board[idx][i][j];
			}
		}
		return t;
	}
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<5 && y>=0 && y<5;
	}
}