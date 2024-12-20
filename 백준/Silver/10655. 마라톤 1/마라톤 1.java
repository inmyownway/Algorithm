import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] distance;
    static ArrayList<int[]> arr;
    
    public static void main(String[] args) throws IOException{

        
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        N= Integer.parseInt(st.nextToken());
        
        distance= new int[N];
        
        arr= new ArrayList<>();        
        for(int i=0;i<N;i++)
        {
        
            st= new StringTokenizer(bf.readLine());
            
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            
            arr.add(new int[]{a,b}); 
        }
        
        int sum=0;
        for(int i=1;i<N;i++)
        {
        
        int[] pre= arr.get(i-1);
        int[] now= arr.get(i);
        sum+=  Math.abs(now[0]-pre[0])+Math.abs(now[1]-pre[1]);
        distance[i] =  Math.abs(now[0]-pre[0])+Math.abs(now[1]-pre[1]);
             
        }
      
        int answer=Integer.MAX_VALUE;
       // System.out.println(sum);
        
        for(int i=1;i<N-1;i++)
        {   
           
           
            answer= Math.min(answer,sum - findDis(i,i-1) -findDis(i,i+1) +findDis(i-1,i+1));
           // System.out.println(answer);
        }
        // 20 - 7 
        // 
        System.out.println(answer);
    }
    public static int findDis(int n,int p)
    {
        
           int[] now= arr.get(n);
         int[] pre= arr.get(p);
      
         return Math.abs(now[0]-pre[0])+Math.abs(now[1]-pre[1]);
    }
}
