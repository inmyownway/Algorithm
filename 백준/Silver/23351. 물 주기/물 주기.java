import java.util.*;
import java.io.*;

public class Main {
    static int N,K,A,B;
    static int[] flower;
    static int day=1;
    public static void main(String[] args) throws IOException{

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        N= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());
        A= Integer.parseInt(st.nextToken());
        B= Integer.parseInt(st.nextToken());
        
        flower = new int[N];
        
        Arrays.fill(flower,K);
        boolean flag= false;
        while(true)
        {
            int idx= findIdx();
            
            for(int i=idx;i<idx+A;i++)
            {
                flower[i]+=B;
                
            }
            
            for(int i=0;i<N;i++)
            {
                flower[i]-=1;
                if(flower[i]==0)
                {
                    flag= true;
                    break;
                }
            }
            
            if(flag)
            {
                break;
            }
                        day++;

        }
        
        System.out.println(day);
    }

    public static int findIdx()
    {
        int sum=Integer.MAX_VALUE;
        
        int idx=-1;
        
        for(int i=0;i<=N-A;i++)
        {
            int s=0;
            for(int j=i;j<i+A;j++)
            {
                s+=flower[j];
            }
            
            if(sum > s)
            {
                idx=i;
                sum=s;
            }
        }
        return idx;
    }
}
