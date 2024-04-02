import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static int answer;
	static int N;
	static int[][] cost;
	
	static boolean[][] v;
	static class Node implements Comparable<Node> {
	    int x;
	    int y;
	    int cost;

	    public Node(int x, int y, int cost) {
	        this.x = x;
	        this.y = y;
	        this.cost = cost;
	    }

	    @Override
	    public int compareTo(Node o) {
	        return this.cost - o.cost;
	    }
	}
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
	
		int proNumber=1;
		while(true)
		{
			 N= Integer.parseInt(bf.readLine());
			
			if(N==0)
				break;
			
			board = new int[N][N];
				
			
			for(int i=0;i<N;i++)
			{
				st= new StringTokenizer(bf.readLine());
				for(int j=0;j<N;j++)
				{
					
					board[i][j]=Integer.parseInt(st.nextToken());
				}
			}
				v= new boolean[N][N];
			v[0][0]=true;	
			bfs();
			System.out.println("Problem "+proNumber+ ": "+cost[N-1][N-1]);
			proNumber++;
		}

	}
	public static void bfs()
	{
		
	
		 cost = new int[N][N];
		
		Queue<Node> q = new PriorityQueue<>();
		q.add(new Node(0,0,board[0][0]));
		cost[0][0]=board[0][0];
		v[0][0]=true;
		
		while(!q.isEmpty())
		{
			Node node = q.poll();
			
			for(int i=0;i<4;i++)
			{
				int nx = node.x+dx[i];
				int ny=  node.y+dy[i];
				
				if(isBoundary(nx,ny) && v[nx][ny]==false)
				{
							v[nx][ny]=true;
	                        cost[nx][ny] = node.cost + board[nx][ny];
	                        q.add(new Node (nx,ny,node.cost+board[nx][ny]));
				}
			}
			
//			for(int[] c: cost)
//			{
//				System.out.println(Arrays.toString(c));
//			}
//System.out.println();
		}
		
	}
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<N && y>=0 && y<N;
	}
}