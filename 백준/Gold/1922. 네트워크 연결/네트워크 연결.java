import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] board;
    static int[] parents;
    static ArrayList<Node> arr;
    static int answer;
    static class Node implements Comparable<Node>{
        int x;
        int y;
        int d;
        
        public Node(int x,int y,int d)
        {
            this.x=x;
            this.y=y;
            this.d=d;
        }
        @Override
        public int compareTo(Node o)
        {
            return this.d-o.d;
        }
        
    }
    public static void main(String[] args) throws IOException{

    
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(bf.readLine());
       
        parents= new int[N];
        for(int i=0;i<N;i++)
        {
            parents[i]=i;
        }
        arr= new ArrayList<>();
        
        for(int i=0;i<M;i++)
        {
            st= new StringTokenizer(bf.readLine());
            
            int x = Integer.parseInt(st.nextToken())-1;
            int y= Integer.parseInt(st.nextToken())-1;
            int d= Integer.parseInt(st.nextToken());
            arr.add(new Node(x,y,d));
            
        }
        Collections.sort(arr);
   
        for(int i=0;i<M;i++)
        {
            
            Node now = arr.get(i);
            
            if(find(now.x) != find(now.y))
            {
                answer += now.d;
                union(now.x,now.y);
            }
        }
        System.out.println(answer);
        
    }
    public static int find(int x)
    {
        if(x==parents[x])
        {
            return x;
        }
        return parents[x]=find(parents[x]);
    }
    public static void union(int x,int y)
    {
        int a= find(x);
        int b= find(y);
        
        if(a!=b)
        {
            parents[b]=a;
        }
    }
}
