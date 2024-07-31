import java.util.*;
import java.io.*;
public class Main {
    static int N,M,K;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
       
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        int testCase= Integer.parseInt(st.nextToken());
        
     
        
        for(int t=0;t<testCase;t++){   st= new StringTokenizer(bf.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());
        
        arr= new int[N];
        st= new StringTokenizer(bf.readLine());
        
        for(int i=0;i<N;i++)
        {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        
        // init
        int sum=0;
        int temp=0;
        for(int i=0;i<M;i++)
        {
            temp+=arr[i];
        }  
        
        int cnt=0;
        if(temp<K)
        {
      
            cnt++;
            
        }
        if(N==M)
        {
            System.out.println(cnt);
             continue;
        }
        
           //   System.out.println(temp);
       
        for(int i=1;i<N;i++)
        {
        
            temp -= arr[i-1];
        
            // 1 2 3 4
            if(i+M-1 >= N )
            {
                temp+=arr[(i+M-1)%N];
            }
            else{
                temp+=arr[i+M-1];
            }
                
            if(temp <K )
            {
                sum= temp;
                cnt++;
            }
            //  System.out.println("temp: "+temp);
        }
        
        
                    System.out.println(cnt);

        }
        
        
        
        
        
        
        
        
    }
}