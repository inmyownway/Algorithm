import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
    
        
        int num = s/n;
        int div = s%n;


        if(n==1 && s==1)
            return new int[]{-1};
        if(s==1)
            return new int[]{-1};
        if(n==1)
            return new int[]{-1};
                if(n > s) {
            return new int[]{-1};
        }
        
        for(int i=0;i<n;i++)
        { 
            int x=0;
            if(i>=n-div)
                x=1;
            answer[i]=num+x;
        }
        
        
        
        return answer;
    }
}   
