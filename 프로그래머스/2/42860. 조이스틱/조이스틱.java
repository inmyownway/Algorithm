class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int l = name.length()-1;
        
        for(int i=0;i<name.length();i++)
        {
            int move = Math.min(name.charAt(i)-'A',26-(name.charAt(i)-'A'));
            answer += move;
            
            
            if(i < name.length()-1 && name.charAt(i+1)=='A')
            {   
                int end= i+1;
                while(end<name.length() && name.charAt(end)=='A')
                {
                    end++;
                }
                
                l= Math.min(l,i*2 + (name.length()-end));
                l= Math.min(l,i+(name.length()-end)*2);                
            }
        }
        return answer+l;
    }
}