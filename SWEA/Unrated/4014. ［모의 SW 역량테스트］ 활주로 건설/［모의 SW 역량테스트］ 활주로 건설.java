import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N,X;
	static int[][] board;
	static int[] road;
	static int answer;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testCase= Integer.parseInt(bf.readLine());
		
		for(int t=1;t<testCase+1;t++)
		{
			
			st= new StringTokenizer(bf.readLine());
			N=Integer.parseInt(st.nextToken());
			X=Integer.parseInt(st.nextToken());
			board= new int[N][N];
			answer=0;
			
			for(int i=0;i<N;i++)
			{
				st=new StringTokenizer(bf.readLine());
				for(int j=0;j<N;j++)
				{
					board[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++)
			{
				 road = new int[N];
				for(int j=0;j<N;j++)
				{
					road[j]=board[i][j];
			
				}
				check();
					
				for(int j=0;j<N;j++)
				{
					road[j]=board[j][i];
				}
				check();
			}
			System.out.println("#"+t+" "+answer);
			
		}
	}
	public static void check()
	{	boolean flag= true;
		boolean construct= true;
		boolean[] visited= new boolean[N];
		for(int i=0;i<N-1;i++)
		{
			if(road[i]!=road[i+1])
			{
				construct=false;
			}
		}
		for(int i=0;i<N-1;i++)
		{
			
		
			
			
		
			if(road[i]>road[i+1])
			{
				//System.out.println(road[i]+" "+road[i+1]);
				for(int j=0;j<X;j++)
				{
					if(i+1+j <N && (road[i]-road[i+1+j]==1) && visited[i+1+j]==false)
					{
						visited[i+1+j]=true;
						continue;
					}
					else
					{
						flag=false;
						
						break;
					}
				}
			}
			else if(road[i+1]>road[i])
			{
				for(int j=0;j<X;j++)
				{
					if(i-j >=0 && (road[i+1]-road[i-j]==1) && visited[i-j]==false)
					{
						visited[i-j]=true;
						continue;
					}
					else
					{
						flag=false;
						break;
					}
				}
			}
			
						
		}
		
		if(flag)
			{
		//	System.out.println(Arrays.toString(road));
				answer++;
			}

		
	}

}