import java.util.*;

class Solution {    
    public static int check(String str1,String str2)
    {   
        int differentCnt=0;
        for(int i=0;i<str1.length();i++)
        {
            if(str1.charAt(i)!=str2.charAt(i))
            {
                differentCnt++;
            }
        }
      return differentCnt;
    }
    static boolean[] v;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        v= new boolean[words.length];
        
        Queue<String[]> q= new LinkedList<>();
        q.add(new String[]{begin,"0"});
        
        while(!q.isEmpty())
        {
            String[] now= q.poll();
            String current = now[0];
                int cnt= Integer.parseInt(now[1]);
            if(current.equals(target))
            {
                answer=cnt;
                break;
            }
  
            for(int i=0;i<words.length;i++)
            {       
                String str= words[i];
                if(!v[i] && check(current,str)==1)
                {
                    v[i]=true;
                    cnt++;
                    q.add(new String[]{str,String.valueOf(cnt)});
                    
                
                }
            }
        }
        return answer;
    
    }

}