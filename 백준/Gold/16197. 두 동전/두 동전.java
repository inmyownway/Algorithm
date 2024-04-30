
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static char[][] board;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static boolean[][][][] v;
	static int sx,sy,ex,ey;
	static int answer=Integer.MAX_VALUE;
	static class Coin{
		int x1;
		int y1;
		int x2;
		int y2;
		int cnt;
		public Coin(int x1, int y1, int x2, int y2, int cnt) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Coin [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", cnt=" + cnt + "]";
		}
		
		
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		board = new char[N][M];
		
		boolean f= false;
		for(int i=0;i<N;i++)
			
		{
			String str = bf.readLine();
			
				for(int j=0;j<M;j++)
				{
					board[i][j]=str.charAt(j);
					
					if(board[i][j]=='o')
					{
						if(!f)
						{
							sx=i;
							sy=j;
						
						f=true;
						}
						
						else if(f)
						{
							ex=i;
							ey=j;
						}
						board[i][j]='.';
					}
				}
		}
		
		//System.out.println(N+" "+M);
		v= new boolean[N][M][N][M];
		
		boolean a= simul();
		if(!a)
			System.out.println(-1);
		else
			System.out.println((answer+1));
	}
	public static boolean simul()
	{
	
		Queue<Coin> q = new LinkedList<>();
		q.add(new Coin(sx,sy,ex,ey,0));
		v[sx][sy][ex][ey]=true;
		boolean c=false;
		while(!q.isEmpty())
		{
			Coin now = q.poll();

			if(now.cnt==10)
				continue;
			
			
			for(int idx=0;idx<4;idx++)
			{
				int x1 = now.x1+dx[idx];
				int y1= now.y1+dy[idx];
				int x2= now.x2+dx[idx];
				int y2= now.y2+dy[idx];
				
				if(!isBoundary(x1, y1) && !isBoundary(x2, y2))
				{
					
					continue;
					
					
				}
				
				else if(isBoundary(x1, y1) && !isBoundary(x2, y2))
				{
					
				
					answer=Math.min (now.cnt,answer);
				//System.out.println(answer);
					c=true;
					break;
					
				}
				
				else if(!isBoundary(x1, y1) && isBoundary(x2, y2))
				{
					
					answer=Math.min (now.cnt,answer);

				//	System.out.println(answer);
					c=true;
					break;
					
				}
				
				if(v[x1][y1][x2][y2]==false)
				{
					if(board[x1][y1]=='#') {
						x1-=dx[idx];
						y1-=dy[idx];
					}
					
						
					if(board[x2][y2]=='#') {
						x2 -=dx[idx];
						y2-=dy[idx];
					}
					
					
					
					q.add(new Coin(x1,y1,x2,y2,now.cnt+1));
					v[x1][y1][x2][y2]=true;
					
				}
				
				
			}
		}
		return c;
		
		
 	}
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<N && y>=0 && y<M;
	}
}
