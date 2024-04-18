
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int H,N,M;
	static int[][][] board;
	static int[] dx = {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static class Tomato{
		int h;
		int x;
		int y;
		public Tomato(int h, int x, int y) {
			super();
			this.h = h;
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Tomato [h=" + h + ", x=" + x + ", y=" + y + "]";
		}
		
	}
	static Queue<Tomato> q;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		board= new int[H][N][M];
	//	System.out.println(H+" "+N+" "+M);
		q= new LinkedList<>();
		
		int initState=0;
		for(int h=0;h<H;h++)
		{
			for(int i=0;i<N;i++) {
				st= new StringTokenizer(bf.readLine());
				for(int j=0;j<M;j++)
				{
					board[h][i][j]=Integer.parseInt(st.nextToken());
					if(board[h][i][j]==1)
					{
						q.add(new Tomato(h, i, j));
					//System.out.println(h+" "+i+ " "+j);
					}
					if(board[h][i][j]==0)
						initState++;
				}
			}
		}
	
		
		int time=0;
		while(!q.isEmpty())
		{ 
			time++;
		//	System.out.println(time);
			//System.out.println(time++);
			int size= q.size();
			
//			for(int h=0;h<H;h++)
//			{
//				for(int i=0;i<N;i++) {
//					for(int j=0;j<M;j++)
//					{
//						
//						System.out.print(board[h][i][j]+" ");
//						
//					
//					}
//					System.out.println();
//				}
//				
//			}
			for(int s=0;s<size;s++)
			{
				Tomato now = q.poll();
			//	System.out.println(now);
				
				for(int i=0;i<4;i++)
				{
					int nx= now.x+dx[i];
					int ny = now.y+dy[i];
					if(isBoundary(nx, ny,now.h) && board[now.h][nx][ny]==0)
					{
						board[now.h][nx][ny]=1;
						//System.out.println(now.h+" "+nx+" "+ny);
					//	System.out.println("1");
						q.add(new Tomato(now.h, nx, ny));
						
					}
				}
				
				if(now.h-1>=0 )
				{
					if(board[now.h-1][now.x][now.y]==0)
					{
						board[now.h-1][now.x][now.y]=1;
					//	System.out.println(2);
						q.add(new Tomato(now.h-1, now.x, now.y));
					}
				}
				
				if(now.h+1<H )
				{
					if(board[now.h+1][now.x][now.y]==0)
					{//System.out.println(3);
						board[now.h+1][now.x][now.y]=1;
						q.add(new Tomato(now.h+1, now.x, now.y));
					}
				}
			}
		}
		//System.out.println(initState);
		if(initState==0)
		{
			System.out.println(0);
		}
		else
		{
			int state=0;
			for(int h=0;h<H;h++)
			{
				for(int i=0;i<N;i++) {
					for(int j=0;j<M;j++)
					{
						if(board[h][i][j]==0)
							state++;
						
					//	System.out.print(board[h][i][j]+" ");
						
					
					}
					//System.out.println();
				}
				
			}
			
			if(state>=1)
				System.out.println(-1);
			else
			{
				System.out.println(time-1);
			}
		}
		
	}
	public static boolean isBoundary(int x,int y,int h)
	{
		return x>=0 && x<N && y>=0 && y<M && h>=0 && h<H;
	}
}
