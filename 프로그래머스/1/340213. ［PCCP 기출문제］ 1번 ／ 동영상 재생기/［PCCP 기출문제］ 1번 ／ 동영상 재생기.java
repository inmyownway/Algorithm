
import java.util.*;

class Solution {
    static int VIDEO_LEN,POS,OP_START,OP_END;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        VIDEO_LEN = minToSecond(video_len);
        POS = minToSecond(pos);
        OP_START = minToSecond(op_start);
        OP_END= minToSecond(op_end);
        
        //System.out.println(VIDEO_LEN +" "+POS+" "+OP_START+" "+OP_END);
        
        for(String com:commands)
        {
            // 먼저 open 사이에있나 체크
            
            if(POS >= OP_START && POS<= OP_END)
            {
                POS = OP_END;
            }
            
            if(com.equals("next"))
            {
                POS += 10;
                if(POS>= VIDEO_LEN)
                {
                    POS=VIDEO_LEN;
                }
            }
            else if(com.equals("prev"))
            {
                POS-=10;
                if(POS<0)
                {
                    POS=0;
                }
            }
            
        }
         if(POS >= OP_START && POS<= OP_END)
            {
                POS = OP_END;
            }
        answer= secondToMin(POS);
        return answer;
    }
    public static int minToSecond(String time)
    {
        int temp=0;
        
        String[] t= time.split("");
        
     temp = Integer.parseInt(t[0])*600 + Integer.parseInt(t[1])*60 + Integer.parseInt(t[3])*10 + Integer.parseInt(t[4]);        
      
        return temp;
    }
    public static String secondToMin(int time)
    {
        String str="";
        
        String hour = String.valueOf(time/600);
        time%=600;
        String min = String.valueOf(time/60);
        time%=60;
        
        String sec = String.valueOf(time);
        if(sec.length()==1)
        {
            sec="0"+sec;
        }
        
        return hour+min+":"+sec;
    }
}