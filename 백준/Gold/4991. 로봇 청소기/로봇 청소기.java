import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	static int w,h;
	static char[][] board;
	static int startX,startY;
	static int[][] distance;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static ArrayList<int[]> dirty;
	static int[] userToDirty;
	static int[] number;
	static int minDirtyDistance;
	public static void main(String[] args) throws IOException {
	
		
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while(true)
		{
			st= new StringTokenizer(bf.readLine());
			
			w= Integer.parseInt(st.nextToken());
			h= Integer.parseInt(st.nextToken());
			dirty= new ArrayList<>();
			if(w==0 && h==0)
			{
				break;
			}
			
			board= new char[h][w];
			
			
			
			for(int i=0;i<h;i++)
			{
				String str= bf.readLine();
				for(int j=0;j<w;j++)
				{
					board[i][j]=str.charAt(j);
				
					
				
					if(board[i][j]=='*')
					{
						dirty.add(new int[] {i,j});
					}
					else if(board[i][j]=='o')
					{
						startX=i;
						startY=j;
					}
				}
			
			}
			
			
			
			// 거리 구하기 
			
			distance= new int[dirty.size()][dirty.size()];
			userToDirty= new int[dirty.size()];
			
			boolean flag= false;

			for(int i=0;i<dirty.size();i++)
			{
				for(int j=0;j<dirty.size();j++)
				{
					if(i!=j)
					{
						
						int[] start= dirty.get(i);
						int[] end = dirty.get(j);
						distance[i][j]=bfs(start[0],start[1],end[0],end[1]);
	
						if(distance[i][j]==-1)
						{
							flag=true;
							break;
						}
					}
				}
				if(flag)
				{
					break;
				}
			}
			
			if(flag)
			{
				System.out.println(-1);
				continue;
			}
			
			for(int i=0;i<dirty.size();i++)
			{
				int[] dd = dirty.get(i);
				userToDirty[i]=bfs(startX,startY,dd[0],dd[1]);
			}
			
			
//			for(int[] d: distance)
//			{
//				System.out.println(Arrays.toString(d));
//			}
//			System.out.println();
//			
//			
//			for(int d: userToDirty)
//			{
//				System.out.print(d+" ");
//			}

			number = new int[dirty.size()];
			for(int i=0;i<dirty.size();i++)
			{
				number[i]=i;
			}
			minDirtyDistance=Integer.MAX_VALUE;

			perm(0);
			
		//	System.out.println();
			System.out.println(minDirtyDistance);
		}
	}
	private static void perm(int depth) {
		
		if(depth==dirty.size())
		{
			
			check(number);
			return;
		}
		
		for(int i=depth;i<dirty.size();i++)
		{
			swap(i,depth);
			perm(depth+1);
			swap(i,depth);
		}
		
	}
	private static void check(int[] num) {

	
		int userIndex=-1;
		
	//System.out.println(Arrays.toString(num));
	
		int sum=0;
		for(int i=0;i<num.length-1;i++)
		{
			sum+= distance[num[i]][num[i+1]];		
		}
		//System.out.println("sum: " +sum);
		userIndex= num[0];
		//System.out.println("userIndex: "+userIndex+" d: "+userToDirty[userIndex]);
	//	System.out.println(sum+userToDirty[userIndex]);
	//	System.out.println();
		minDirtyDistance= Math.min(minDirtyDistance,sum+userToDirty[userIndex]);
		
	}
	private static void swap(int x, int y) {
		// TODO Auto-generated method stub
		
		int temp = number[x];
		number[x]=number[y];
		number[y]=temp;
	}
	public static int bfs(int sx,int sy,int ex,int ey)
	{
		
		Queue<int[]> q= new LinkedList<>();
		boolean[][] v= new boolean[h][w];
		
		
		
		
		v[sx][sy]=true;
		q.add(new int[] {sx,sy,0});
		
		
	while(!q.isEmpty())
	{
		int size=q.size();
		
		for(int s=0;s<size;s++)
		{
			int[] now= q.poll();
			
			if(now[0]==ex && now[1]==ey)
			{
				return now[2];
			}
			for(int i=0;i<4;i++)
			{
				int nx= now[0]+dx[i];
				int ny= now[1]+dy[i];
				
				if(isBoundary(nx, ny) && v[nx][ny]==false && board[nx][ny]!='x')
				{
					v[nx][ny]=true;
					q.add(new int[] {nx,ny,now[2]+1});
					
				}
			}
		}
		
		
	}
		
		return -1;
	}
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<h && y>=0 && y<w;
	}
}