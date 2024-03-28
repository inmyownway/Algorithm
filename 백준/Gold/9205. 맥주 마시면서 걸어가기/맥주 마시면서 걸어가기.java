import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {

	public static void main(String[] args) throws IOException{
		   
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;

		
		int testCase= Integer.parseInt(bf.readLine());
		
		for(int t=0;t<testCase;t++)
		{
		int n= Integer.parseInt(bf.readLine());
		
		st= new StringTokenizer(bf.readLine());
		
		int hx = Integer.parseInt(st.nextToken());
		int hy= Integer.parseInt(st.nextToken());
		
		int[][] board = new int[n+2][n+2];
		
		ArrayList<int[]> arr =new ArrayList<>();
		
		arr.add(new int[]{hx,hy});
		
		for(int i=0;i<n;i++)
		{
			st= new StringTokenizer(bf.readLine());
			
			int x= Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			
			arr.add(new int[] {x,y});
		}
		st= new StringTokenizer(bf.readLine());
		int x= Integer.parseInt(st.nextToken());
		int y= Integer.parseInt(st.nextToken());
		
		arr.add(new int[] {x,y});
		
		int N= n+2;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				
				if(i!=j)
				{
				int[] to = arr.get(i);
				int[] from = arr.get(j);
				
				int num= Math.abs(to[0]-from[0])+Math.abs(to[1]-from[1]);
				
				if(num >1000)
				{
					board[i][j]=Integer.MAX_VALUE/4;
				}
				else
				{
					board[i][j]=num;
				}
				
				}
			}
		}
		
		
	
		
		for(int k=1;k<N-1;k++)
		{
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(i!=j)
					{
						if(board[i][j] > board[i][k]+board[k][j])
						{board[i][j] = board[i][k]+board[k][j];
							
						}
					}
			
				}
				
			}
		}
		

		if(board[0][N-1] != Integer.MAX_VALUE/4)
		{
			System.out.println("happy");
		}
		else
		{
			System.out.println("sad");
		}
	}
	}

}