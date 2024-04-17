import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int V,E;
    static int[][] board;
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());

        board= new int[V][V];
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {


                board[i][j]=Integer.MAX_VALUE/4;

            }
        }
        for(int i=0;i<E;i++)
        {
            st= new StringTokenizer(bf.readLine());
            int x= Integer.parseInt(st.nextToken())-1;
            int y= Integer.parseInt(st.nextToken())-1;
            int d= Integer.parseInt(st.nextToken());

            board[x][y]=d;

        }



        for(int k=0;k<V;k++)
        {
            for(int i=0;i<V;i++)
            {
                for(int j=0;j<V;j++)
                {

board[i][j]=  Math.min(board[i][j],board[i][k]+board[k][j]);

                }
            }
        }


        int answer= Integer.MAX_VALUE;

        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
                if( board[i][j]!=Integer.MAX_VALUE/4 && board[j][i]!=Integer.MAX_VALUE/4
                )
                {
                    answer=Math.min(answer,board[i][j]+board[j][i]);
                }
            }
        }


        if(answer==Integer.MAX_VALUE)
            answer=-1;
        System.out.println(answer);
    }
}