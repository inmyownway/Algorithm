import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int testCase= Integer.parseInt(bf.readLine());
		
		for(int test=1;test<testCase+1;test++)
		{
			
			int N = Integer.parseInt(bf.readLine());
			int M= Integer.parseInt(bf.readLine());
			
			int[][] board = new int[N][N];
			int[][] up = new int[N][N];
			int[] l =new int[N];
			for(int i=0;i<M;i++)
			{
				st= new StringTokenizer(bf.readLine());
				
				int a= Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());
				
				board[b-1][a-1]=1;
				up[a-1][b-1]=1;
				
			}
			
		
	
			for(int i=0;i<N;i++)
			{
				boolean[] v = new boolean[N];
				v[i]=true;
				
				Queue<Integer> q= new LinkedList<>();
				q.add(i);
				int cnt=0;
				while(!q.isEmpty())
				{
					
					int current = q.poll();
					for(int j=0;j<N;j++)
					{
						if(board[current][j]==1 && v[j]==false)
						{
							q.add(j);
							cnt++;
							v[j]=true;
							
						}
					}
				}
				l[i]=cnt;
			}
			
			
			for(int i=0;i<N;i++)
			{
				boolean[] v = new boolean[N];
				v[i]=true;
				
				Queue<Integer> q= new LinkedList<>();
				q.add(i);
				int cnt=0;
				while(!q.isEmpty())
				{
					
					int current = q.poll();
					for(int j=0;j<N;j++)
					{
						if(up[current][j]==1 && v[j]==false)
						{
							q.add(j);
							cnt++;
							v[j]=true;
							
						}
					}
				}
				l[i]+=cnt;
			}

			int answer=0;
			for(int i=0;i<N;i++)
			{
				if(l[i]==N-1)
					answer++;
			}
			
			System.out.println("#"+test+" "+answer);
		}

	}

}