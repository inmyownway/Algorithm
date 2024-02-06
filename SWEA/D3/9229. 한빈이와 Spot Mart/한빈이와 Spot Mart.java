import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N,M;

	static int[] w;
	static int c;
	static int maxNum;
	
	public static void main(String[] args) throws IOException{

		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int testcase=Integer.parseInt(bf.readLine());
		
		for(int i=1;i<testcase+1;i++)
		{
			st= new StringTokenizer(bf.readLine());
			
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			
			w= new int[N];
			
			st= new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
			{
				w[j]=Integer.parseInt(st.nextToken());
			}
			
			
			maxNum=Integer.MIN_VALUE;
		
			dfs(0,0,0);
			
			if(maxNum==Integer.MIN_VALUE)
				
			{
				maxNum=-1;
			}
			System.out.println("#"+i+" "+maxNum);
			
			
			
			
			
			
			
		}
		
		
	}
	
	public static void dfs(int idx,int sum,int size)
	{
		if(sum>M) return;
		if(size==2)
		{
		//	maxNum=Math.max(maxNum, sum);
			if(maxNum< sum)
			{
				maxNum=sum;
			}
			return;
		}
		if(idx==N) return;
		
		int temp=w[idx];
		dfs(idx+1,sum+temp,size+1);
		dfs(idx+1,sum,size);
		
		
		
	}
	
	public static void dfs2(int size,int idx,int sum)
	{
		if(sum>M) return;
		if(size==2)
		{
		//	maxNum=Math.max(maxNum, sum);
			if(maxNum< sum)
			{
				maxNum=sum;
			}
			return;
		}
		if(idx==N) return;
		
		//int temp=w[idx];
		dfs(size+1,idx+1,sum+w[idx]);
		dfs(size,idx+1,sum);
		
		
		
	}
	static void pick(int cnt, int idx, int sum) {
		if(sum > M) return;
		if(cnt == 2) {
			if(maxNum < sum) maxNum = sum;
			return;
		}
		if(idx == N) return;
		
		pick(cnt + 1, idx + 1, sum + w[idx]);
		pick(cnt, idx + 1, sum);
	}
	
	
	

}