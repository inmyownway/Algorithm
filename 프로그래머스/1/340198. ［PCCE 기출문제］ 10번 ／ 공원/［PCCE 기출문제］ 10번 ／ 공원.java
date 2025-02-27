import java.util.*;

class Solution {
    static int N,M;
    static String[][] park;
    
    public int solution(int[] mats, String[][] park) {
        this.park=park;    
        int answer = -1;
        N= park.length;
        M= park[0].length;
        Arrays.sort(mats);
        
        
        // # # #
        for(int idx=0;idx<mats.length;idx++)
        {
            int x= mats[idx];
            boolean flag= false;// cnt=0;
            for(int a=0;a<=N-x;a++)
            {
                for(int b=0;b<=M-x;b++)
                {
                    // start
                    if(start(a,b,x))
                    {
                       flag= true;
                        break;
                    }
                    
                }
                if(flag)
                {
                    break;
                }
            }
            if(flag)
            {
                answer= Math.max(answer,x);
            }
        }
        if(answer==-1)
        {
            return -1;
        }
        return answer;
    }
    public static boolean start(int a,int b,int x)
    {
    
        for(int i=a;i<a+x;i++)
        {
            for(int j=b;j<b+x;j++)
            {
                if(!park[i][j].equals("-1"))
                {
                    return false;
                }
            }
        }
        return true;
    }
}