class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
    
        long left=0;
        long right = times[times.length-1]*(long)n;
        
        while(left<=right)
        {

            long mid = (left+right)/2;
            long allTime=0;
            
            for(int i=0;i<times.length;i++)
            {
                allTime+=mid/times[i]; 
            }
            
            if(allTime <n)
            {

                left = mid+1;
                
            }
            else 
            {
            right=mid-1;
            }
            
        }
        
        return left;
    }
}