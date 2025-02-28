import java.util.*;
import java.io.*;

public class Main {
    static int T;
    
    public static void main(String[] args) throws IOException{

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        StringBuilder sb= new StringBuilder();
        T= Integer.parseInt(st.nextToken());
        for(int t=0;t<T;t++)
        {
            st= new StringTokenizer(bf.readLine());
            int N= Integer.parseInt(st.nextToken());
            String[] arr= new String[N];
            
            String str= bf.readLine();
          
            
        
            arr= str.split(" ");
            
            String answer=""+arr[0];
            
            for(int idx=1;idx<arr.length;idx++)
            {
                if(answer.charAt(0)-'0' < arr[idx].charAt(0)-'0')
                {
                    answer += arr[idx];
                }
                else{
                    answer= arr[idx]+answer;
                }
                
            }
            sb.append(answer+"\n");
            
         
            
        }
        System.out.println(sb);
    }
}
