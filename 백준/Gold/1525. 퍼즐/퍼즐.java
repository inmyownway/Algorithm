import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;




public class Main {

	static int N=3;
	static int[][] board;
	static int[] dx = {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static int answer=Integer.MAX_VALUE;
	static String start;
	public static void main(String[] args) throws IOException
	{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		board= new int[N][N];

		start="";
		for(int i=0;i<N;i++)
		{
			st= new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
			{
				String temp = st.nextToken();
				if(temp.equals("0"))
					start+="9";
				else
					start+=temp;
			}
		}

		bfs();
		


	}
	public static void bfs( )
	{

		Queue<String> q= new LinkedList<>();
		Map<String,Integer> map = new HashMap<>();
		q.add(start);
		map.put(start,0);
		
		while(!q.isEmpty())
		{
			String nowStr = q.poll();
			int numberPos = nowStr.indexOf("9");
			//System.out.println(numberPos);
			int x= numberPos/3;
			int y= numberPos%3;
			//System.out.println("pos: "+x+" "+y);
			for(int idx=0;idx<4;idx++)
			{
				int nx = x+dx[idx];
				int ny= y+dy[idx];
				int move= nx*3 + ny;
				
				if(isBoundary(nx, ny))
				{
				
				
					// temp 는 옮기는곳 
					char temp = nowStr.charAt(move);
				
						
					String next= nowStr;
					
					next = next.replace(temp,'0');
					next= next.replace('9',temp);
					next= next.replace('0', '9');
					
					if(!map.containsKey(next))
					{
						q.add(next);
						map.put(next, map.get(nowStr)+1);
					}
				}	
			//	System.out.println();
			}
		
	
		}	
		if(map.containsKey("123456789"))
			{
				System.out.println(map.get("123456789"));
			}
			else
			{
				System.out.println(-1);
			}

		
	
	}

	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<N && y>=0 && y<N;
	}
}