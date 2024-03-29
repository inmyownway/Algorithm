import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;




public class Main {

	static int N,M;
	static int[][] board;
	static int EX,EY,ED;
	public static class Robot {
		int x;
		int y;
		int d;
		int t;
		public Robot(int x, int y, int d, int t) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.t = t;
		}
		@Override
		public String toString() {
			return "Robot [x=" + x + ", y=" + y + ", d=" + d + ", t=" + t + "]";
		}
		
	}
	static boolean[][] v;
	static int[] dx= {0,0  ,0 ,1,-1};
	static int[] dy= {0,1,-1  ,0,0};
	static Queue<Robot> q;
	static int MAX = Integer.MAX_VALUE;
	static int answer;
	public static void main(String[] args) throws IOException
	{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
	
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		board =new int[M][N];
		v= new boolean[M][N];
		
		
		for(int i=0;i<M;i++)
		{
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		

		q= new LinkedList<>();
		
		st= new StringTokenizer(bf.readLine());
		int a= Integer.parseInt(st.nextToken())-1;
		int b= Integer.parseInt(st.nextToken())-1;
		int d = Integer.parseInt(st.nextToken());
		

		v[a][b]=true;
		q.add(new Robot(a,b,d,0));
		
		
		st= new StringTokenizer(bf.readLine());
		
		EX= Integer.parseInt(st.nextToken())-1;
		EY= Integer.parseInt(st.nextToken())-1;
		ED= Integer.parseInt(st.nextToken());
		
		//System.out.println("end "+ex+" "+ey+" "+ed);
		bfs();
		
		
		
			
			
		/*while(true)
		{*/
			// cur = q.poll
			// if(cur.t) >max cotinue;
			
			// 로봇 이동 4방향
			// 도착시 check
			
			// check
			// 같은지확인, 방향 돌려가면서 확인
			// 
			
			System.out.println(MAX);
		
	}
	public static void bfs()
	{
		
		boolean[][] temp = new boolean[M][N];
		
		
		while(!q.isEmpty())
		{
			
			for(int i=0;i<M;i++)
			{
				for(int j=0;j<N;j++)
				{
					temp[i][j]=v[i][j];
				}
			}
			
			
			int s= q.size();
		//System.out.println("########### " +MAX);
			for(int i=0;i<s;i++)
			{
				Robot cur = q.poll();
				
				check(cur.x,cur.y,cur.d,cur.t);
				
				if( cur.t>MAX)
				{
					continue;
				}
			//System.out.println(cur);
				int nx;
				int ny;
				int dir;
				
				
				
				// 원래방향으로 직진
				
				nx=cur.x;
				ny=cur.y;
				for(int j=0;j<3;j++)
				{
					nx+=dx[cur.d];
					ny+=dy[cur.d];
					if(!isBoundary(nx,ny)|| board[nx][ny]==1)
						break;
					
					check(nx,ny,cur.d,cur.t+1);
				
				}
				nx=cur.x;
				ny=cur.y;
				for(int j=0;j<3;j++)
				{
					nx+=dx[cur.d];
					ny+=dy[cur.d];
					
	
					if(isBoundary(nx, ny) && board[nx][ny]==0 && !temp[nx][ny])
					{
							if(check(nx,ny,cur.d,cur.t+1)==false)
							{
								v[nx][ny]=true;
								q.add(new Robot(nx, ny, cur.d, cur.t+1));
							}
					}
					else
					{
						break;
					}
					
					
				}
			
				// 왼쪽으로 
			
				nx=cur.x;
				ny=cur.y;
				dir = turnLeft(cur.d);
				
				for(int j=0;j<3;j++)
				{
					nx+=dx[dir];
					ny+=dy[dir];
					if(!isBoundary(nx,ny)|| board[nx][ny]==1)
						break;
					
					check(nx,ny,dir,cur.t+2);
				
				}
				
				
				nx=cur.x;
				ny=cur.y;
				for(int j=0;j<3;j++)
				{
					nx+=dx[dir];
					ny+=dy[dir];
					
					if(isBoundary(nx, ny) && board[nx][ny]==0 && !temp[nx][ny])
					{
							if(check(nx,ny,dir,cur.t+2)==false)
							{
								v[nx][ny]=true;
								q.add(new Robot(nx, ny, dir, cur.t+2));
							}
					}
					else 
					{
						break;
					}
					
				}
				
				// 오른쪽
				nx=cur.x;
				ny=cur.y;
				dir = turnRight(cur.d);
				
				for(int j=0;j<3;j++)
				{
					nx+=dx[dir];
					ny+=dy[dir];
					if(!isBoundary(nx,ny)|| board[nx][ny]==1)
						break;
					
					check(nx,ny,dir,cur.t+2);
				
				}
				
				
				nx=cur.x;
				ny=cur.y;
				
				for(int j=0;j<3;j++)
				{
					nx+=dx[dir];
					ny+=dy[dir];
					
					if(isBoundary(nx, ny) && board[nx][ny]==0 && !temp[nx][ny])
					{
							if(check(nx,ny,dir,cur.t+2)==false)
							{
								v[nx][ny]=true;
								q.add(new Robot(nx, ny, dir, cur.t+2));
							}
					}
					else {
						break;
					}
					
				}
				
				
				// 반대쪽
				
				
				nx=cur.x;
				ny=cur.y;
				dir = turnOpp(cur.d);
				
				for(int j=0;j<3;j++)
				{
					nx+=dx[dir];
					ny+=dy[dir];
					if(!isBoundary(nx,ny)|| board[nx][ny]==1)
						break;
					
					check(nx,ny,dir,cur.t+3);
				
				}
				
				
				nx=cur.x;
				ny=cur.y;
		
				for(int j=0;j<3;j++)
				{
					nx+=dx[dir];
					ny+=dy[dir];
					
					if(!isBoundary(nx, ny) || board[nx][ny]=='1')
						break;
					
					if(isBoundary(nx, ny) && board[nx][ny]==0 && !temp[nx][ny])
					{
							if(check(nx,ny,dir,cur.t+3)==false)
							{
								v[nx][ny]=true;
								q.add(new Robot(nx, ny, dir, cur.t+3));
							}
					}
					else
					{
						break;
					}
					
				}
				
			}
		}
	}
	private static boolean check(int x, int y,int d,int t)
	{
		
		
		//System.out.println(x+" "+y+" "+" "+d+" "+t);
		if(x== EX && y== EY && d == ED)
		{
			
			MAX=Math.min(t, MAX);
			return true;
		}
		else if(x== EX && y== EY && d != ED)
		{
			if(ED==turnOpp(d))
			{
				MAX=Math.min(t+2, MAX);
			}
			else if(turnLeft(d)==ED || turnRight(d)==ED)
			{
				MAX=Math.min(t+1, MAX);

			}
			return true;
		}
		return false;
	}
	
	
	
	private static int turnOpp(int d) {

		if(d==1)
			return 2;
		
		else if(d==2)
			return 1;
		
		else if(d==3)
			return 4;
		
		else 
			return 3;
	}
	private static int turnLeft(int d) {

		if(d==1)
			return 4;
		else if(d==2)
		{
			return 3;
		}
		else if(d==3)
		{
			return 1;
		}
		else 
			return 2;
			}
	private static int turnRight(int d) {

		if(d==1)
			return 3;
		
		else if(d==2)
			return 4;
		
		else if(d==3)
			return 2;
		
		else 
			return 1;
		
	}
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<M && y>=0 && y<N;
	}
}