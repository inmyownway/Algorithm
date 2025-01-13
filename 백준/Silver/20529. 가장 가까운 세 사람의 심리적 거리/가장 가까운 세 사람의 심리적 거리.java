import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] mbti;
    static int answer= Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
     
    BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(bf.readLine());
    
    
    int testCase= Integer.parseInt(st.nextToken());
    
    for(int t=0;t<testCase;t++)
    {
        answer= Integer.MAX_VALUE;
        st= new StringTokenizer(bf.readLine());
        N= Integer.parseInt(st.nextToken());

        st= new StringTokenizer(bf.readLine());
        
        if(N>32)
        {
            System.out.println(0);
            continue;
        }
   
        
        String[] arr= new String[N];
        
        for(int i=0;i<N;i++)
        {
      
           
            arr[i]= st.nextToken();

            
        }
        
        
        for(int a=0;a<N;a++)
            {
                for(int b=a+1;b<N;b++)
                {
                    for(int c=b+1;c<N;c++)
                    {
                        int cnt=0;
                        for(int idx=0;idx<4;idx++)
                        {
                            if(arr[a].charAt(idx)!=arr[b].charAt(idx))
                            {
                                cnt++;
                            }
                            
                             if(arr[a].charAt(idx)!=arr[c].charAt(idx))
                            {
                                cnt++;
                            }
                            
                             if(arr[c].charAt(idx)!=arr[b].charAt(idx))
                            {
                                cnt++;
                            }
                        }
                        
                        answer= Math.min(cnt,answer);
                        if(answer==0)
                        {
                            break;
                        }
                    }
                }
            }
            
            System.out.println(answer);
        
        
        
      
                 
    }

}}
