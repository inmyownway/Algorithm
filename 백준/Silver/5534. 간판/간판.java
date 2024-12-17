import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int answer;
    static String origin;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        N= Integer.parseInt(st.nextToken());
        
        
        origin = bf.readLine();
        
        for(int i=0;i<N;i++)
        {
            String word = bf.readLine();
          
            int cnt=0;
            boolean check= false;
            for(int start=0;start<word.length();start++)
            {
                for(int gap=1;gap<=word.length();gap++)
                {
                    int idx= start;
                    boolean flag= true;
                    for(int k=0;k<origin.length();k++)
                    {
                        if(idx >= word.length())
                        { 
                            flag= false;
                            break;
                           
                        }
                        if(word.charAt(idx)!=origin.charAt(k))
                        { 
                            flag=false;
                            break;
                           
                        }
                        idx+=gap;
                    }
                    if(flag)
                    {
                    
                        check= true;
                        break;
                    }
                    
                }
                if(check)
                {
                    answer++;
                    break;
                }
            }
        }
        System.out.println(answer);
       }
}
