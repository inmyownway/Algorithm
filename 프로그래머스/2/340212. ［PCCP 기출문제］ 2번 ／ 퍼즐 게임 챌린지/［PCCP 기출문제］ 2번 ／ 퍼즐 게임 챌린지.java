import java.util.*;

class Solution {
    
    static int left= Integer.MAX_VALUE;
    static int right= Integer.MIN_VALUE;
    
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=0;i<diffs.length;i++)
        {
         
            right= Math.max(right,diffs[i]);
        }
        
        left= 1;
        int level=0;
        long time;
        while(left<=right)
        {
            level= (left+right)/2;
            
            time=0;
            
            time += times[0];
            if(time > limit)
            {
                time += limit+1;
            }
        
            int prev=0;
            for(int i=1;i<diffs.length;i++)
            {
                prev= times[i-1];
                
                if(diffs[i]> level)
                {
                    time+= (diffs[i]-level)*(prev+times[i]) + times[i];
                    
                    
                }
                else
                {
                    time+=times[i];
                }
                
                if(time>limit)
                {
                    break;
                }
            }
            
            if(time<=limit)
            {
               answer= level;
               right= level-1;
                
                
            }
            else{
                left = level+1;
            }
            
        }
        
        return answer;
    }
}