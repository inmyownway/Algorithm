import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int V;
	static int E;
	static int[] parents;
	static Edge[] edge;
	static class Edge implements Comparable<Edge>{
		int to;
		int from;
		int weight;
		public Edge(int to, int from, int weight) {
			super();
			this.to = to;
			this.from = from;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
		return Integer.compare(this.weight,o.weight);
		}
		@Override
		public String toString() {
			return "Edge [to=" + to + ", from=" + from + ", weight=" + weight + "]";
		}
		
	}
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int testCase= Integer.parseInt(bf.readLine());
		
		for(int tc=1;tc<=testCase;tc++)
		{
			st= new StringTokenizer(bf.readLine());
			
			V= Integer.parseInt(st.nextToken());
			E=Integer.parseInt(st.nextToken());
			
			parents= new int[V];
			edge= new Edge[E];
			for(int i=0;i<E;i++)
			{
				st= new StringTokenizer(bf.readLine());
				
				int to= Integer.parseInt(st.nextToken())-1;
				int from=Integer.parseInt(st.nextToken())-1;
				//System.out.println(to+" "+from);
				int weight = Integer.parseInt(st.nextToken());
				
				edge[i]=new Edge(to,from,weight);
			}
			
			make();
			Arrays.sort(edge);
			
			long result=0;
			int cnt=0;
			for(Edge e: edge)
			{
			
		
				if(!union(e.from,e.to)) continue;
			
				result+=e.weight;
				

				cnt++;
				if(cnt==V-1) break;
			}
			System.out.println("#"+tc+" "+result);
		}


		
	}
	public static void make()
	
	{
		for(int i=0;i<V;i++)
			
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
	public static boolean union(int x,int y)
	{
		int aRoot= find(x);
		int bRoot= find(y);
		if(aRoot==bRoot) return false;
		
		parents[bRoot]=aRoot;
		return true;
	}
}