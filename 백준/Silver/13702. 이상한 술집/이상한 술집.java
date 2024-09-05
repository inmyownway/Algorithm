import java.util.*;
import java.io.*;
public class Main {
    static int N,K;
    static int[] bottle;
    static int sum=0;
    public static void main(String[] args) throws IOException{

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        N= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());
             
    bottle= new int[N];
    long left=1;
    long right=0;
    for(int i=0;i<N;i++)
    {
        bottle[i] = Integer.parseInt(bf.readLine());
        right= Math.max(right,bottle[i]);
    }   
    
        long mid =0;
        while(left<=right)
        {
            
            mid = (left+right)/2;
            
            int cnt=0;
            for(int i=0;i<N;i++)
            {
                cnt+= bottle[i]/mid;
            }
            if(cnt>=K)
            {         left=mid+1;
         
            }
            else{
              right=mid-1;
            }
        }
        System.out.println(right);
    }
}