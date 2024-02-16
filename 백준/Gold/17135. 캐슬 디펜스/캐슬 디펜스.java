import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N,M,D;
	static int[][] board;
	static Archer[] archer;
	static int[] archerIdx;
	static int[] combIdx;
	static int[] dx= {0,-1,0};
	static int[] dy= {-1,0,1};
	static int answer;
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
	
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		D=Integer.parseInt(st.nextToken());
		
		
		board= new int[N+1][M];
		
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(bf.readLine());
			for(int j=0;j<M;j++)	
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		archer= new Archer[M];
		
		archerIdx= new int[M];
		combIdx= new int[3];
		for(int i=0;i<M;i++)
		{
			archerIdx[i]=i;
		}
		
		for(int i=0;i<M;i++)
		{
		
			archer[i]= new Archer(N,i);
		}
		
	
		answer=0;
		comb(0,0);
		System.out.println(answer);
	}
	public static void comb(int depth,int cnt)
	{
		if(depth==3)
			
		{
			// 궁수 3명 뽑음 
			//System.out.println(Arrays.toString(combIdx));
			check();
			//System.out.println(" ");
			return;
		}
		if(cnt>=M) return;
		
		combIdx[depth]=archerIdx[cnt];
		
		comb(depth+1,cnt+1);
		comb(depth,cnt+1);
		
		
		
	}
	public static void check()
	{
		
		int cnt=0;
		//System.out.println(Arrays.toString(combIdx));
		
		int[][] copyBoard = new int[N+1][M];
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				copyBoard[i][j]=board[i][j];
			}
		}
		
		while(true)
		{
			
			ArrayList<int[]> kill = new ArrayList<>();
			
			
			// 궁수 돌아가면서 죽일애들 kill 리스트에 넣음
			for(int i=0;i<3;i++)
			{
				int x= archer[combIdx[i]].x;
				int y= archer[combIdx[i]].y;
				int[] now = new int[] {x,y,0};
				
				Queue<int[]> q = new LinkedList<>();
				
				boolean[][] visited = new boolean[N+1][M];
				q.add(now);
				
				while(!q.isEmpty())
				{
					
					int[] current =q.poll();
					
					int cx=current[0];
					int cy=current[1];
					int dis=current[2];
					
					if(copyBoard[cx][cy]==1 && dis<=D)
					{
						kill.add(new int[] {cx,cy});
						break;
					}
					for(int idx=0;idx<3;idx++)
					{
						int nx= cx+dx[idx];
						int ny=cy+dy[idx];
				
						if(isBoundary(nx, ny) && !visited[nx][ny])
						{
							q.add(new int[] {nx,ny,dis+1});
							visited[nx][ny]=true;
						}
						
						
					}
				}
			}
				// 적 죽이기
			
				
			
				int[][] temp=new int[N+1][M];
				
				for(int i=0;i<N+1;i++)
				{
					for(int j=0;j<M;j++)
					{
						temp[i][j]=copyBoard[i][j];
					}
				}
				for(int[] k : kill)
				{
				//	System.out.println("Kill "+Arrays.toString(k));
					copyBoard[k[0]][k[1]]=0;
					//cnt++;
					
				}	
		
				// 적 카운트 
				int tempCnt1=0;
				int tempCnt2=0;
				
				for(int i=0;i<N;i++)
				{
					for(int j=0;j<M;j++)
					{
						if(copyBoard[i][j]==1)
						{
							tempCnt1++;
						}
					}
					
				}
				for(int i=0;i<N;i++)
				{
					for(int j=0;j<M;j++)
					{
						if(temp[i][j]==1)
						{
							tempCnt2++;
						}
					}
					
				}
				cnt+=tempCnt2-tempCnt1;
				
			//	print(copyBoard);
			//	System.out.println();
				
				// 적들 내려오기 
			//	System.out.println("내려오고");
				for(int i=0;i<M;i++)
				{
					copyBoard[N-1][i]=0;
				}
				for(int a=N-2;a>-1;a--)
				{
					for(int b=0;b<M;b++)
					{
						if(copyBoard[a][b]==1)
						{
							copyBoard[a+1][b]=1;
							copyBoard[a][b]=0;
						}
					}
				}
				    //print(copyBoard);
				// 적들 없으면 종료
			    boolean flag=true;
			    for(int a=0;a<N;a++)
			    {
			    	for(int b=0;b<M;b++)
			    	{
			    		if(copyBoard[a][b]==1)
			    		{
			    			flag=false;
			    		}
			    	}
			    }
			    if(flag==true)		
			    {
			    	answer=Math.max(cnt, answer);
			    	break;
			    }
			
			
			    
			
		}
	//	System.out.println();
		//System.out.println("kill수: "+cnt );
	}
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<=N && y>=0 && y<M;
	}
	public static void print(int[][] arr)
	{
		for(int[] a:arr){
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
	}
public static class Archer
{
	int x;
	int y;
	Archer(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
}