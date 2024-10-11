import java.util.*;
import java.io.*;



public class Main {


	static int N,M,K;
	static int[][] board;
	static ArrayList<int[]>[] team; 
	static int answer;
	static int[] dir;
	static int[] dx= {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	static int round=0;
	static boolean[] ballVisited;
	public static void main(String[] args) throws IOException
	{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		
		board= new int[N][N];
		dir= new int[N];
		for(int i=0;i<N;i++)
		{
			st= new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
			{
				board[i][j] = Integer.parseInt(st.nextToken());
				
				
			}
		}
		
		team = new ArrayList[M];
		for(int i=0;i<M;i++)
		{
			team[i]= new ArrayList<>();
		}
		
		findTeam();
	
		//printTeam();
		
		for(int i=0;i<K;i++)
		{ 
			
			//System.out.println("k: "+i);
			teamMove();
			
			checkBoard();
			ball();
			int temp = answer;

			
			//printBoard();
			//printTeam();
		
			round++;
	//	System.out.println(Arrays.toString(dir));
			//System.out.println(answer);
			//System.out.println();
			}
		
		System.out.println(answer);
	
	
	}
	public static void check(int x,int y)
	{
		if(board[x][y]<0)
		{
			int teamNum= -(board[x][y]);
			teamNum--;
			//System.out.println("team "+teamNum );
			//System.out.println(x+" "+y);
			
			if(ballVisited[teamNum]==false)
			{
				
				ballVisited[teamNum]=true;
				// 점수 계산하기 이게 몇번쨰인지 확인해서
				
				
				// 머리
				//System.out.println("dir[teamNum] "+ dir[teamNum]);
				if(dir[teamNum]==0)
				{
				
					ArrayList<int[]> t= team[teamNum];
					
					for(int idx=0;idx<t.size();idx++)
					{
						int[] now= t.get(idx);
						//System.out.println(Arrays.toString(now));
						if(x==now[0] && y==now[1])
						{
							answer+= (idx+1)*(idx+1);
						//System.out.println("ans#: "+(idx+1)*(idx+1));
							dir[teamNum]=1;
							break;
						}
					}
					
				}
				else if(dir[teamNum]==1)
				{
					
					ArrayList<int[]> t= team[teamNum];
					
					int number=1;
					for(int idx=t.size()-1;idx>-1;idx--)
					{
						int[] now= t.get(idx);
						
						if(x==now[0] && y==now[1])
						{
							answer+= (number)*(number);
							//System.out.println("ans@:  "+number*number);
							dir[teamNum]=0;
							break;
						}
						number++;
					}
				
				}
			}
			
		}
		
		
	}
	public static void ball()
	{
		int r= round%(N*4);
		ballVisited = new boolean[N];
		
		
		int[][] b= new int[N][N];
		// 오른쪽으로
		
		if(r>=0 && r<N)
		{
			r=r%N;
			for(int i=0;i<N;i++)
			{
				b[r][i]=1;
				if(board[r][i]<0)
				{
				check(r,i);
				return;
				}
			}
		}
		else if(r>=N && r<2*N)
		{			
	
			r=r%N;
		
			for(int i=0;i<N;i++)
			{
		
				if(board[N-1-i][r]<0)
				{
				check(N-1-i,r);
				return;
				}
				b[N-1-i][r]=1;
				

			}
		}
		else if(r>=2*N && r<3*N)
		{		
			
			r=r%N;
			for(int i=0;i<N;i++)
			{
				b[N-1-r][N-1-i]=1;
				if(board[N-1-r][N-1-i]<0)
				{
				check(N-1-r,N-1-i);
				return;
				}

			}
			
		}
		else if(r>=3*N && r<4*N)
		{			r=r%N;

			for(int i=0;i<N;i++)
			{
				b[i][N-1-r]=1;
				if(board[i][N-1-r]<0)
				{
				check(i,N-1-r);
				return;
				}

			}
		}
		
		
	
		
	}
	public static void checkBoard() 
	{
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(board[i][j]!=4 && board[i][j]!=0)
				{
					board[i][j]=4;
				}
			}
		}
		
		for(int i=0;i<M;i++)
		{
			ArrayList<int[]> t= team[i];
			
		
			if(dir[i]==0) 
			{
					for(int j=1;j<t.size()+1;j++)
					{
						 int[] person = t.get(j-1);
						 
						 board[person[0]][person[1]]=-(i+1);
					}
			}
			else if(dir[i]==1)
			{
				int nn=-1;
				for(int j=t.size()-1;j>-1;j--)
				{
					 int[] person = t.get(j);
					 
					 board[person[0]][person[1]]=-(i+1);
					 nn--;
				}
			}
			
		}
		
		
		
	}
	public static void p(int[][] b)
	{
		for(int i=0;i<N;i++)
		{
			System.out.println(Arrays.toString(b[i]));
		}
		System.out.println();
	}
	public static void teamMove()
	{
		for(int i=0;i<M;i++)
		{
			ArrayList<int[]> t = team[i];
			int d =dir[i];
			
			
			if(d==0)
			{
				int[] pre= t.get(1);
				int[] now= t.get(0);
				//System.out.println(Arrays.toString(now));
				//System.out.println(Arrays.toString(pre));
				
				
				for(int idx=0;idx<4;idx++)
				{
					int nx= now[0]+dx[idx];
					int ny= now[1]+dy[idx];
					
					if(isBoundary(nx,ny) && !(nx == pre[0] && ny==pre[1]) && board[nx][ny]!=0)
					{
						team[i].add(0,new int[] {nx,ny});
						team[i].remove(team[i].size()-1);
						break;
					}
				}
			}
			else if(d==1)
			{
				
				int[] pre= t.get(t.size()-2);
				int[] now= t.get(t.size()-1);
				
				
				for(int idx=0;idx<4;idx++)
				{
					int nx= now[0]+dx[idx];
					int ny= now[1]+dy[idx];
					
					if(isBoundary(nx,ny) && !(nx == pre[0] && ny==pre[1]) && board[nx][ny]!=0)
					{
						team[i].add(new int[] {nx,ny});
						team[i].remove(0);
						break;
					}
				}
			}
			
		}
	}
	
	
	public static void printTeam()
	{
		for(int i=0;i<M;i++)
		{
			
			ArrayList<int[]> pt = team[i];
			
			for(int j=0;j<pt.size();j++)
			{
				System.out.print(Arrays.toString(pt.get(j))+" ");
			}
			System.out.println("");
			
		}
	}
	public static void findTeam()
	{
		boolean[][] v= new boolean[N][N];
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(board[i][j]==4)
				{
					v[i][j]=true;
				}
			}
		}
		int teamNum=0;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(board[i][j]==1)
				{
					
					int num=2;
					v[i][j]=true;
					
					Queue<int[]> q= new LinkedList<>();
					ArrayList<int[]> array = new ArrayList<>();
					array.add(new int[] {i,j});
					
					q.add(new int[]{i,j});
					int[] last= new int[2];
					while(!q.isEmpty())
					{
						int[] now= q.poll();
						//System.out.println(Arrays.toString(now));
						for(int idx=0;idx<4;idx++) 
						{
							int nx= now[0]+dx[idx];
							int ny= now[1]+dy[idx];
							
							
						//	System.out.println(nx+" "+ny);
							if(isBoundary(nx,ny) && !v[nx][ny] )
							{
								
								if(board[nx][ny]==2)
								{
									//System.out.println("2");
								array.add(new int[] {nx,ny});
								q.add(new int[] {nx,ny});
								v[nx][ny]=true;
								
								}
							
								
								 if(board[nx][ny]==3)
								{
									//System.out.println("3");
									last[0]=nx;
									last[1]=ny;
									
								}
							
							}
						}
					}
						array.add(last);
					for(int idx=0;idx<array.size();idx++)
					{
					//	System.out.println(Arrays.toString(array.get(idx)));
						team[teamNum].add(array.get(idx));
					}
				
					teamNum++;
				}
				
			}
		}
		
	}
	public static void printBoard()
	{
		for(int i=0;i<N;i++)
		{
			System.out.println(Arrays.toString(board[i]));
		}
	//	System.out.println();
	}
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<N &&y>=0 && y<N;
	}
}
