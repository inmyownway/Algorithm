import java.util.*;
class Solution {
    static boolean[] v;
    static int N;
    static int answer;
    static String tar;
    public int solution(String begin, String target, String[] words) {
         answer = Integer.MAX_VALUE;
        System.out.println(answer);
        N= words.length;
        v= new boolean[words.length];
        tar= target;
        dfs(begin,words,0);
        if(answer==Integer.MAX_VALUE)
        {
return 0;}
        return answer;
    }
    public static void dfs(String word ,String[] words,int cnt)
    {
        //System.out.println(word);
        if(word.equals(tar))
        {
          //  System.out.println("@: "+answer+" "+cnt);
            answer=Math.min(answer,cnt);
           // System.out.println(answer);
            return;
        }
        for(int i=0;i<N;i++)
        {
            if(!v[i] && check(word,words[i]))
            {
               // System.out.println("t: "+words[i]);
                v[i]=true;
                dfs(words[i],words,cnt+1);
                v[i]=false;
            }
        }
    }
    public static boolean check(String a,String b)
    {
        int cnt=0;
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)!=b.charAt(i))
            {
                cnt++;
            }
        }
        if(cnt==1)
        {
            return true;
        }
        return false;
    }
}