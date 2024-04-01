import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n,q,N;
	static int[][] board;
	static int[] dx = {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static int answer=0;
	static int size;

	public static void main(String[] args) throws IOException{
	
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		n= Integer.parseInt(st.nextToken());
		q= Integer.parseInt(st.nextToken());
		N= (int) Math.pow(2,n);
		board =new int[N][N];
		int[] command = new int[q];
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		st=new StringTokenizer(bf.readLine());
		for(int i=0;i<q;i++)
		{
			command[i]=Integer.parseInt(st.nextToken());
		}
		
		
		for(int level : command)
		{
			//System.out.println("level : "+level);
			//System.out.println(level);
			rotate(level);
			melt();	
			//print(board);
		}
		
		count();
		find();
		
	
		System.out.println(answer);
	System.out.println(size);
	}
	
	private static void find() {

		boolean[][] visited= new boolean[N][N];
		
		 size=0;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				int tempSize=0;
				if(visited[i][j]==false && board[i][j]>0)
				{
					
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {i,j});
					
					tempSize++;
					
					visited[i][j]=true;
					
					while(!q.isEmpty())
					{
						int[] now = q.poll();
						
						for(int dir=0;dir<4;dir++)
						{
							int nx = now[0]+dx[dir];
							int ny= now[1]+dy[dir];
							
							if(isBoundary(nx, ny) && board[nx][ny]>0 && visited[nx][ny]==false)
							{
								q.add(new int[] {nx,ny});
								visited[nx][ny]=true;
								tempSize++;
							}
						}
						
					}
					
					
					
				}
				size=Math.max(size, tempSize);
			}
		}
		
	}

	private static void count() {
	
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
				if(board[i][j]>0)
					answer+=board[i][j];
		}
		
	}

	private static void melt() {

		int[][] temp =new int[N][N];
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				int count=0;
				for(int idx=0;idx<4;idx++)
				{
					int nx = i+dx[idx];
					int ny= j+dy[idx];
					
					if(isBoundary(nx, ny) && board[nx][ny] >0)
					{
						count++;
					}
				}
				
				if(count<3)
				{
					temp[i][j]=board[i][j]-1;
					if(temp[i][j]<0)
						temp[i][j]=0;
				}
				else {
					temp[i][j]=board[i][j];
				}
			}
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				board[i][j]=temp[i][j];
			}
		}
	}

	private static void rotate(int level) {

		int[][] tempBoard =new int[N][N];
		
		int lev = (int)Math.pow(2,level);
		
		for(int i=0;i<N;i+=lev)
		{
			for(int j=0;j<N;j+=lev)
			{

			//	System.out.println("# "+i+" "+j);

							
				int[][] temp= new int[lev][lev];
			
				
				int a=0;
			
				
				for(int x=i;x<i+lev;x++)
				{				int b=0;		
					for(int y=j;y<j+lev;y++)
					{
						//System.out.println(a+" "+b);
						temp[a][b]=board[x][y];
						//System.out.println("@");
						b++;
					}	
					a++;
				}
				
				temp= r(temp);
				
				a=0;
				for(int x=i;x<i+lev;x++)
				{			int b=0;		
					for(int y=j;y<j+lev;y++)
					{
						//System.out.println(a+" "+b);
						board[x][y]=temp[a][b];
						//System.out.println("@");
						b++;
					}	
					a++;
				}
				
			}
			
		}

		
	}
	private static int[][] r(int[][] temp) {
		
		int[][] t= new int[temp.length][temp.length];
		for(int i=0;i<temp.length;i++) {
			for(int j=0;j<temp.length;j++)
			{
				t[i][j]=temp[temp.length-1-j][i];
			}
		}
		return t;
		
	}

	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<N && y>=0 && y<N;
	}
	public static void print(int[][] bboard)
	{
		for(int[] b:bboard)
		{
			System.out.println(Arrays.toString(b));
		}
		System.out.println();
	}
}