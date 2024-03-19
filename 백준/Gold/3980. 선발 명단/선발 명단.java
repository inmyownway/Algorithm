import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int C;
    static int[][] board;
    static int answer;
    static boolean[] v;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());


        C=Integer.parseInt(st.nextToken());

        for(int i=0;i<C;i++)
        {
            board=new int[11][11];
            for(int a=0;a<11;a++){
                st= new StringTokenizer(bf.readLine());
                for(int b=0;b<11;b++) {


                    board[a][b]=Integer.parseInt(st.nextToken());
                }
            }

            answer=Integer.MIN_VALUE;
         v=new boolean[11];
            dfs(0,0);
            System.out.println(answer);
        }

    }

    public static void dfs(int idx,int score)
    {

        //System.out.println(idx);
        //System.out.println(Arrays.toString(v));
        if(idx==11)
        {

            answer=Math.max(answer,score);
            return;
        }

        for(int i=0;i<11;i++)
        {
            if(!v[i] && board[idx][i]!=0)
            {
                v[i]=true;
                dfs(idx+1,score+board[idx][i]);
                v[i]=false;
            }
        }
    }
}