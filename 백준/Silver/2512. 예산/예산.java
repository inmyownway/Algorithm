import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int answer,money;
    public static void main(String[] args) throws IOException{

    BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(bf.readLine());
    
    
    N= Integer.parseInt(st.nextToken());
    arr= new int[N];
    st= new StringTokenizer(bf.readLine());
    for(int i=0;i<N;i++)
    {
        arr[i]= Integer.parseInt(st.nextToken());
        
        
    }
    st= new StringTokenizer(bf.readLine());
    money= Integer.parseInt(st.nextToken());
    Arrays.sort(arr);
    int left=0;
    int right= arr[N-1];
    
    while(left<=right)
    {
        int mid= (left+right)/2;
        
        long b=0;
        
        for(int i=0;i<N;i++)
        {
            if(arr[i]>mid) {
                b+=mid;
            }
            else{
                b+=arr[i];
            }
        }
        if(b<=money)
        {
            left= mid+1;
            
        }
        else{
            right=mid-1;
        }
        
    }
    System.out.println(right);
    
    
    }
}
