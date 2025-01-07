import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    
   public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        
        Map<String,Integer> map= new HashMap<>();
        
        for(int i=0;i<N;i++)
        {
            String str= bf.readLine();
            
            
            if(str.length()<M)
            {
                continue;
            }            
            
            map.put(str,map.getOrDefault(str,0)+1);
        }
        
        List<String> words = new ArrayList<>(map.keySet());
        
        
        Collections.sort(words,new Comparator<String>()
        {
            @Override
            public int compare(String o1,String o2)
            {
                if(Integer.compare(map.get(o1),map.get(o2)) !=0)
                {
                    return Integer.compare(map.get(o2),map.get(o1));  
                      
                }
                
                if(o1.length() != o2.length())
                {
                    return o2.length()-o1.length();
                }
                
                return o1.compareTo(o2);
            }
        });
        
        StringBuilder sb= new StringBuilder();
        for(String str: words)
        {
            sb.append(str+"\n");
        }
        
        System.out.println(sb);
        
        
        
        
    }
}
