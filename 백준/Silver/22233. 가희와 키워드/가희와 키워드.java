import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static HashSet<String> h;
    public static void main(String[] args) throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        
        h= new HashSet<>();
        for(int i=0;i<N;i++)
        {
            h.add(bf.readLine());
        }
        
        for(int i=0;i<M;i++)
        {
            String s= bf.readLine();
            String[] str= s.split(",");
            
            for(int j=0;j<str.length;j++)
            {
                if(h.contains(str[j]))
                {
                    h.remove(str[j]);
                }
            }
            
                System.out.println(h.size());
        }
    
    }
}
