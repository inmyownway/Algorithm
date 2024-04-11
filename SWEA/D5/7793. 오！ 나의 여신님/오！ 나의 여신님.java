import java.awt.event.ItemEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	static int N,M;
	static char[][] board;
	static boolean[][] v;
	static int[] dx = {0,0,-1,1};
	static int[] dy= {1,-1,0,0};
	
	static class Person{
		int x;
		int y;
		int cnt;
		public Person(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	static class Devil{
		int x;
		int y;
		public Devil(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static Queue<Person> person;
	static Queue<Devil > devil;
	static int ex,ey;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {


		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int testCase= Integer.parseInt(bf.readLine());
		for(int test=1;test<testCase+1;test++)
		{
			st= new StringTokenizer(bf.readLine());
			N= Integer.parseInt(st.nextToken());
			M= Integer.parseInt(st.nextToken());
			
			person = new LinkedList<>();
			devil = new LinkedList<>();
			answer= Integer.MAX_VALUE;
			board = new char[N][M];
			v= new boolean[N][M];
			for(int i=0;i<N;i++)
			{
				String str= bf.readLine();
				for(int j=0;j<M;j++)
				{
					
					board[i][j]=str.charAt(j);
					
					if(board[i][j]=='D')
					{
						ex=i;
						ey=j;
					}
					else if(board[i][j]=='*')
					{
						devil.add(new Devil(i, j));
					}
					else if(board[i][j]=='S')
					{
						v[i][j]=true;
						person.add(new Person(i,j,0));
					}
				}
				
			}
			
			
			while(true)
			{
				
				devilMove();
				personMove();
				
				if(answer!=Integer.MAX_VALUE)
				{
					break;
				}
				if(person.size()==0)
				{
					answer=-1;
					break;
				}
			}
			
			if(answer==-1)
			{
				System.out.println("#"+test+" GAME OVER");

			}
			else
			{
					System.out.println("#"+test+" "+answer);
			}
		
		}
		
		
	}
	private static void personMove() {
		int size= person.size();
		
		for(int i=0;i<size;i++)
		{
			Person p = person.poll();
			
			if(p.x== ex && p.y==ey)
			{
				answer=Math.min(answer, p.cnt);
				return;
			}
			
			for(int idx=0;idx<4;idx++)
			{
				int nx = p.x+dx[idx];
				int ny= p.y+dy[idx];
				
				//System.out.println(nx+" "+ny);

				if(isBoundary(nx, ny) )
				{

					if( v[nx][ny]==false && board[nx][ny]=='.' || board[nx][ny]=='D')
					{
									v[nx][ny]=true;
					
					person.add(new Person(nx,ny,p.cnt+1));
					}
		
				}
			}
		}
		
	}
	private static void devilMove() {
	
		int size= devil.size();
		
	
		for(int i=0;i<size;i++)
		{
			Devil d = devil.poll();
			
			for(int idx=0;idx<4;idx++)
			{
				int nx = d.x+dx[idx];
				int ny= d.y+dy[idx];
				
				if(isBoundary(nx, ny) && v[nx][ny]==false && board[nx][ny]!='X' && board[nx][ny] !='D')
				{
					
					v[nx][ny]=true;
					devil.add(new Devil(nx,ny));
					
				}
			}
		}
		
	}
	private static boolean isBoundary(int x,int y)
	{
		return x>=0 && x<N && y>=0 && y<M;
	}
}