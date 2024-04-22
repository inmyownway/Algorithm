import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;





public class Main {

	static int N;
	static int[][] board;
	static Queue<int[][]> q;
	static int[][] E;
	
	
	static boolean[][][] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		{
			BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			
			N= Integer.parseInt(bf.readLine());
			q = new LinkedList<>();
			
			board= new int[N][N];
			v= new boolean[N][N][2];
			
			int[][] temp = new int[3][2];
			int idx=0;
			for(int i=0;i<N;i++)
			{
				String str= bf.readLine();
				for(int j=0;j<N;j++)
				{
					char c = str.charAt(j);
					
					if(c=='B')
					{
						temp[idx][0]=i;
						temp[idx][1]=j;
						
						idx++;
						board[i][j]=0;
						
					}
					else if(c=='E')
					{
						board[i][j]=-1;
					}
					else
					{
						board[i][j]=c-'0';
					}
				
				}
				
			}
			if(temp[0][0]==temp[1][0] && temp[1][0]== temp[2][0])
			{
			
				v[temp[1][0]][temp[1][1]][0]=true;

				
			}
			else
			{
				v[temp[1][0]][temp[1][1]][1]=true;
		
			}
			q.add(temp);
			
			
			int cnt=0;
			boolean isFinish = false;
			while(!q.isEmpty())
			{
				boolean end= false;
		
				int size=q.size();
			//	System.out.println();
				cnt++;
				for(int s=0;s<size;s++)
				{
					int[][] now = q.poll();
					
					int x1= now[0][0];
					int y1= now[0][1];
					
					int x2= now[1][0];
					int y2= now[1][1];
					
					int x3= now[2][0];
					int y3= now[2][1];
					
					int currentState=0;
					if(x1==x2 && x2== x3)
					{
					//	v[x2][y2][0]=true;
						currentState=0;
						
					}
					else
					{
						//v[x2][y2][1]=true;
						currentState=1;
					}
				
					
				// System.out.println(x1+" "+y1+"  "+x2+" "+y2+"   "+ x3+" "+y3+"  ");
					if(board[x1][y1]==-1 && board[x2][y2]==-1 && board[x3][y3]==-1)
					{
						System.out.println(cnt-1);
						
						end=true;
						isFinish=true;
						break;
					}
				
					// 위
					int tx1= x1-1;
					int ty1= y1;
					
					int tx2= x2-1;
					int ty2= y2;
					
					int tx3= x3-1;
					int ty3 = y3;
					if(isBoundary(tx1,ty1) && isBoundary(tx2, ty2) && isBoundary(tx3,ty3))
					{
						if(v[tx2][ty2][currentState]==false && board[tx1][ty1]!= 1 && board[tx2][ty2]!=1 && board[tx3][ty3]!=1)
						{
							//System.out.println("up");
							int[][] t= new int[3][2];
							t[0][0]=tx1;
							t[0][1]=ty1;
							
							t[1][0]=tx2;
							t[1][1]=ty2;
							
							t[2][0]=tx3;
							t[2][1]=ty3;
							v[tx2][ty2][currentState]=true;
							q.add(t);
						}
					}
					// 아래
					 tx1= x1+1;
					 ty1= y1;
					
					 tx2= x2+1;
					 ty2= y2;
					
					 tx3= x3+1;
					 ty3 = y3;
					if(isBoundary(tx1,ty1) && isBoundary(tx2, ty2) && isBoundary(tx3,ty3))
					{
						if(v[tx2][ty2][currentState]==false && board[tx1][ty1]!= 1 && board[tx2][ty2]!=1 && board[tx3][ty3]!=1)
						{
					//System.out.println("down");
							int[][] t= new int[3][2];
							t[0][0]=tx1;
							t[0][1]=ty1;
							
							t[1][0]=tx2;
							t[1][1]=ty2;
							
							t[2][0]=tx3;
							t[2][1]=ty3;
							v[tx2][ty2][currentState]=true;
							q.add(t);
						}
					}
					// 좌
					
					 tx1= x1;
					 ty1= y1-1;
					
					 tx2= x2;
					 ty2= y2-1;
					
					 tx3= x3;
					 ty3 = y3-1;
					if(isBoundary(tx1,ty1) && isBoundary(tx2, ty2) && isBoundary(tx3,ty3))
					{
						if(v[tx2][ty2][currentState]==false && board[tx1][ty1]!= 1 && board[tx2][ty2]!=1 && board[tx3][ty3]!=1)
						{
						//	System.out.println("left");
							int[][] t= new int[3][2];
							t[0][0]=tx1;
							t[0][1]=ty1;
							
							t[1][0]=tx2;
							t[1][1]=ty2;
							
							t[2][0]=tx3;
							t[2][1]=ty3;
							v[tx2][ty2][currentState]=true;
							q.add(t);
						}
					}
					// 우
						 tx1= x1;
						 ty1= y1+1;
						
						 tx2= x2;
						 ty2= y2+1;
						
						 tx3= x3;
						 ty3 = y3+1;
						if(isBoundary(tx1,ty1) && isBoundary(tx2, ty2) && isBoundary(tx3,ty3))
						{
							if(v[tx2][ty2][currentState]==false && board[tx1][ty1]!= 1 && board[tx2][ty2]!=1 && board[tx3][ty3]!=1)
							{
								//System.out.println("right");
								int[][] t= new int[3][2];
								t[0][0]=tx1;
								t[0][1]=ty1;
								
								t[1][0]=tx2;
								t[1][1]=ty2;
								
								t[2][0]=tx3;
								t[2][1]=ty3;
								v[tx2][ty2][currentState]=true;
								q.add(t);
							}
						}
					// 회전
						
					// 회전가능 체크
				
					if(isRotate(x2,y2))
						
					{
							if(x1==x2 && x2==x3)
							{
								tx1= x1-1;
								 ty1= y1+1;
								
								 tx2= x2;
								 ty2= y2;
								
								 tx3= x3+1;
								 ty3 = y3-1;
								 currentState=1;
								if(isBoundary(tx1,ty1) && isBoundary(tx2, ty2) && isBoundary(tx3,ty3))
								{
									
									if(v[tx2][ty2][currentState]==false && board[tx1][ty1]!= 1 && board[tx2][y2]!=1 && board[tx3][ty3]!=1)
									{//System.out.println("rotate1");
										int[][] t= new int[3][2];
										t[0][0]=tx1;
										t[0][1]=ty1;
										
										t[1][0]=tx2;
										t[1][1]=ty2;
										
										t[2][0]=tx3;
										t[2][1]=ty3;
										v[tx2][ty2][currentState]=true;
										q.add(t);
									}
								}
							
							}
							else if(y1==y2 && y2==y3)
							{
								tx1= x1+1;
								 ty1= y1-1;
								
								 tx2= x2;
								 ty2= y2;
								
								 tx3= x3-1;
								 ty3 = y3+1;
								 currentState=0;
								if(isBoundary(tx1,ty1) && isBoundary(tx2, ty2) && isBoundary(tx3,ty3))
								{
									if(v[tx2][ty2][currentState]==false && board[tx1][ty1]!= 1 && board[tx2][y2]!=1 && board[tx3][ty3]!=1)
									{//System.out.println("rotate2");
										int[][] t= new int[3][2];
										t[0][0]=tx1;
										t[0][1]=ty1;
										
										t[1][0]=tx2;
										t[1][1]=ty2;
										
										t[2][0]=tx3;
										t[2][1]=ty3;
										v[tx2][ty2][currentState]=true;
										q.add(t);
									}
								}
							}
							 
					}
					
							
					
				}
				if(end)
					break;

			
				
			}
			if(isFinish==false)
				System.out.println(0);
			
		}
				
	

	}
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<N && y>=0 && y<N;
	}
	public static boolean isRotate(int x,int y)
	{
		int check=0;
		
		int[] dx= {0,0,-1,1, 1,1,-1,-1};
		int[] dy= {1,-1,0,0, 1,-1,1,-1};
		
		for(int i=0;i<8;i++)
		{
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(isBoundary(nx, ny) && board[nx][ny]!=1)
			{
				check++;
			}
		}
		//System.out.println(check);
		if(check==8)
			return true;
		return false;
	}
	
	
		
}