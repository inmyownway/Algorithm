import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] board;
	static ArrayList<Prey> preys;
	static Shark shark;
	static boolean[][] v;
	static int[] dx= {-1,0,0,1};
	static int[] dy= {0,-1,1,0};
	static class Shark{
		int x;
		int y;
		int size;
		int cnt;
		public Shark(int x, int y, int size, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", size=" + size + ", cnt=" + cnt + "]";
		}
		
		
		
	}
	static class Prey implements Comparable<Prey>{
		int x;
		int y;
		int distance;
		public Prey(int x, int y, int distance) {
			super();
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
		@Override
		public String toString() {
			return "prey [x=" + x + ", y=" + y + ", distance=" + distance + "]";
		}
		@Override
		public int compareTo(Prey o) {
	
			if(this.x != o.x)
			{
				return Integer.compare(this.x, o.x);
			}
			
		
				return Integer.compare(this.y, o.y);
		
			

		}
		
		
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N= Integer.parseInt(st.nextToken());
		
	
		board = new int[N][N];
		for(int i=0;i<N;i++)
		{
			st= new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
				if(board[i][j]==9)
				{
					shark = new Shark(i, j, 2, 0);
					board[i][j]=0;
				}
			}
		}
		
		
		int time=0;
		
		while(true)
		{
			
			Prey prey = searchPrey();
			//System.out.println("처음 prey "+prey);
			
			if(prey.x == -1 && prey.y==-1)
			{
				break;
			}
			
	
			shark.x=prey.x;
			shark.y=prey.y;
			time+=prey.distance;
			
			board[prey.x][prey.y]=0;
			shark.cnt++;
			
			if(shark.cnt==shark.size)
			{
				shark.size++;
				shark.cnt=0;
			}
//			for(int[]b:board)
//			{
//				System.out.println(Arrays.toString(b));
//				
//			}	System.out.println(shark);
//			System.out.println(time);
//			System.out.println();
		
		}
		System.out.println(time);
		

	}
	
	public static Prey searchPrey() 
	{
		Queue<int[] > q= new LinkedList<>();
		preys = new ArrayList<>();
		
		v= new boolean[N][N];
		
		q.add(new int[] {shark.x,shark.y,0});
		v[shark.x][shark.y]=true;
		
		while(!q.isEmpty())
		{
			
			int size= q.size();
			for(int s=0;s<size;s++)
			{
			
				int[] now= q.poll();
				//System.out.println(Arrays.toString(now));
				for(int idx=0;idx<4;idx++)
				{
					int nx= now[0]+dx[idx];
					int ny= now[1]+dy[idx];
					//System.out.println(nx+" "+ny);
					if(isBoundary(nx, ny) && !v[nx][ny] )
					{
						// 먹이있음
						if(board[nx][ny]>=1 && shark.size> board[nx][ny])
						{
							preys.add(new Prey(nx, ny, now[2]+1));
							v[nx][ny]=true;				
							
						}
						else if(board[nx][ny]<=shark.size)
						{
							q.add(new int[] {nx,ny,now[2]+1});
							v[nx][ny]=true;
						}
						
						
					}
				}

			}
				
			if(preys.size()>=1)
			{
				Collections.sort(preys);
					return preys.get(0);
			}

			
		}
		return new Prey(-1, -1,-1);
	}
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<N && y>=0 && y<N;
	}
}