import java.io.*;
import java.util.*;

class Main {
	static int[] dx={0,0,-1,1};
	static int[] dy={1,-1,0,0};
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
		N= Integer.parseInt(st.nextToken());
		
		int[][] board= new int[N][N];
		
		for(int i=0;i<N;i++)
		{
			st= new StringTokenizer(bf.readLine());
			
			for(int j=0;j<N;j++)
			{
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int day=0;
		while(true)
		{
			boolean flag= true;
			for(int i=0;i<N;i++)
			{
			
			
				for(int j=0;j<N;j++)
			
				{
					if(board[i][j]!=0)
					{

							flag=false;
						break;	
					}
				}
			
			}
			if(flag)
				{
					System.out.println(day);
				break;
				}
			day++;
			
			int[][] temp= new int[N][N];
			
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					int cnt=0;
					for(int idx=0;idx<4;idx++)
					{
						int nx=i+dx[idx];
						int ny=j+dy[idx];
						if(isBoundary(nx,ny) && board[nx][ny]==0)
						{
							cnt++;
						}
					}
					temp[i][j]=cnt;
				}
			}
			
				for(int i=0;i<N;i++)
				{
				for(int j=0;j<N;j++)
				{
					int r = board[i][j]-temp[i][j];
					if(r<=0){
						r=0;
					}
					board[i][j]=r;
				}
				}
		}
		
	}
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<N && y>=0 && y<N;
	}
}