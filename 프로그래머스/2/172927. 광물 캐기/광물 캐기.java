import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int picksNum = picks[0]+picks[1]+picks[2];
        
        int[][] p = new int[picksNum][3];
        for(int i=0;i<minerals.length;i+=5)
        {
            if(i/5==picksNum)
            {
                break;
            }
            int[] c = new int[3];
            
            for(int j=i;j<i+5;j++)
            {
                if(j==minerals.length)
                {
                    break;
                }
                
                String m = minerals[j];
                if(m.equals("diamond"))
                {
                    c[0]+=1;
                    c[1]+=5;
                    c[2]+=25;
                }
                else if(m.equals("iron"))
                {
                    c[0]+=1;
                    c[1]+=1;
                    c[2]+=5;
                }
                else if(m.equals("stone"))
                {   c[0]+=1;
                    c[1]+=1;
                    c[2]+=1;
                    
                }
            }
            
            for(int a=0;a<3;a++)
            {
                p[i/5][a]=c[a];
            }
            
            
            
        }
        Arrays.sort(p,(a1,a2) -> (a2[2]-a1[2]));

        for(int i=0;i<picksNum;i++)
        {
            if(picks[0] >0)
            {
                answer+= p[i][0];
                picks[0]--;
            }
            else if(picks[1]>0)
            {
                  answer+= p[i][1];
                picks[1]--;
            }
                        else if(picks[2]>0)
            {
                  answer+= p[i][2];
                picks[2]--;
            }
        }
            
        return answer;
    }
}