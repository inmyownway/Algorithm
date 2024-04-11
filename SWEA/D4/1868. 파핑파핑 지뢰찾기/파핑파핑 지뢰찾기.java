import java.io.*;
import java.util.*;





public class Solution {

	static int N;
	static char[][] board;
	static boolean[][] v;
	static int[] dx= {0,0,-1,1 ,1,1,-1,-1};
	static int[] dy= {1,-1,0,0 ,1,-1,1,-1};
	static int answer;
	public static class Point implements Comparable<Point>{
		int x;
		int y;
		int cnt;
		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Integer.compare(o.cnt,this.cnt);
		}
		
		
		
	}
	static ArrayList<Point> point;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
	
		
		int testCase= Integer.parseInt(bf.readLine());
		
		for(int t=1;t<testCase+1;t++)
		{
			
			N= Integer.parseInt(bf.readLine());
			board= new char[N][N];
			v= new boolean[N][N];
			answer=0;
			point = new ArrayList<>();
			
	
			for(int i=0;i<N;i++)
			{
				String str= bf.readLine();
				for(int j=0;j<str.length();j++)
				{
					board[i][j]=str.charAt(j);
					if(board[i][j]=='*')
						v[i][j]=true;
				}
			}
			
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					
					boolean flag= true;
					int sum=0;
					if(board[i][j]=='.')
					{
						
						for(int idx=0;idx<8;idx++)
						{
							int nx= i+dx[idx];
							int ny= j+dy[idx];
							
							if(isBoundary(nx, ny) && board[nx][ny]=='*')
							{
								flag=false;
							}
							else if(isBoundary(nx, ny) && board[nx][ny]=='.'){
								sum++;
							}
						}
						if(flag)
						{
							point.add(new Point(i,j,sum));
						}
					}
				
				
				}
			}

			Collections.sort(point);
			
			// 많은거 부터 클릭 
			
			for(Point p : point)
			{
				int x= p.x;
				int y= p.y;
				
				if(!v[x][y])
				{
					
					bfs(x,y);
				answer++;
				}
			}
			
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(!v[i][j])
						answer++;
				}
			}
			
			
			System.out.println("#"+t+" "+answer);
		}
		
		
		
	}
	public static void bfs(int x,int y)
	{
		v[x][y]=true;
		
		Queue<int[]> q= new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty())
		{
			int[] now = q.poll();

			boolean flag= true;

				for(int idx=0;idx<8;idx++)
				{
					int nx= now[0]+dx[idx];
					int ny= now[1]+dy[idx];
					
					if(isBoundary(nx, ny) && board[nx][ny]=='*' )
					{
						// 주변에 지뢰있음
						flag= false;
						
					}
				
				
				}
				
				// 주변에 지뢰없음 
				if(flag)
				{
					for(int idx=0;idx<8;idx++)
					{
						int nx= now[0]+dx[idx];
						int ny= now[1]+dy[idx];
						
						if(isBoundary(nx, ny) && board[nx][ny]=='.' && !v[nx][ny] )
						{
							q.add(new int[] {nx,ny});
							v[nx][ny] =true;
							
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