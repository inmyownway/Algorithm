import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * 
 */
public class Solution {
	static int N,M;
	static int[] parents;
	public static void main(String[] args) throws IOException{


		BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testCase= Integer.parseInt(bf.readLine());
		
		for(int tc=1;tc<testCase+1;tc++)
		{
			st= new StringTokenizer(bf.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			
			parents = new int[N];
			make();	
			StringBuffer sb= new StringBuffer();
			
			for(int command=0;command<M;command++)
			{
			
				st=new StringTokenizer(bf.readLine());
				
				int com= Integer.parseInt(st.nextToken());
				int a= Integer.parseInt(st.nextToken())-1;
				int b= Integer.parseInt(st.nextToken())-1;
				
				// union
				if(com==0)
				{
					union(a,b);
				}
				else if(com==1)
				{
					if(find(a)==find(b))
					{
						sb.append(1);
					}
					else
					{
						sb.append(0);
					}
				}
				
			}
			System.out.println("#"+tc+" "+sb.toString());
		}
			
	}
	public static void make()
	{
		for(int i=0;i<N;i++)
		{
			parents[i]=i;
		}
	}
	public static int find(int v)
	
	{
		if(v==parents[v])
		{
			return v;
		}
		else
		{
			return parents[v]=find(parents[v]);
		}
	
		
	}
	public static void union(int a,int b)
	{
		int aRoot= find(a);
		int bRoot= find(b);
		
		
		parents[bRoot]=aRoot;
		
	}
}