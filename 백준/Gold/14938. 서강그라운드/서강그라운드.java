import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N,M,r;
	static int[][] board;
	static int[] item;
;
	public static void main(String[] args) throws IOException {
	

		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		r= Integer.parseInt(st.nextToken());
		
		
		board= new int[N][N];
		item = new int[N];
		st= new StringTokenizer(bf.readLine());
		
		for(int i=0;i<N;i++)
		{
			item[i]=Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=0;i<r;i++)
		{
			st= new StringTokenizer(bf.readLine());
			int x= Integer.parseInt(st.nextToken())-1;
			int y= Integer.parseInt(st.nextToken())-1;
			int d= Integer.parseInt(st.nextToken());
			
			board[x][y]=d;
			board[y][x]=d;		
	
		}
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(i!=j && board[i][j]==0)
				{
					board[i][j]=Integer.MAX_VALUE/4;
					
				}
			}
		}
		
		for(int k=0;k<N;k++)
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(i!=j)
				{
					board[i][j]=Math.min(board[i][j], board[i][k]+board[k][j]);
				}
			}
		}
		
		
//		
//		for(int[] b: board)
//		{
//			System.out.println(Arrays.toString(b));
//		}
//		System.out.println();

		int answer= Integer.MIN_VALUE;
		//System.out.println(Arrays.toString(item));
		for(int i=0;i<N;i++)
		{
			int cnt= item[i];
			
			for(int j=0;j<N;j++)
			{
				if(i!=j && board[i][j]<=M )
				{
					cnt+=item[j];
				}
			}
			answer= Math.max(answer,cnt);
			
		}
		System.out.println(answer);
	}

}