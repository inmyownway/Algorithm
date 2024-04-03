import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {

	static int N,M;
	static int[][] board;
	static int sx,sy;
	static boolean[][][] isVisted;
	static Queue<Person>q;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int K;
	public static class Person
	{
		int x;
		int y;
		int cnt;
		int use;
		public Person(int x, int y, int cnt,int use) {
			super();
			this.x = x;
			this.y = y;
			this.cnt=cnt;
			this.use = use;
		}
		@Override
		public String toString() {
			return "Person [x=" + x + ", y=" + y + ", cnt=" + cnt + ", use=" + use + "]";
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		
		board= new int[N][M];
		
		for(int i=0;i<N;i++)
		{
			String str= bf.readLine();
			for(int j=0;j<str.length();j++)
			{
				board[i][j]= str.charAt(j)-'0';
			}
			
		}
		isVisted = new boolean[N][M][K+1];

		int answer= bfs();
		System.out.println(answer);
	}
	private static int bfs() {
		
		q= new LinkedList<>();
		q.add(new Person(0,0,0,0));
		isVisted[0][0][0]=true;
		
		
		while(!q.isEmpty())
		{
	
				Person p =q.poll();
			
			if (p.x==N-1 && p.y==M-1)
			{
				return p.cnt+1;
			}
			
			for(int i=0;i<4;i++)
			{
				int nx= p.x+dx[i];
				int ny= p.y+dy[i];
				
				if(isBoundary(nx, ny))
				{
					
					 if (board[nx][ny]==0 && !isVisted[nx][ny][p.use])
					{
						isVisted[nx][ny][p.use]=true;
						q.add(new Person(nx,ny,p.cnt+1,p.use));
					}
					 else
					 {
						 if(p.use<K && !isVisted[nx][ny][p.use+1] )
						 {
							 isVisted[nx][ny][p.use+1]=true;
								q.add(new Person(nx,ny,p.cnt+1,p.use+1));
						 }
					 }
						
				}
			}
		
		}
			
		
		return -1;
	}
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<N && y>=0 && y<M;
	}

}