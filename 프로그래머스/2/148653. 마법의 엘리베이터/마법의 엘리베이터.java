class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        int num= storey;
        while(num>0)
        {
            int d = num%10;
            
            num/=10;
            
            if(d==5)
            {
                if(num%10>=5)
                {
                    
                  
                    num++;
                }
             
                answer+=d;
            }
            else if(d>5)
            {
                num++;
                answer+= 10-d;
            }
            else{
                answer+=d;
            }
            
        }
        return answer;
    }
}