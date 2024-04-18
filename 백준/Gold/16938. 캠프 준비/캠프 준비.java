import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main {

	static int N,L,R,X;
	static int[] score;
	static boolean[] v;
	static int answer;
	public static void main(String[] args) throws IOException {

		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
		N= Integer.parseInt(st.nextToken());
		L= Integer.parseInt(st.nextToken());
		R= Integer.parseInt(st.nextToken());
		X= Integer.parseInt(st.nextToken());
		
	
		
		score= new int[N];
			v= new boolean[score.length];
		st= new StringTokenizer(bf.readLine());
		for(int i=0;i<N;i++)
		{
			score[i]=Integer.parseInt(st.nextToken());
		}
		subset(0);
		System.out.println(answer);
		
	}
	public static void subset(int cnt)
	{
		
		if(cnt==score.length)
		{
			
			int sum=0;
			for(int i=0;i<N;i++)
			{
				if(v[i])
					sum++;
			}
			if(sum>=2)
			{
				check(v,sum);
			}
			
			return;
			
		}
		
		v[cnt]=true;
		subset(cnt+1);
		v[cnt]=false;
		subset(cnt+1);
	}
	private static void check(boolean[] visited,int size) {

		
		int sum=0;
		int[] temp = new int[size];
		
		
	
		int idx=0;
		for(int i=0;i<N;i++)
		{
			if(visited[i])
			{
				temp[idx++]=score[i];
			}
		}
	
		Arrays.sort(temp);
		
		for(int i=0;i<temp.length;i++)
		{
			sum+=temp[i];
		}
		
		if(sum >= L && sum <=R && (temp[size-1]-temp[0])>=X)
		{
			answer++;
		}
			
		
		
	}

}