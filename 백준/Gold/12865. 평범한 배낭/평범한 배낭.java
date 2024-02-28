import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int[][] items;
	static int[] dp;
	static int[][] board;
	public static void main(String[] args) throws IOException
	{
		// (Wi, Vi) = (6, 13), (4, 8), (3, 6), (5, 12)
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
	
		
		board= new int[N+1][K+1];
		
		
		for(int i=1;i<=N;i++)
		{
			st= new StringTokenizer(bf.readLine());
			int w=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
		
			// 초기값 설정 
		
				for(int j=1;j<K+1;j++)
				{
					
					// 담을수 있는경우 
					if(j>=w)
					{
						board[i][j]=Math.max(board[i-1][j],board[i-1][j-w]+v);
					}
					else
					{
						board[i][j]=board[i-1][j];
					}
//					if(j >=w )
//					{
//						if(board[i-1][j]==0)
//						{
//						board[i][j]=v;
//						
//						}
//						else 
//						{
//							
//								//int min = board[i-1][j-w];
//								int min=0;
//							
//									for(int z=0;z<N;z++)
//									{	
//										min=Math.max(board[z][j-w],min);
//									
//									}
//								
//								
//							
//									System.out.println("min:" +min);
//							
//								
//								board[i][j]=Math.max(min+v, board[i-1][j]);
//								min=0;
//						}
//					}
				}			
//				for(int[] a: board)
//			{
//				System.out.println(Arrays.toString(a));
//			}
//			System.out.println();
		}
	
		
		
		
		System.out.println(board[N][K]);
		
		}
				
				
			
			

		
	}