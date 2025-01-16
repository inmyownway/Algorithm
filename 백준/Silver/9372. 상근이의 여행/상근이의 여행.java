import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static ArrayList<Integer>[] arr;
    static int answer=0;
    static boolean[] v;
    public static void main(String[] args) throws IOException{

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        int testCase= Integer.parseInt(st.nextToken());
        
        StringBuilder sb= new StringBuilder();
        for(int t=0;t<testCase;t++)
        {
            st= new StringTokenizer(bf.readLine());
            N= Integer.parseInt(st.nextToken());
            M= Integer.parseInt(st.nextToken());
            
            arr= new ArrayList[N];
            
            for(int i=0;i<N;i++)
            {
                
                arr[i]= new ArrayList<>();
            }
            
            for(int i=0;i<M;i++)
            {st= new StringTokenizer(bf.readLine());
                int x=Integer.parseInt(st.nextToken())-1;
                int y=Integer.parseInt(st.nextToken())-1;
                arr[x].add(y);
                arr[y].add(x);
                
            }
             
            answer=0;
   
            Queue<Integer> q= new LinkedList<>();
            q.add(0);
            v= new boolean[N];
            int result=0;
            
            while(!q.isEmpty())
            {
                int now = q.poll();
                
                for(int n: arr[now])
                {
                    if(!v[n])
                    {
                        result++;
                        q.add(n);
                        v[n]=true;
                    }
                }
            }
            System.out.println(result-1);
        } 
    }
}
