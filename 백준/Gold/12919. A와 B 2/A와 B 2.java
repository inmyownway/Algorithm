import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String S,T;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        S=bf.readLine();
        T=bf.readLine();


        dfs(T);
        System.out.println(answer);

    }
    public static void dfs(String str)
    {
       // System.out.println(str);
        if(str.length()<S.length())
            return;

        if(str.length()==S.length())
        {
            if(str.equals(S))
                answer=1;
            else
                return;
        }

        String temp =str;

        if(temp.charAt(temp.length()-1)=='A')
        {
            temp=temp.substring(0,temp.length()-1);

            dfs(temp);
        }
        temp= str;

        // ABAB
        // ABABB

        // BBABA
        // 맨앞이 B면 제거
        // BABA
        if(temp.charAt(0)=='B')
        {
            temp= temp.substring(1,temp.length());
            String r= "";
            for(int i=temp.length()-1;i>-1;i--)
            {
                r+=temp.charAt(i);
            }
            dfs(r);
        }

        return;

    }

}