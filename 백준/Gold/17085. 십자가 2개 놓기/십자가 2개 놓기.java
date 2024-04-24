import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static char[][] board;
    static int[] dx= {0,0,-1,1};
    static int[] dy= {1,-1,0,0};
    static int answer= Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        N= Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
    board= new char[N][M];
        for(int i=0;i<N;i++)
        {
            String str= bf.readLine();
            for(int j=0;j<M;j++)
            {
                board[i][j]=str.charAt(j);
            }
        }


        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(board[i][j]=='#')
                {
                    makeFirstCross(i,j);

                    returnCross(i,j,'1');


                }
            }
        }
        if(answer==Integer.MIN_VALUE)
            answer=0;
        System.out.println(answer);
    }



    private static void makeFirstCross(int x, int y) {



        for(int i=0;i<=Math.max(N,M);i++)
        {
            ArrayList<int[]> arr= new ArrayList<>();

            for(int idx=0;idx<4;idx++)
            {
                int nx = x+dx[idx]*i;
                int ny= y+dy[idx]*i;

                if(isBoundary(nx,ny) && (board[nx][ny]=='#' || board[nx][ny]=='1'))
                {
                    arr.add(new int[]{nx,ny});
                }
            }

            if(arr.size()==4) {
                for (int[] now : arr)
                {
                    board[now[0]][now[1]] = '1';

                }

                makeSecondCross();

            }
            else {
                break;
            }






        }
    }

    private static void makeSecondCross() {

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(board[i][j]=='#')
                {

                    for(int a=0;a<=Math.max(N,M);a++)

                    {

                        ArrayList<int[]> arr = new ArrayList<>();

                        for (int idx = 0; idx < 4; idx++)
                        {
                            int nx = i + dx[idx]*a;
                            int ny = j + dy[idx]*a;

                            if (isBoundary(nx, ny) && (board[nx][ny] == '#' || board[nx][ny]=='2') )
                            {
                                arr.add(new int[]{nx, ny});
                            }
                        }
                        if (arr.size() == 4)
                        {
                            for (int[] now : arr)
                            {
                                board[now[0]][now[1]] = '2';
                            }

                            check();

                        }
                        else

                        { returnCross(i,j,'2');
                            break;
                        }

                    }


                }
            }
        }
    }
    private static void returnCross(int x,int y,char num)
    {
       for(int i=0;i<N;i++)
       {
           for(int j=0;j<M;j++)
           {
               if (board[i][j]==num)
               {
                   board[i][j]='#';
               }
           }
       }

    }

    private static void check()
    {
        int firstCnt=0;
        int secondCnt=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(board[i][j]=='1')
                    firstCnt++;
                else if(board[i][j]=='2')
                    secondCnt++;
            }
        }
        answer= Math.max(answer,firstCnt*secondCnt);
    }

    private static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<M;
    }

}