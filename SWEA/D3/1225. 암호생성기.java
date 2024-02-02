package jungmin.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기 {

	
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);

	
		for(int testcase=1;testcase<11;testcase++)
		{
			
			int nt=sc.nextInt();
			int[] numArr = new int[8];
			Queue<Integer> q = new LinkedList<>();
			for(int i=0;i<8;i++)
			{
				q.add(sc.nextInt());
			}
			
			
			int n=1;
			while(true)
			{
			
				if(q.peek()-n<=0)
				{
					q.poll();
					q.add(0);
					break;
				}
				q.add(q.poll()-n);
				
				n++;
				if(n==6)
					n=1;

			//	System.out.println(q);

			}
			System.out.print("#"+testcase+" ");
			for(int i=0;i<8;i++)
			{
				System.out.print(q.poll()+" ");
			}
			
		}
		

		
		
		
		
	}
}
