import java.util.*;
import java.io.*;

public class Main {
    static int N,X;
    static int[] arr;
    static int max;
    public static void main(String[] args) throws IOException{

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        N= Integer.parseInt(st.nextToken());
        X= Integer.parseInt(st.nextToken());
        
        arr= new int[N];
        
        st= new StringTokenizer(bf.readLine());
        
        for(int i=0;i<N;i++)
        {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        
        int pre=0;
        int now=0;
        int cnt=1;
        int day=0;
        for(int i=0;i<X;i++)
        {
            now+=arr[i];
        }
        
        max= now;
        int idx=0;
        //System.out.println("now: "+now);
        
                for(int i=X;i<N;i++)
        {
        
            
            now-=arr[idx++];
            now+=arr[i];
             //System.out.println("now: "+now);
        
        
            
                if(max<now)
                {
                    
                    cnt=1;
                    max=now;
                }
            
                else if(now==max){
                     
               
                    cnt++;
               
                }
           
            
        }
        if(max!=0)
        {
             System.out.println(max);
        System.out.println(cnt);
        }
        else{
            System.out.println("SAD");
        }
       
    }
}
