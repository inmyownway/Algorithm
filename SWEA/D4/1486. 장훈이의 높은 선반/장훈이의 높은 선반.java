import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	

	
	static int N,B;
	static int[] h;
	static boolean[] v;
	static int minAnswer;
	static int maxAnswer;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());

		int testCase= Integer.parseInt(st.nextToken());
		
		for(int test=1;test<testCase+1;test++)
		{
			st= new StringTokenizer(bf.readLine());
			
		 N= Integer.parseInt(st.nextToken());
			 B = Integer.parseInt(st.nextToken());
		
			h= new int[N];
			v= new boolean[N];
			
			st= new StringTokenizer(bf.readLine());
			
			minAnswer= Integer.MAX_VALUE;
			maxAnswer= Integer.MIN_VALUE;
			
			for(int i=0;i<N;i++)
			{
				h[i]=Integer.parseInt(st.nextToken());
			}
		
			 
		dfs(0,0);

		System.out.println("#"+test+" "+(minAnswer));
		}
	
	}

	public static void dfs(int depth,int sum)
	{
		if(depth==N)
		{
	
			if(sum >= B)
			{
	
				minAnswer= Math.min(minAnswer,sum-B);
				
			}
			return;
			
		}
		
		dfs(depth+1,sum+h[depth]);
		dfs(depth+1,sum);
	}

}