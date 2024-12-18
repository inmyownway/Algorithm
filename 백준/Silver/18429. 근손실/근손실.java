import java.util.*;
import java.io.*;

public class Main {
    static int N,K;
    static int[] kit;
    static boolean[] v;
    static int answer;
    public static void main(String[] args) throws IOException{

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        N= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());
        
        kit = new int[N];
        v= new boolean[N];
        
        st= new StringTokenizer(bf.readLine());
        
        for(int i=0;i<N;i++)
        {
            kit[i]= Integer.parseInt(st.nextToken());
        }
        
        dfs(0,500);
        System.out.println(answer);
    }
    public static void dfs(int depth,int w)
    {
        if(w<500)
        {
            return;
        }
        
        if(depth>=N)
        {
            answer++;
            return;
        }
        
        for(int i=0;i<N;i++)
        {
            if(!v[i])
            {
                v[i]=true;
                dfs(depth+1,w-K+kit[i]);
                v[i]=false;
            }
        }
    }
}
