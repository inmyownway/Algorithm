import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
      
        
        int aCnt=1;
        int bCnt=0;
        
        char alpha= s.charAt(0);
        
        for(int idx=1;idx<s.length();idx++)
        {
            if(aCnt==0 && bCnt==0)
            {
                alpha=s.charAt(idx);
                aCnt=1;
                continue;
              
            }
            if(alpha== s.charAt(idx))
            {
                aCnt++;
            }
            else{
                bCnt++;
            }
            
            if(aCnt==bCnt)
            {
                answer++;
                aCnt=0;
                bCnt=0;
            }
            

        }

           if (aCnt != 0 || bCnt != 0) {
            answer++;
        }
      
            
       
        return answer;
    }
}