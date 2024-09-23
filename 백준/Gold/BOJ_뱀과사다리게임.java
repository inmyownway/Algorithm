import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] ladder;;
    static int[] snake;
    static boolean[] v;
    static int answer= Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        
        ladder= new int[101];
        snake= new int[101];
        
        for(int i=0;i<N;i++)
        {
            st= new StringTokenizer(bf.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            ladder[x]=y;
        }
        
        for(int i=0;i<M;i++)
        {
            st= new StringTokenizer(bf.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            snake[x]=y;
        }
        v= new boolean[101];
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{1,0});
        v[1]=true;   
        
        while(!q.isEmpty())
        {
            int[] nowPos= q.poll();
            
            int now= nowPos[0];
            
            int num = nowPos[1];
            if(num>answer)
            {
                continue;
            }
            for(int idx=1;idx<=6;idx++)
            {
                if(now+idx<=100 && !v[now+idx])
                {
                    if(now+idx==100)
                    {
                        answer= Math.min(answer,num);
                        continue;
                    }
                    v[now+idx]=true;
                    boolean flag= false;
                    
                    if(ladder[now+idx]!=0)
                    {
                        q.add(new int[]{ladder[now+idx],num+1});
                        v[now+idx]=true;
                    }
                    else if(snake[now+idx]!=0)
                    {
                        q.add(new int[]{snake[now+idx],num+1});
                        v[now+idx]=true;
                    }
                    else{
                        q.add(new int[]{now+idx,num+1});
                        v[now+idx]=true;
                    }
                    
                    
                }
            }    
        }
        System.out.println(answer+1);
        
    }
}
