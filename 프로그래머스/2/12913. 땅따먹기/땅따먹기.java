import java.util.*;

class Solution {
    static long answer;
    long solution(int[][] land) {
    
        
        Queue<long[]> q= new LinkedList<>();
        
        
        // 초기값 넣어주기 
        
        for(int i=0;i<4;i++)
        {
            q.add(new long[]{land[0][i],i});    
        }
        long[] temp= new long[4];
        for(int i=1;i<land.length;i++)
        {
             temp= new long[4];
            
            for(int j=0;j<4;j++)
            {
                long[] now= q.poll();

                for(int idx=0;idx<4;idx++)
                {
                    if(idx!=now[1])
                    {
                        temp[idx]=Math.max(temp[idx],now[0]+land[i][idx]);
                    }
                }
            }
            //System.out.println(Arrays.toString(temp));
            for(int a=0;a<4;a++)
            {
                q.add(new long[]{temp[a],a});
            }
        }
        
        for(int i=0;i<4;i++)
        {
        answer= Math.max(answer,temp[i]);
        }


        return answer;
    }
}