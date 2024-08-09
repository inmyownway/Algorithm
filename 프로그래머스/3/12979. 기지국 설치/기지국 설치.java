class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        
 
        
        int start=1;
        
        for(int idx=0;idx<stations.length;idx++)
        {
            int currentStations = stations[idx];
            
            if(start >= currentStations-w)
            {
                start= currentStations+w+1;
                continue;
            }
            else
            {
                int d = currentStations-w  - start;
                
            
                if(d % (w*2+1) ==0)
                {
                    answer+= d/(w*2+1);                
                }
                else{
                    answer+= d/(w*2+1)+1;
                }
            }                
            start= currentStations+w+1;

            
        }
        if(start <=n)
        {
             int d = n  - start;
                
            if(d==0)
            {
                answer+=1;
            
            }
            else if(d % (w*2+1) ==0)
                {
                    answer+= d/(w*2+1);                
                }
                else {
                    answer+= d/(w*2+1)+1;
                }
        }
        
              
            
    

        
        return answer;
      
    }
}
