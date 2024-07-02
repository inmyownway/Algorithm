import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
    
    BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(bf.readLine());
    
    int N = Integer.parseInt(st.nextToken());
    int[] arrA= new int[N];
    int[] arrB= new int[N];
     st= new StringTokenizer(bf.readLine());
    for(int i=0;i<N;i++)
    {
        arrA[i]=Integer.parseInt(st.nextToken());
    }
    
        st= new StringTokenizer(bf.readLine());
    for(int i=0;i<N;i++)
    {
        arrB[i]=Integer.parseInt(st.nextToken());
    }
    
    Arrays.sort(arrA);
    Arrays.sort(arrB);
    int[] b= new int[N];
    
    for(int i=0;i<N;i++)
    {
        b[i]=arrB[arrB.length-1-i];
    }
    
    long sum=0;
    for(int i=0;i<N;i++)
    {
        sum+= arrA[i]*b[i];
    }
    System.out.println(sum);
    
    }
    
}
