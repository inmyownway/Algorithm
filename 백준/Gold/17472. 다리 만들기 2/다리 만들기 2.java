import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;



public class Main {

	static int N,M;
	
	static int[][] initBoard;
	static int[][] board;
	static int[] dx = {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static int num=1;
	static boolean[][] visited;
	static int[] parents;
	static int islandCnt;
	static ArrayList<Edge> edge;
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		
		public Edge(int from,int to,int weight)
		{
			super();
			this.from=from;
			this.to=to;
			this.weight=weight;
			
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
	}
	public static void main(String[] args) throws IOException {

	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		initBoard = new int[N][M];
		
		board = new int[N][M];
		visited= new boolean[N][M];
		edge= new ArrayList<>();
	
		for(int i=0;i<N;i++)
		{
			st= new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++)
			{
				initBoard[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(!visited[i][j] && initBoard[i][j]==1)
				{
					naming(i,j);
					num++;
				}
			}
		}
		
//	for(int[] b: board)
//	{
//	System.out.println(Arrays.toString(b));
//	}
//		
		
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				int minBridege=Integer.MAX_VALUE;
				// 섬인 경우 
				if(board[i][j]!=0)
				{
					// 섬 넘버 , weight
					//System.out.println("섬 여기서 탐색 다리놓기 시작 "+i+" "+j);
					makeBridge(i,j,0);
					
			}
		}
//			for(Edge e: edge)
//				{
//						System.out.println(e);
//				}
//					System.out.println();
				}
		Collections.sort(edge);
		parents = new int[num];
		make();
		int weight=0;
		int cnt=0;
		
		boolean f= true;
		int tempCnt=0;
		for(Edge e: edge)
		{
			
			
			if(!union(e.from, e.to))
			{// union 실패하면 싸이클 발생이니까 continue 함;
			
				continue; 
			}
				
			weight+= e.weight;
			tempCnt++;
				
				if(++cnt==num-1) break;
				
				
					
		}
	
		Set<Integer> tempSet = new HashSet<>();
		
		for(Edge e: edge)
		{
			tempSet.add(e.to);
			tempSet.add(e.from);
		}
//		System.out.println(tempSet);
//		System.out.println(weight);
//		System.out.println(tempSet.size());
//		System.out.println(num);
	//	System.out.println(f);
//		if(weight==0)
//		{
//			System.out.println(-1);
//		}
//		else if( tempSet.size()!= num-1)
//		{
//			System.out.println(-1);
//		}
		//System.out.println(tempCnt);
		//System.out.println(num-2);
		if(tempCnt != num-2)
		{
			System.out.println(-1);
		}
		else
		{
			System.out.println(weight);

		}
		
	}
	
	private static void makeBridge(int x, int y, int k) {
	

		int[] dx= {-1,1,0,0};
		int[] dy= {0,0,-1,1};
		//System.out.println("현재: "+board[x][y]+  " 시작");
		
		for(int j=0;j<4;j++)
		{
		//	System.out.println("현재 방향 "+j);
			
			int px=dx[j];
			int py=dy[j];
			
			
			Queue<int[] > q= new LinkedList<>();
			q.add(new int[] {x,y,0});
			
			while(!q.isEmpty())
			{
				
				int[] now= q.poll();
				
				int nx= now[0]+px;
				int ny= now[1]+py;
				int w = now[2];
				
				// 범위안에 있고, 0이면
				if(isBoundary(nx, ny) && board[nx][ny]==0)
				{
					q.add(new int[] {nx,ny,w+1});
					
				}
				
				else if (isBoundary(nx, ny) && board[nx][ny]!=0 && board[nx][ny]!=board[x][y])
				{
					// 범위안에 있고 0 아니고 
					boolean flag= true;
					if(w>=2)
					{
						for(int i=0;i<edge.size();i++)
							{
//								System.out.println("to:"+board[x][y]);
//								System.out.println("from: "+board[nx][ny]);
//							System.out.println("edge from to "+edge.get(i).from +" "+edge.get(i).to);
//								
								

								if( (board[x][y]==edge.get(i).from && board[nx][ny]==edge.get(i).to) ||
										 (board[x][y]==edge.get(i).to && board[nx][ny]==edge.get(i).from)	)
								{
									
									flag=false;
									int temp = Math.min(edge.get(i).weight,w);
									edge.get(i).weight=temp;
									
//								System.out.println(edge.get(i).weight+" "+w);
//								System.out.println("중복된거 바꿔줌");
//								System.out.println(board[nx][ny]);
							
									break;
								}
							}
						if(flag)
						{
							edge.add(new Edge(board[x][y],board[nx][ny],w));
							break;
						}
					
					}
					else
					{
						break;
					}
					
				}
			}
		}
		

	}
	public static void make() {
		parents = new int[num];
		for (int i = 0; i < num; i++) {
			parents[i] = i;
		}
	}
	public static int find(int a){
		if(parents[a] == a) return a;// 자신이 루트이면 그냥 자신의 번호 리턴
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a,int b){
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		// 두 노드의 root가 다르면 합침
		parents[bRoot] = aRoot;
		return true;
	}	
	
	

	public static void naming(int x,int y)
	{
	
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y,});
		
		visited[x][y]=true;
		
		board[x][y]=num;
		
		while(!q.isEmpty())
		{
	
			int[] now = q.poll();
			
			for(int i=0;i<4;i++)
			{
				int nx = now[0]+dx[i];
				int ny= now[1]+dy[i];
				
				if(isBoundary(nx, ny) && !visited[nx][ny] && initBoard[nx][ny]==1)
				{
					visited[nx][ny] =true;
					q.add(new int[] {nx,ny});
					board[nx][ny]=num;
				
					
				}
			}
		}
		
		
		
	
	}
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<N && y>=0&& y<M;
	}

}