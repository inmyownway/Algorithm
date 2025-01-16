import java.util.*;
import java.io.*;

public class Main {
    static int V,E;
    static int[] parent;
    static class Node implements Comparable<Node>
    {
        int to;
        int from;
        int d;
        
        public Node(int to,int from,int d)
        {
            this.to=to;
            this.from=from;
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
        
        
        V= Integer.parseInt(st.nextToken());
        E= Integer.parseInt(st.nextToken());
        
        
        parent= new int[V];
        Queue<Node> pq = new PriorityQueue<>();
        
        for(int i=0;i<V;i++)
        {
            parent[i]=i;
        }
        for(int i=0;i<E;i++)
        {
            st= new StringTokenizer(bf.readLine());
            int x= Integer.parseInt(st.nextToken())-1;
            int y= Integer.parseInt(st.nextToken())-1;
            int d= Integer.parseInt(st.nextToken());
            pq.add(new Node(x,y,d));
            
        }
        
        int answer=0;
        int s= pq.size();
        for(int i=0;i<s;i++)
        {
            Node node = pq.poll();
            
            int to = find(node.to);
            int from = find(node.from);
            int d= node.d;
            
            if(!isSame(to,from))
            {
                answer+=d;
                union(node.to,node.from);
            }
            
        }
        System.out.println(answer);
    }
    public static int find(int x)
    {
        if(parent[x] ==x) return x;
        return parent[x] = find(parent[x]);
    }
    public static void union(int x,int y)
    {
        int X= find(x);
        int Y= find(y);
        
        if(X!=Y)
            {
                parent[Y]=X;
            }
    }
    public static boolean isSame(int x,int y)
    {
        x= find(x);
        y= find(y);
        
        if(x==y) return true;
        return false;
    }
}
