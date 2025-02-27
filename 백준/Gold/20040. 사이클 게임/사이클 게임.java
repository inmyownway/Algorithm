import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] parents;
   

    public static void main(String[] args) throws IOException{
       
    
    BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(bf.readLine());
    
    N= Integer.parseInt(st.nextToken());
    M= Integer.parseInt(st.nextToken());
    
    parents = new int[N];
    
    int cnt=0;
    make();
    boolean flag=false;
        for(int i=0;i<M;i++)
    {
        st= new StringTokenizer(bf.readLine());
        
        int a= Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());
       
                if(isSame(a,b))
        {
            System.out.println(i+1);
            return;
            
        }
        else{
            union(a,b);
        }
        //System.out.println(a +": "+ find(a)+ "   "+b+ ": "+find(b) );

    }
    // if(flag){
    // System.out.println(cnt);
    // }
    // else{
        System.out.println(0);
    //}
   }
    public static void make()
    {
        for(int i=0;i<N;i++)
        {
            parents[i]=i;
        }
    }
    public static boolean isSame(int x,int y)
    {
        if(find(x)==find(y))
        {
            return true;
        }
        return false;
    }
    public static void union(int x,int y)
    {
        x= find(x);
        y= find(y);
        
        if(x<y)
        {
            parents[y]=x;
        }
        else{
            parents[x]=y;
        }
        
    }
    public static int find(int x)
    {
        if(x==parents[x])
        {
            return x;
        }
        return parents[x]=find(parents[x]);
    }
}
