import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static long p[]= new long[101];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		// P(n) =p(n-2) + p(n-3)
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int testCase= Integer.parseInt(bf.readLine());
		
		p[1]=1;
		p[2]=1;
		p[3]=1;
		p[4]=2;
		p[5]=2;
		
		for(int test=0;test<testCase;test++)
		{
			
			int n= Integer.parseInt(bf.readLine());
			
			for(int i=6;i<=n;i++)
			{
				p[i]=p[i-1]+p[i-5];
			}	
			System.out.println(p[n]);
		}

	
	}
	

}