import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String,Integer> map= new HashMap<>();
        
        for(String[] clo:clothes)
        {
            if(map.containsKey(clo[1]))
            {
                map.put(clo[1],map.get(clo[1])+1);
            }
            else{
                map.put(clo[1],1);
            }
        }
        
        for(Integer v: map.values())
        {
            answer*=v+1;
            
        }
        return answer-1;
    }
}