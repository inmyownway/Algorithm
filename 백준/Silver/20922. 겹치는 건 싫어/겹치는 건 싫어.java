import java.util.*;
import java.io.*;

public class Main {
    
    static int N,K;
    static int[] arr;
    public static void main(String[] args) throws IOException{

    BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(bf.readLine());

    N= Integer.parseInt(st.nextToken());
    K= Integer.parseInt(st.nextToken());
    
    st= new StringTokenizer(bf.readLine());
    arr= new int[N];
    for(int i=0;i<N;i++)
    {
        arr[i]= Integer.parseInt(st.nextToken());
    }
    
    int answer=0;
    int start=0;
    int end=0;
    int[] cnt= new int[100001];
    
    while(end < arr.length)
    {
        while(end < arr.length && cnt[arr[end]]+1 <= K)
        {     cnt[arr[end]]++;
            end++;
       
        }
        int len= end-start;
        answer= Math.max(len,answer);
        cnt[arr[start]]--;
        start++;
        
    }
    System.out.println(answer);
    
    }
}
