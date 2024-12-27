import java.util.*;
import java.io.*;

public class Main {
    static int testCase;
    static int N;
    static int[] team;
    static int[] teamCnt;
    static int[] teamScore;
    static int[] fiveMember;
    static int[] score;
    static int[] scoreCnt;
    public static void main(String[] args) throws IOException{
    
    BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(bf.readLine());
    
    // 등수 
    testCase= Integer.parseInt(st.nextToken());
    
    for(int t= 0 ;t<testCase;t++)
    {
        N= Integer.parseInt(bf.readLine());

        
        st= new StringTokenizer(bf.readLine());

       team= new int[N+1];
        score= new int[N+1];

        teamCnt= new int[201];
        fiveMember = new int[201];
        teamScore= new int[201];
        scoreCnt= new int[201];
        
        
        for(int i=1;i<N+1;i++)
        {
            int teamNum=  Integer.parseInt(st.nextToken());
            
        
            team[i]=teamNum;
                    
                teamCnt[teamNum]++;
            
        }
        
        int s=1;
       // System.out.println(Arrays.toString(teamCnt));
        for(int i=1;i<N+1;i++)
        {
            if(teamCnt[team[i]]<6)
            {
               
                continue;
            }
            score[i]=s++;
            
            
        }
        
        
        
        //System.out.println(Arrays.toString(score));
        //System.out.println();
        
        for(int i=1;i<N+1;i++)
        {
            int teamNumber= team[i];
            
            if(teamCnt[teamNumber]==6 )
            {
                if( scoreCnt[teamNumber]<4){
                teamScore[teamNumber]+= score[i];
                scoreCnt[teamNumber]++;
                }
                else if(scoreCnt[teamNumber]==4)
                {
                    if(fiveMember[teamNumber]==0){
                   
                    fiveMember[teamNumber]= score[i];
                    }
                    
                }
            }         //   System.out.println(teamNumber+" score: "+ teamScore[teamNumber]);

        }
        
     
        
        
        int answer=Integer.MAX_VALUE;
        int idx=-1;
        
        int result=-1;
        
       // System.out.println(Arrays.toString(teamScore));
      // System.out.println(Arrays.toString(fiveMember));
        for(int i=1;i<201;i++)
        
        {
            if(teamScore[i]!=0){
                
            if(answer>teamScore[i])
            {
               answer= teamScore[i];
                idx= i;
            }    
            else if(answer == teamScore[i])
            {
                if(fiveMember[idx] >fiveMember[i])
                {
                    idx= i;
                }
            }
                 
            
            }
        }
        System.out.println(idx);
        
        
    }
    }
}
