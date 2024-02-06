import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static String[] tree;
	static boolean[] visited;
	
	 public static void main(String[] args) throws IOException
	 
	 {
		 
	 
		 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
		
			// + - * /
			// * 3 2 1 2 6 4 8 7 
			
			for(int testcase=1;testcase<11;testcase++)
			{
				
				
				N=Integer.parseInt(bf.readLine());
				
				visited = new boolean[N+1];
				tree = new String[N+1];
				
				for(int i=1;i<N+1;i++)
				{
					st=new StringTokenizer(bf.readLine());
					
					st.nextToken();
					String e = st.nextToken();
					tree[i]=e;
					
		
				
				}

				int result = bfs();
			
				System.out.println("#"+testcase+" "+result);
			}
		
			
		
			
	 }
	 public static int bfs() {

		 Queue<Integer> q = new LinkedList<Integer>();
		 q.add(1);
		 
		 while(!q.isEmpty())
		 {//System.out.println();
			 int currnet = q.poll();
			 boolean flag= false;
			 
			 if(currnet*2<=N)
			 {
				 q.add(currnet*2);
				 flag=true;
				 
			 }
			 
			 if(currnet*2+1<=N)
			 {
				 q.add(currnet*2+1);
				 flag=true;
				 
			 }
			// System.out.println(flag);
			 if(flag==false)
			 {
				 if(tree[currnet].equals("+") ||tree[currnet].equals("-")||tree[currnet].equals("*")||tree[currnet].equals("/"))
				 {
					 return 0;
				 }
			 }
		 }
		 return 1;
	 }
	
}