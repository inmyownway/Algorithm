import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.InputMap;

public class Main {
//
	static int N,M;
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
	
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N=Integer.parseInt(bf.readLine());
		M=Integer.parseInt(bf.readLine());
		parents= new int[N+1];
		
		make();
		
		for(int i=0;i<M;i++)
		{ 
			st= new StringTokenizer(bf.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
		
			union(a,b);		
		}
		
		
		int answer=0;
		int so = parents[1];
		for(int i=2;i<N+1;i++)
		{
			if(so==find(i))
				answer++;
		}
		
	//	System.out.println(Arrays.toString(parents));
		System.out.println(answer);
	}

	public static void make()
	{
		for(int i=1;i<N+1;i++)
		{
			parents[i]=i;
		}
	}
	public static int find(int x)
	{
		if(x==parents[x])
			return x;
		
		return parents[x]=find(parents[x]);
	}
	public static void union(int x,int y)
	{
		int aRoot= find(x);
		int bRoot = find(y);
		
		if(aRoot>bRoot)
		{
			parents[aRoot]=bRoot;
		}
		else if(aRoot < bRoot)
		{
			parents[bRoot]=aRoot;
		}
	}
}