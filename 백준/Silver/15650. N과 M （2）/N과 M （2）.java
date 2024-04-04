import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;


public class Main {

	static int N;
	static int M;
	static int[] arr;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());

		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr= new int[M];
		v= new boolean[N];

	
	
		dfs(0,0);
	
	}
	private static void dfs(int depth,int start) {
		
		if(depth==M)
		{
			for(int a: arr)
			{
				System.out.print(a+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<N;i++)
		{
			if(v[i]==false)
			{
				v[i]=true;
				arr[depth]=i+1;
				dfs(depth+1,i);
				v[i]=false;
			}
		}
		
		
	}
	
	

}