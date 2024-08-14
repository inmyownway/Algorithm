import java.util.*;
import java.io.*;
public class Main {
    static String str;
    static int answer;
    public static void main(String[] args) throws IOException{
        
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        
        str= bf.readLine();
        answer = str.length();
        
        while(true)
        {
            if(check(str))
            {
                System.out.println(answer);
                break;    
            }
            answer++;
            
            String newStr="";
            for(int idx=1;idx<str.length();idx++)
            {
                newStr+= str.charAt(idx);
                
            }
            str= newStr;
        
        }
        

    }
    public static boolean check(String str)
    {
        for(int idx=0;idx<str.length()/2;idx++)
        {
            if(str.charAt(idx)!= str.charAt(str.length()-1-idx))
            {
                return false;
            }
        }
        return true;
    }
}
