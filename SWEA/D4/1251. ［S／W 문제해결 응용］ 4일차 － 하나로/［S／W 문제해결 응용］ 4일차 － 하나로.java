import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int[][] islands;
	static double E;
	static Edge[] edgeList;
	static int[] parents;
	
	
	static class Edge implements Comparable<Edge>
	{
		int from;
		int to;
		double weight;
		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Double.compare(this.weight,o.weight);
		}
		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
	}
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int testCase= Integer.parseInt(bf.readLine());
		
		for(int tc=1;tc<testCase+1;tc++)
		{
			
			N=Integer.parseInt(bf.readLine());
	
			islands=new int[N][2];
			parents= new int[N];
			
			st = new StringTokenizer(bf.readLine());
			for(int i=0;i<N;i++)
			{
				islands[i][0]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(bf.readLine());
			for(int i=0;i<N;i++)
			{
				islands[i][1]=Integer.parseInt(st.nextToken());
			}
			
			E= Double.parseDouble(bf.readLine());
			
			edgeList = new Edge[N * (N - 1) / 2];
			
			int idx=0;
			for(int i=0;i<N;i++)
			{
				for(int j=i+1;j<N;j++)	
				{	
		
						int to1 = islands[i][0];
						int from1= islands[i][1];
						int to2= islands[j][0];
						int from2= islands[j][1];
						
						double L= Math.sqrt(Math.pow(Math.abs(to1-to2),2)+   Math.pow(Math.abs(from1-from2),2) );
						double w= Math.pow(L, 2) * E;
						
						edgeList[idx]= new Edge(i,j,w);
						idx++;
				}
			}
//			for(Edge e:edgeList)
//			{
//				System.out.println(e);
//			}
			make();
			
			double answer=0;
			int cnt=0;
			Arrays.sort(edgeList);
			
			for(Edge e:edgeList)
			{
				if(!union(e.from, e.to))
				{
					continue;
				}
				answer+=e.weight;
				cnt++;
				if(cnt==N-1)
				{
					break;
				}
			}
			
			System.out.println("#"+tc+" "+Math.round(answer));
		}
		
		
		
		
	}
	public static void make()
	{
		for(int i=0;i<N;i++)
		{
			parents[i]=i;
		}
	}
	public static int find(int a){
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a,int b){
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		

		parents[bRoot] = aRoot;
		return true;
	}	
	
}