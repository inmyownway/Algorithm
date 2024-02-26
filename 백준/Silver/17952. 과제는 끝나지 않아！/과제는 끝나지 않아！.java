import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	//
	static int N;
	static Stack<int[]> stack;//stack = new Stack<int[]>();
	static int[][] work;
	public static void main(String[] args) throws IOException{

		// 업부는 최근 순으로, 받으면 바로함
		// 새로운 업무 들어오면 중단하고 새로운 업무 함
		// 새로운 업무하면 이전에 하던거 이어서함 
		
		

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N=Integer.parseInt(bf.readLine());
		stack = new Stack<int[]>();
		work= new int[N][3];
		int score=0;
		
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(bf.readLine());
			
		   int n= Integer.parseInt(st.nextToken());
		   int A;
		   int T;
		   if(n==1)
		   {
			    A= Integer.parseInt(st.nextToken());
			    T= Integer.parseInt(st.nextToken());
			    
	
					if(T-1==0)
					{
						score+=A;
					}
					else
					{
						stack.add(new int[] {n,A,T-1});
						
					}
			    }
		   else
		   {
			   if(stack.size()>=1)
				{
					int[] preWork = stack.pop();
					
					
					n = preWork[0];
					A= preWork[1];
					T= preWork[2];
					
					if(T-1==0)
					{
						score+=A;
					}
					else
					{
						stack.add(new int[] {n,A,T-1});
						
					}
				}
		   }
		  
		}
		
	
		
		System.out.println(score);
	}

}