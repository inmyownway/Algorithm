import java.util.*;
import java.io.*;

public class Main {
    static int N,M,S;
    static int[][] board;
    static ArrayList<Integer>[] arr;
    static int[] order;
    static boolean[] v;
    static int o=1;
    public static void main(String[] args) throws IOException{

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        S= Integer.parseInt(st.nextToken());
        
        arr= new ArrayList[N+1];
        for(int i=0;i<N+1;i++)
        {
            arr[i]= new ArrayList<>();
        }
        
    
    for(int i=0;i<M;i++)
    {
        st= new StringTokenizer(bf.readLine());
        int x= Integer.parseInt(st.nextToken());
        int y= Integer.parseInt(st.nextToken());
        
        arr[x].add(y);
        arr[y].add(x);
    }
    for(int i=0;i<N+1;i++)
    {
        Collections.sort(arr[i]);
       // System.out.println(arr[i]);
    }
    
    
    StringBuilder sb= new StringBuilder();
    
       
    order= new int[N+1];
    v= new boolean[N+1];
    dfs(S);

    for(int i=1;i<N+1;i++)
    {
        sb.append(order[i]+"\n");
        
    }
        
        System.out.println(sb);
     
        
     
    }
    public static void dfs(int s)
    {
        order[s]=o++;
            
                v[s]=true;

        for(int idx: arr[s])
        {
            if(!v[idx])
            {
                dfs(idx);
            }
        }
        
    }
}
