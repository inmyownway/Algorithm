import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static char[][] board;
	static int[] dx =new int[] {-1,0,1};
	static int[] dy= new int[] {1,1,1};
	static int cnt;
	static boolean flag;
	public static void main(String[] args) throws IOException{

		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st= new StringTokenizer(bf.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		for(int i=0;i<R;i++)
		{
			String str = bf.readLine();	
			for(int j=0;j<C;j++)
			{
				
				board[i][j]=str.charAt(j);
			}
		}
		
		
		for(int i=0;i<R;i++)
		{
			flag= false;
			dfs(i,0);
		}
		System.out.println(cnt);
		
	}

	public static void dfs(int x,int y)
	{
		if(flag)
			return;
		
		board[x][y]='x';
		// 도착한경우
		if(y==C-1) {
			
			flag=true;
			cnt++;
			return;
		}
		for(int i=0;i<3;i++)
		{
			int nx = x+dx[i];
			int ny= y+dy[i];
			
			if(isBoundary(nx, ny) && board[nx][ny]=='.')
			{
				dfs(nx,ny);
			}
		}
		
	}
	public static boolean isBoundary(int x,int y)
	{

		return x>=0 && x<R && y<C &&  y>=0;
	}

}

//