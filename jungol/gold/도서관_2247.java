package S0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
// 시간: 289ms , 메모리 : 38mb

// 1 5
// 8 10 

public class 도서관_정올 {

	static int N;

	static int[][] arrays;
	public static void main(String[] args) throws IOException
	{
		
		

		
		BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(bf.readLine());
		
		StringTokenizer st;
		arrays=new int[N][2];
		for(int i=0;i<N;i++)
		{
			st= new StringTokenizer(bf.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
		
			arrays[i][0]=s;
			arrays[i][1]=e;
		}
		
		
		
		Arrays.sort(arrays, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] o1, int[] o2) {
		        return o1[0]-o2[0]; 
		    
		    }
		});		
		
	
	

		
		
		
		int[] time = new int [2];
		


		
		int S=0;
		int E=0;
		
		int inTime=0;
		int outTime=0;
		
		for(int i=0;i<arrays.length;i++)
		{
			
			S=arrays[i][0];
			E=arrays[i][1];
			
			if(S>time[1]) // 들어온 시간이 앞 end 시간 보다 크면 , 공백 생기는 경우임
			{
				if(outTime < S-time[1])
				{
					outTime= S-time[1];
				}
				
				time[0]=S;
				time[1]=E;
			}
			else // S<time[1]; 계속 이어지는 경우
			{
				if (time[1] < E)
                    time[1] = E;
 
                if (inTime < time[1] - time[0])
                	inTime = time[1] - time[0];
				
			}
			
		}
		System.out.println(inTime+" "+outTime);
	}
}
// 1 3
// 2 5

