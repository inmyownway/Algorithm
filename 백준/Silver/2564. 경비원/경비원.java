import java.util.*;
import java.io.*;

public class Main {

    static int rx,ry;
    static int N,M;
    static ArrayList<Integer> arr;
    public static void main(String[] args) throws IOException{
        
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
     
        
        M= Integer.parseInt(st.nextToken());
        N= Integer.parseInt(st.nextToken());
        
       arr= new ArrayList<>();
        
        int n = Integer.parseInt(bf.readLine());
        
        for(int i=0;i<n;i++)
        {
            int d=0;
            int idx=0;
    
            st= new StringTokenizer(bf.readLine());        
            d= Integer.parseInt(st.nextToken());
            idx= Integer.parseInt(st.nextToken());
        
           
            int num= simul(d,idx);
            arr.add(num);
        }
          st= new StringTokenizer(bf.readLine());
            rx= Integer.parseInt(st.nextToken());
            ry= Integer.parseInt(st.nextToken());
            
            int rNum = simul(rx,ry);
            
            int answer=0;
            
            int total= 2*N+2*M;
        for(int i=0;i<n;i++)
            {
              
            int target= arr.get(i);
            
            
                    answer+=Math.min(Math.abs(rNum-target),total-Math.abs(rNum-target));
            }
            System.out.println(answer);
    }
    public static int simul(int d,int idx)
    {
         if(d==1)
            {
                return idx;
            }
            else if(d==2)
            {
               return N+M+(M-idx);
            }
            else if(d==3)
            {
                return (2*M)+N+(N-idx);
            }
            else if(d==4)
            {
                return M+idx;
            }
            
            return 0;
            
    }
}
