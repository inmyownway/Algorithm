import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;



public class Main {

   
	
	
	
	static int N,M;
	static int[] result;
	public static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) throws IOException {
	
		
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		result = new int[M];
		
		dfs(0,0);
		System.out.println(sb);

	}
	private static void dfs(int depth, int cnt) {
	
		if(depth==M)
		{
			for(int i=0;i<M;i++)
			{
			sb.append(result[i]).append(' ');
			}
			sb.append('\n');
			return;
		}for(int i=0;i<N;i++)
		{
			
			result[depth]=i+1;
			dfs(depth+1,cnt);
		}
		
		
	}

}