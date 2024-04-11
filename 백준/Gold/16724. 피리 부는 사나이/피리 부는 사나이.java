import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static char[][] board;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static int[][] v;
	static int answer;
	static int idx;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(bf.readLine());
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		board= new char[N][M];
		v= new int[N][M];
		for(int i=0;i<N;i++)
		{
			String str= bf.readLine();
			for(int j=0;j<str.length();j++)
			{
				board[i][j]=str.charAt(j);
			}
		}

		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(v[i][j]==0)
				{
					idx++;
					bfs(i,j);
					
				}
			}
		}
		
	System.out.println(answer);
	}

	public static void bfs(int x,int y)
	{
	

		int tx= x;
		int ty = y;
		v[tx][ty]=idx;
		while(true)
		{
	
			char d= board[tx][ty];
			if(d=='U')
				tx--;
			else if(d=='D')
				tx++;
			else if(d=='R')
				ty++;
			else if(d=='L')
				ty--;
			
				

					//System.out.println(tx+" "+ty);
			if(v[tx][ty]!=0 && v[tx][ty]!=idx)
			{			

				
	
				return;
			}
			else if(v[tx][ty]==idx)
			{
				
				answer++;
				
			return;
			}
			v[tx][ty]=idx;
			
		}
	}
}