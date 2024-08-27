import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int[] arr;
    static int answer= Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        
        N= Integer.parseInt(st.nextToken());
        arr= new int[N];
        String str= bf.readLine();
        for(int i=0;i<N;i++)
        {
            if(str.charAt(i)=='R')
            {
                arr[i]=1;
            }
            else{
                arr[i]=0;
            }
        }
        // 코드를 작성해주세요
        
        for(int i=0;i<=1;i++)
        {
            check(i);
        }
        System.out.println(answer);
    }
    public static void check(int ball)
    {
        // 0은 blue
        
        int lastIdx=N-1;
        boolean all = false;
        while(true){
            if(lastIdx<0)
            {
                all=true;
                break;
            }
            if(arr[lastIdx]!=ball)
            {
                break;
            }
            lastIdx--;
        }  
        int cnt=0;
        for(int i=0;i<lastIdx;i++)
        {
            if(arr[i]==ball)
            {
                cnt++;
            }
        }
        answer= Math.min(answer,cnt);
        
    }
}
