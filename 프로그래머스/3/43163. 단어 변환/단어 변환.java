import java.util.*;

class Solution {
    static boolean[] v;
    static int[] num;
    static String t;
    static int answer;
    static int N;
    public int solution(String begin, String target, String[] words) {

        
        v= new boolean[words.length];
        num= new int[words.length];
        t= target;
            N= words.length;
        dfs(begin,0,words);

        return answer;
    }
    public static void dfs(String word,int n,String[] words)
    {   
       // System.out.println("current:  "+word);
        if(word.equals(t))
        {
         //  System.out.println("return");
            answer=n;
            return;
        }

        for(int i=0;i<N;i++)
        {      
            
            if(isOk(word,words[i]))
            {
                
                if(!v[i])
                {
                   // System.out.println(words[i]);
                    num[i]=n+1;
                      v[i]=true;
                  dfs(words[i],n+1,words);
                  
                }
                else if(v[i] && num[i] > n+1)
                {
                     // System.out.println(words[i]);
                    num[i]=n+1;
                    dfs(words[i],n+1,words);
                    
                }
            }
        }
    }
    public static boolean isOk(String a,String b)
    {
        //System.out.println(a+"   "+b);
        
        int c=0;
        
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i) != b.charAt(i))
            {
                c++;
            }
        }
        //System.out.println(c);
        if(c==1)
        {
            return true;
        }
        return false;
    }
}