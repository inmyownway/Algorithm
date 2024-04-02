import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	   static int D,W,K;
	    static int[][] board;
	    static int[][] copyBoard;
	    static int ans;
	public static void main(String[] args) throws IOException {
	    BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        int testCase= Integer.parseInt(st.nextToken());

        for(int test=1;test<testCase+1;test++)
        {
            st= new StringTokenizer(bf.readLine());
            D= Integer.parseInt(st.nextToken());
            W=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());
            board= new int[D][W];
            copyBoard = new int[D][W];
            
            
            for(int i=0;i<D;i++)
            {
                st= new StringTokenizer(bf.readLine());
                for(int j=0;j<W;j++)
                {
                    board[i][j]=Integer.parseInt(st.nextToken());
                    copyBoard[i][j]=board[i][j];
                }
            }
            
            
            ans= Integer.MAX_VALUE;
            
            solve(0,0);
            
            System.out.println("#"+test+" "+ans);
        }

	}
	private static void solve(int row, int cnt) {

		
		if(cnt>= ans) return;
		
		if(row==D)
	
		{
			
			if(check())
			{
				ans=Math.min(cnt, ans);
			}
			return;
		}
		
		// 약품 주입 x
		
		solve(row+1,cnt);
		
		// 약품주입 a
		for(int i=0;i<W;i++)
		{
			board[row][i]=0;
		}
		solve(row+1,cnt+1);

		
		// 약품주입 b
		for(int i=0;i<W;i++)
		{
			board[row][i]=1;
		}
		solve(row+1,cnt+1);
		
		
		for(int i=0;i<W;i++)
		{
			board[row][i]= copyBoard[row][i];
		}
		
	}
	private static boolean check() {
			
	
		int now,next;
		for(int i=0;i<W;i++)
		{
			int cnt=1;
			for(int j=0;j<D-1;j++)
			{
				now= board[j][i];
				next= board[j+1][i];
				
				if( now==next)
				{
					cnt++;
					if(cnt>=K) break;
				}
				else
				{
					cnt=1;
					
				}
			}
			
			if(cnt<K) return false;
		}
		return true;
	}

}