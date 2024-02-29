import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N,M,K;
	static int[][] board; // 방향
	static int[][] numInfo; // 개수 정보
	static int[] dx= {0,-1,1,0,0};
	static int[] dy= {0,0,0,-1,1};
	public static void main(String[] args) throws IOException{
		

		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testCase= Integer.parseInt(bf.readLine());
		
		for(int tc=1;tc<testCase+1;tc++)
		{
			st= new StringTokenizer(bf.readLine());
			
			N= Integer.parseInt(st.nextToken());
			M= Integer.parseInt(st.nextToken());
			K= Integer.parseInt(st.nextToken());
			
			board = new int[N][N];
			numInfo = new int[N][N];
			
			
			for(int i=0;i<K;i++)
			{
				st= new StringTokenizer(bf.readLine());
				int x= Integer.parseInt(st.nextToken());
				int y= Integer.parseInt(st.nextToken());
				
				int n= Integer.parseInt(st.nextToken());
				int dir= Integer.parseInt(st.nextToken());
		
				numInfo[x][y]=n;
				board[x][y]=dir;
				
			}
			//print(numInfo);
	
			for(int i=0;i<M;i++)
			{
			
				move();

				
//				print(board);
//			System.out.println();
//			print(numInfo);
			////System.out.println("@@@@@");
			}

			
			
			int answer=0;
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					answer+=numInfo[i][j];
				}
			}
			System.out.println("#"+tc+" "+answer);
			
		}
		
		
	}
	
	public static void move()
	{
		int[][] tempBoard= new int[N][N];
		int[][] tempNumInfo = new int[N][N];
		int[][] compareNum = new int[N][N];
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(board[i][j]!=0)
				{//System.out.println(i+" "+j+" 일떄 ");
					int dir= board[i][j];
					
					int nx= i+dx[dir];
					int ny= j+dy[dir];
				//	System.out.println(nx+" "+ny+" "+dir);
				//	System.out.println(numInfo[i][j]);
				//	System.out.println(isBoundary(nx, ny));
					// 밖일때 
					if(!isBoundary(nx, ny))
					{
						// 바운더리 밖인데 1마리이면 죽음
						// 리스트에 안넣어줌 
						
						
						if(numInfo[i][j]>1)
						{
						//	System.out.println("!");
							dir= changeDir(dir);
							tempBoard[nx][ny]=dir;
							tempNumInfo[nx][ny]= numInfo[i][j]/2;
							board[i][j]=0;
							numInfo[i][j]=0;
						}					
					}
					else
					{
						// 바운더리 안에있고 가는곳이 비어있을떄 
						if(tempBoard[nx][ny]==0)
						{
							tempBoard[nx][ny]=dir;
							tempNumInfo[nx][ny]=numInfo[i][j];
							compareNum[nx][ny]=numInfo[i][j];
							}
						else
						{ // 겹치는게 있을때,  마리수 합쳐주고 방향 비교해줘야함 
							//System.out.println("!");
							int currentNum = numInfo[i][j];
							
							if(compareNum[nx][ny]<currentNum)
							{
								//System.out.println(1);
								
								compareNum[nx][ny]=currentNum;
								tempNumInfo[nx][ny]+=currentNum;
								
								tempBoard[nx][ny]=dir;
								
							}
							else
							{
								tempNumInfo[nx][ny]+=currentNum;
							}
							
						}
						board[i][j]=0;
						numInfo[i][j]=0;
						
					}	//System.out.println(i+" "+j);
//					print(tempBoard);
//					System.out.println();
//					print(tempNumInfo);
//					System.out.println();
			
				}
				board[i][j]=0;
				numInfo[i][j]=0;
			}
		}
		
		board=copy(tempBoard);
		numInfo=copy(tempNumInfo);
		
		
		
	}
	public static int changeDir(int d)
	{
		if(d==1)
			return 2;
		else if(d==2)
			return 1;
		else if(d==3)
			return 4;
		else
			return 3;
		
	}
	public static boolean isBoundary(int x,int y)
	{
		return x>=1 && x<N-1 && y>=1 && y<N-1;
	}
	public static int[][] copy(int[][] c)
	{
		int[][] temp = new int[N][N];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				temp[i][j]=c[i][j];
			}
		
		}
		return temp;
	}
	public static void print(int[][] arr)
	{
		for(int[]a:arr)
		{
			System.out.println(Arrays.toString(a));
		}
	}

}