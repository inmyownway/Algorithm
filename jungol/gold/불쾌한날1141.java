package S0202;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
/**
 * 
 * 692ms / 50
 */
public class 불쾌한날 {

	static int N;
	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// 6 5 2 4 2 6 1 
		Scanner sc = new Scanner(System.in);
	
		N=sc.nextInt();
		int[] arr= new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=sc.nextInt();
			
		}
		//System.out.println(Arrays.toString(arr));
		int sum=0;
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<N;i++)
		{
			

		if(st.isEmpty())
		{
			st.push(arr[i]);
			
		}
		else if(st.peek()>arr[i])
		{
			sum+=st.size();
			
			st.push(arr[i]);
		}
		else
		{
			while(true)
			{
				if(st.isEmpty()||   st.peek()>arr[i])
				{//7  2 4 
					// 6
					sum+=st.size();
					st.push(arr[i]);
					
					break;
				}
				else
				{
					st.pop();
				
				}
			}
			//System.out.println(st);
		}
				//System.out.println(st);
			
		}
		System.out.println(sum);

	}
}
