import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int N=9;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board= new int[N][N];

        for(int i=0;i<N;i++)
        {
            st= new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++)
            {
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
    }
    public static void dfs(int x,int y)
    {

        if(x==N)
        {

            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)

                {
                    System.out.print(board[i][j]+" ");
                }
                if(i!=N-1)
                    System.out.println();
            }
         System.exit(0);
        }

        if(board[x][y]==0)
        {
            for(int num=1;num<=9;num++)
            {
                if(isValid(x,y,num))
                {
                    board[x][y]=num;
                    int nextY = (y+1)%N;
                    int nextX= x;

                    if(nextY==0)
                        nextX++;
                    dfs(nextX,nextY);
                    board[x][y]=0;
                }
            }

        }
        else
        {
            int nextY = (y+1)%N;
            int nextX= x;

            if(nextY==0)
                nextX++;
            dfs(nextX,nextY);
        }



    }
    public static boolean isValid(int x,int y,int num)
    {
        for(int i=0;i<N;i++)
        {
            if(board[x][i] == num || board[i][y]==num)
                return false;
        }

        int startX= (x/3)*3;
        int startY= (y/3)*3;

        for(int i=startX;i<startX+3;i++)
        {
            for(int j=startY;j<startY+3;j++)
            {
                if (board[i][j]==num)
                    return false;
            }
        }
        return true;
    }

}