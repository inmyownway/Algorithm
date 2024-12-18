import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int answer= Integer.MAX_VALUE;

    static int[] v;
    public static void main(String[] args) throws IOException{

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        N= Integer.parseInt(st.nextToken());
        
        st= new StringTokenizer(bf.readLine());
        
        arr= new int[N];
        v=new int[N];
        Arrays.fill(v,Integer.MAX_VALUE);
        for(int i=0;i<N;i++)
        {
            arr[i]= Integer.parseInt(st.nextToken());    
        }
        
        
    
        bfs();
   
     if(answer== Integer.MAX_VALUE)
        {
            System.out.println(-1);
        }else{
        System.out.println(answer);
    }
    }
    public static void bfs()
    {
    
    Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{0,0});
        v[0]=0;
        while(!q.isEmpty())
        {
            int[] now = q.poll();
            
            int idx= now[0];
            int cnt= now[1];
            
            if(idx==N-1)
            {
                answer= cnt;
                return;
            }
            
         
            for(int next= idx+1 ; next<=idx+arr[idx];next++)
            {
                if(next>=N)
                {
                    continue;
                }
                if(v[next]>cnt+1)
                {
                      v[next]=cnt+1;
                    q.add(new int[]{next,cnt+1});
                  
                }
            }
        }
    }
}
