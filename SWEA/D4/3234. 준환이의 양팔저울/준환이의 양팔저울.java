import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

import javax.security.sasl.SaslException;

public class Solution {
	static int N;
	static int[] arr;
	static boolean[] isVisited;
	static int allSum;
	static int answer;
	static Set<ArrayList<Integer>> answerSat;
	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int testCase= Integer.parseInt(bf.readLine());
		
		
		
		for(int test=1;test<testCase+1;test++)
		{
			answerSat =new HashSet<>();
			N=Integer.parseInt(bf.readLine());
		
			arr= new int[N];
			
			st=new StringTokenizer(bf.readLine());
			for(int i=0;i<N;i++)
			{
				arr[i]=Integer.parseInt(st.nextToken());
				allSum+=arr[i];
			}
			
			Arrays.sort(arr);
			answer=0;
			
			do {//	System.out.println(Arrays.toString(arr));
					isVisited = new boolean[N];
					
		
					dfs(arr[0],0,1);
					
							}
			while(np(arr));
			

		System.out.println("#"+test+" "+answer);
	
		}
	
		
		
			
	}
	public static void dfs(int left,int right,int depth)
	{
		
		if(left<right)
		{
			return;
		}
			
		
		
		if(depth==N)
		{
			answer++;
		return;
		}
		
		dfs(left+arr[depth],right,depth+1);
		dfs(left,right+arr[depth],depth+1);
		
		
		
		
		
		
		
	}

	public static boolean np(int[] p)
	{
		
		int N=p.length-1;
		
		int idx= N;
		// i 찾기
		
		while(idx>0 && p[idx-1] >= p[idx])
		{
			idx--;
		}
				
		if(idx==0)
			return false;
		// 바꿀꺼 찾음 idx-1

		int bigNum = N;
		
		while(p[bigNum]<=p[idx-1])
		{
			bigNum--;
		}
		
		;
		swap(p,idx-1,bigNum);
		
		int k=N;
		
		while(idx<k)
		{
			swap(p,idx,k);
			idx++;
			k--;
		}
		
		
		return true;
	}
	public static void swap(int[] arr,int i,int j)
	{
		
		int temp =arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}