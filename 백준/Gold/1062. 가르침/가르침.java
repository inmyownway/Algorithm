import java.util.Scanner;

public class Main {

    static int N,K;
    static int maxNum = Integer.MIN_VALUE;
    static boolean[] visited;
    static String[] word;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N=sc.nextInt();
        K=sc.nextInt();

        sc.nextLine();
        word=new String[N];
        for(int i=0;i<N;i++)
        {
            String str = sc.nextLine();
            str = str.replace("anta","");
            str= str.replace("tica","");
            word[i]=str;
        }

        if(K<5)
        {
            // 아무것도 읽을 수 없음
            System.out.println("0");
            return;
        }
        else if(K==26)
        {
            // 모든 단어 읽을수 있음
            System.out.println(N);
            return;
        }

        visited = new boolean[26]; //각 알파벳을 배웠는지 체크
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        dfs(0,0);
        System.out.println(maxNum);
    }


    public static void dfs(int alpha,int len)
    {
        if(len==K-5)
        {
            int count=0;
            for(int i=0;i<N;i++)
            {
                boolean read = true;
                for(int j=0;j<word[i].length();j++)
                {
                    if(!visited[word[i].charAt(j)-'a'])
                    {
                        read=false;
                        break;
                    }
                }
                if(read) count++;
            }
            maxNum=Math.max(maxNum,count);
            return;
        }

        for(int i=alpha;i<26;i++)
        {
            if(visited[i]==false)
            {
                visited[i]=true;
                dfs(i,len+1);
                visited[i]=false;
            }
        }

    }
    
}