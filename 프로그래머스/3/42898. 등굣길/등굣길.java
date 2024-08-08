import java.util.*;
class Solution {
  
    static int[][] dp;
    static int M,N;
    static int div=  1000000007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        M=m;
        N=n;
        
        dp= new int[N+1][M+1];
        
        dp[1][1]=1;
        for(int[] p:puddles)
        {
            dp[p[1]][p[0]]=-1;
        }
        
        for(int i=1;i<N+1;i++)
        {
            for(int j=1;j<M+1;j++)
            {
                if(dp[i][j]==-1)
                {
                      dp[i][j]=0;
                  continue;
                }
                
                if(!(i==1 && j==1))
                
                {
                int x=0;
                int y=0;
                if(i>1)
                {
                     x= dp[i-1][j];
                }
                if(j>1)
                {
                      y=  dp[i][j-1];

                }
                    dp[i][j]= (x+y)%div;
                }
            }
            
            
            
        }
         return dp[N][M]%div;
    }
}