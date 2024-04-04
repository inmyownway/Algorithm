import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] board;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testCase= Integer.parseInt(bf.readLine());
		
	
		for(int test=1;test<testCase+1;test++)
		{
			
			N= Integer.parseInt(bf.readLine());
			board= new int[N][N];
			int[][] temp = new int[N][N];
			
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					temp[i][j]=Integer.MAX_VALUE;
				}
			}
			temp[0][0]=0;
			for(int i=0;i<N;i++)
			{
				
				String str= bf.readLine();
				for(int j=0;j<str.length();j++)
				{
					board[i][j]=str.charAt(j)-'0';
		
				}
				
				
			}
			
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] {0,0});
			boolean[][] v= new boolean[N][N];
			
			v[0][0]=true;
			
			while(!q.isEmpty())
			{
				int[] now= q.poll();
				
				
				for(int i=0;i<4;i++)
				{
					int nx= now[0]+dx[i];
					int ny= now[1]+dy[i];
				
					if(isBoundary(nx, ny) && v[nx][ny]==false)
					{
						if(temp[now[0]][now[1]] + board[nx][ny] < temp[nx][ny])
						{
							 temp[nx][ny]=temp[now[0]][now[1]] + board[nx][ny] ;
							 q.add(new int[] {nx,ny});
						}
					}
					
				}
			
				
			}
			System.out.println("#"+test+" "+temp[N-1][N-1]);
		}

	}
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<N && y>=0 &&y<N;
	}

}