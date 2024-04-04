import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {

	static int[][] board;
	static int[] paperCnt;
	static int[] paperNum;
	static int answer;
	static ArrayList<int[]> arr;
	static int minAnswer=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		board= new int[10][10];
		for(int i=0;i<10;i++)
		{
			st= new StringTokenizer(bf.readLine());
			for(int j=0;j<10;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		

		
		paperCnt = new int[] {5,5,5,5,5};
//		paperNum = new int[] {5,,3,4,5};
		
			
		
		boolean start= true;
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(board[i][j]!=0)
				{
					start=false;
				}
			}
		}
		
		if(start)
		{
			System.out.println(0);
		}
		else
		{
				answer= Integer.MAX_VALUE;
		dfs(0,0,paperCnt);
		
		if(answer!=Integer.MAX_VALUE)
		{
			System.out.println(answer);
		}
		else
		{
			System.out.println(-1);
		}
		
		}
		
	
	}

		
	public static void dfs(int i,int j,int[] cnt)
	{
	
			if(i>=10)
			{
				
				boolean f= true;
				for(int a=0;a<10;a++)
				{
					for(int b=0;b<10;b++)
					{
						if(board[a][b] ==1)
						{
							f= false;
						}
					}
				}
				
				
						
				
				if(f)
				{//System.out.println(Arrays.toString(cnt));
						
				int sum=0;
				for(int a=0;a<5;a++)
				{
					sum+= 5-cnt[a];
					
				}
				if(sum!=0)
				{
					answer=Math.min(sum, answer);
				}
				
		
				
				
				
				}
				return;
			
			}

			
				if(board[i][j]==1 )
				{
				
					for(int idx=0;idx<5;idx++)
					{
						
						if(cnt[idx]>0)
						{
							
							if(canAttatch(i, j, idx+1))
							{
								attatch(i,j,idx+1);
								
								cnt[idx]--;
								if(cnt[idx]==-1)
									cnt[idx]=0;
								int tx=i;
								int ty=j;
								
								if(j==9)
								{
									tx++;
									ty=0;
								}
								else
								{
									ty++;
								}
							
								dfs(tx,ty,cnt);
								
								back(i, j, idx+1);
								cnt[idx]++;
							}
							
							
						}
					}
				
				}
				else
				{
					int tx=i;
					int ty=j;
					
					if(j==9)
					{
						tx++;
						ty=0;
					}
					else
					{
						ty++;
					}
				
					dfs(tx,ty,cnt);
					
				}
				
			
			
	
				}
			

		
	
	
	
	public static void attatch(int i, int j, int num) {
		for(int x=i;x<i+num;x++)
		{
			for(int y=j;y<j+num;y++)
			{
		
				board[x][y]=2;
			
			}
		}
	}
	public static void back(int i, int j, int num) {
		
		for(int x=i;x<i+num;x++)
		{
			for(int y=j;y<j+num;y++)
			{
		
				board[x][y]=1;
			
			}
		}
	}
	
	private static boolean canAttatch(int i,int j,int num) {
		
	boolean flag= true;

		for(int x=i;x<i+num;x++)
		{
			for(int y=j;y<j+num;y++)
			{
				if(!isBoundary(x,y))
				{
					return false;
				}
				if(board[x][y]!=1)
					flag= false;
			
			}
		}
	return flag;
	}
	public static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<10 && y>=0 && y<10;
	}


}