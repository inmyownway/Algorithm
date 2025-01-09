import java.util.*;
import java.io.*;

public class Main {
    
    static class Beer implements Comparable<Beer>{
        int prefer;
        int alchol;
        
        public Beer(int prefer,int alchol)
        {
            this.prefer=prefer;
            this.alchol=alchol;
            
        }
        
        @Override 
        public int compareTo(Beer o)
        {
            if(this.alchol==o.alchol)
            {
                return o.prefer- this.prefer;
            }
            return this.alchol-o.alchol;
            
        }
    }
    static int N,M,K;
    
    static ArrayList<Beer> beer;
    static int left,right;
    public static void main(String[] args) throws IOException{

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());
        
        beer= new ArrayList<>();
        
        
        for(int i=0;i<K;i++)
        {
            
            st= new StringTokenizer(bf.readLine());
            int v= Integer.parseInt(st.nextToken());
            int c=  Integer.parseInt(st.nextToken());
            right= Math.max(right,c);
            beer.add(new Beer(v,c));
        
        }
        
        Collections.sort(beer);
        
        int total= 0;
        int answer=-1;
        
        Queue<Integer> q= new PriorityQueue<>();
   
        for(Beer b: beer)
        {
            q.add(b.prefer);
            
            total += b.prefer;
            
            if(q.size()>N)
            {
                total-=q.poll();
                
            }
            
            if(q.size()==N && total >= M)
            {
                answer= b.alchol;
                break;
            }
        }
        
        System.out.println(answer);
    }
}
