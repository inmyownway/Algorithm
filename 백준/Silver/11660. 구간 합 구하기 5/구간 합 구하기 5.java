import java.util.*;
import java.io.*;
public class Main {
    static int[][] dp;
    static int N,M;
    public static void main(String[] args) throws IOException{
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        
        N= Integer.parseInt(st.nextToken());
        dp = new int[N+1][N+1];
        M= Integer.parseInt(st.nextToken());
        for(int i=1;i<N+1;i++)
        {
            st= new StringTokenizer(bf.readLine());
            for(int j=1;j<N+1;j++)
            {
                if(j!=0)
                {
                    dp[i][j]= dp[i][j-1]+Integer.parseInt(st.nextToken());
                }
                else{
                dp[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            
        }
    
        
        for(int i=0;i<M;i++)
        {           
            st= new StringTokenizer(bf.readLine());
            int x1= Integer.parseInt(st.nextToken());
            int y1= Integer.parseInt(st.nextToken());
            int x2= Integer.parseInt(st.nextToken());
            int y2= Integer.parseInt(st.nextToken());
            
            int sum=0;
            for(int a=x1;a<=x2;a++)
            {
                
                int temp =0;
                if(y1-1==0)
                {
                    temp=0;
                }
                else{
                    temp=y1-1;
                }
                sum += dp[a][y2]-dp[a][y1-1];
            }
            System.out.println(sum);

        }
    }
}
