import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer=0;
        Arrays.sort(times);
        long left= 0;
        long right= times[times.length-1]*(long)n;
  
        while(left<=right)
        {
            long sum=0;
            long mid = (left+ right)/2;
            
            for(int i=0;i<times.length;i++)
            {
                sum+= mid/times[i];
                
            }
            
            if(sum<n)
            {
        
                left= mid+1;
            }
            else if(sum >=n)
            {
                right= mid-1;
                answer= mid;
            }
        }
        return answer;
    }
}