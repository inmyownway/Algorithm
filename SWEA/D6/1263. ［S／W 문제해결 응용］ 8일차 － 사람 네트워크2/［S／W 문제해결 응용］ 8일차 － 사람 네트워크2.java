import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Solution {

	static int[][] board;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int testCase= Integer.parseInt(bf.readLine());
		
		for(int t=0;t<testCase;t++)
		{
			
			 st= new StringTokenizer(bf.readLine());
			
			int  N=Integer.parseInt(st.nextToken());
			 board = new int[N][N];
		
			 for(int i=0;i<N;i++)
			 {
				 for(int j=0;j<N;j++)
				 {
					 board[i][j]=Integer.parseInt(st.nextToken());
				 }
			 }
			
//			 for(int[]b:board)
//			 {
//				 System.out.println(Arrays.toString(b));
//			 }
//			 
			 for(int i=0;i<N;i++)
			 {
				 for(int j=0;j<N;j++)
				 {
					 if(i!=j)
					 {
						 if(board[i][j]==0)
						 {
							 board[i][j]=Integer.MAX_VALUE/4;
						 }
					 }
				 }
			 }
			 
			// System.out.println();
//			 for(int[]b:board)
//			 {
//				 System.out.println(Arrays.toString(b));
//			 }
//			 
			 for(int k=0;k<N;k++)
			 {
				 for(int i=0;i<N;i++)
				 {
					 for(int j=0;j<N;j++)
					 {
						 if(board[i][j]> board[i][k]+board[j][k])
						 {
							 board[i][j]= board[i][k]+board[j][k];
						 }
					 }
				 }
			 }
			 
//			 for(int[]b:board)
//			 {
//				 System.out.println(Arrays.toString(b));
//			 }
			 int max=Integer.MAX_VALUE;
			 
			 for(int[] b: board)
			 {
				 int sum=0;
				 for(int i=0;i<N;i++)
				 {
					 sum+=b[i];
				 }
				 
				 max= Math.min(max, sum);
				 
				 
			 }
			 System.out.println("#"+(t+1)+" "+max);
			 
			
		}
		
		
	}

}