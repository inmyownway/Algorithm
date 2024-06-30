import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.omg.CORBA.INTERNAL;


public class Main {

	static int N,M;
	static int[][] graph;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		graph = new int[N][N];
		

		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(i==j)
					graph[i][j]=0;
				
				else
					graph[i][j]=10000001;
			}
		}	
		for(int i=0;i<M;i++)
		{
			st= new StringTokenizer(bf.readLine());
			int x= Integer.parseInt(st.nextToken())-1;
			int y= Integer.parseInt(st.nextToken())-1;
			
			graph[x][y]=1;
			graph[y][x]=1;
		}
		

					
			for (int k = 0; k < N; k++) {
				// 출발지
				for (int i = 0; i < N; i++) {
					//도착지
					for (int j = 0; j < N; j++) {
						graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
					}
				}
		}

		
	
	int answer= Integer.MAX_VALUE;
	int c1=0;
	int c2=0;
	for(int i=0;i<N;i++)
	{
		for(int j=0;j<N;j++)
		{
			// 치킨집 선택 
			int sum=0;
			for(int idx=0;idx<N;idx++)
			{
				if(idx != i && idx !=j)
				{
					sum+=Math.min(graph[idx][i]*2, graph[idx][j]*2);
				}
			}
			
			if(sum <answer) {
				c1=i+1;
				c2=j+1;
				answer=sum;
			}
		}
	}
	System.out.println(c1+" "+c2+" "+answer);
	}

}