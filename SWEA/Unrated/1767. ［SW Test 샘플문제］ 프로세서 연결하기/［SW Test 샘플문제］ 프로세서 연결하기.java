import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] board;
    static int lengthAnswer;
    static int coreAnswer;
    static ArrayList<Core> core;
    static int initCoreCnt;
    static int[] dx= {0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static class Core
    {
        int x;
        int y;

        public Core(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Core{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        int testCase= Integer.parseInt(st.nextToken());

        for(int test=1;test<testCase+1;test++)
        {
            st= new StringTokenizer(bf.readLine());
            N= Integer.parseInt(st.nextToken());
            board= new int[N][N];
            lengthAnswer= Integer.MAX_VALUE;
            coreAnswer= Integer.MIN_VALUE;
            core= new ArrayList<>();
            initCoreCnt =0;

            for(int i=0;i<N;i++)
            {   st= new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++) {

                    board[i][j] = Integer.parseInt(st.nextToken());
                    if(board[i][j]==1)
                    {
                        if(i>=1 && i<N-1 && j>=1 && j<N-1)
                        {
                           // System.out.println(i+" "+j);
                            core.add(new Core(i,j));
                        }
                        else
                        {
                            initCoreCnt++;
                        }
                    }
                }
            }


            dfs(0,0);
            //System.out.println(coreAnswer);
            System.out.println("#"+test+" "+ lengthAnswer);

        }

    }

    private static void dfs(int idx,int coreCnt) {

        if(idx==core.size())
        {
//            for(int[]b:board)
//            {
//                System.out.println(Arrays.toString(b));
//            }
//
//            System.out.println();
            check(coreCnt);

           // System.out.println("coreAnswer: "+coreAnswer+" lengthAnswer: "+lengthAnswer);
            return;
        }


        Core now = core.get(idx);

        for(int i=0;i<4;i++)
        {

            int tx= now.x;
            int ty= now.y;
            boolean flag= false;
            int tempIdx=0;
            while(true)
            {
                tx+=dx[i];
                ty+=dy[i];
                if(!isBoundary(tx,ty))
                {
                    flag=true;
                    break;
                }
                else if(board[tx][ty]==1 || board[tx][ty]==2)
                {
                    break;
                }
                board[tx][ty]=2;
                tempIdx++;



            }
            if(flag)
            {
                dfs(idx+1,coreCnt+1);

            }
            else
            {    returnBack(now.x,now.y,i,tempIdx);
                dfs(idx+1,coreCnt);
            }
            returnBack(now.x,now.y,i,tempIdx);


        }

    }
    private static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<N;
    }
    public static void returnBack(int x,int y,int i,int tempIdx)
    {
        int tx= x;
        int ty= y;
        // return back
        for(int idx=0;idx<tempIdx;idx++)
        {
            tx+=dx[i];
            ty+=dy[i];
            board[tx][ty]=0;
        }

    }

    public static void check(int coreCnt)
    {
        int way=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if (board[i][j]==2)
                    way++;
            }

        }

          // System.out.println(coreCnt+" way: "+way);





            if(coreCnt>coreAnswer)
            {
                coreAnswer=coreCnt;
                lengthAnswer=way;
            }
            else if(coreCnt==coreAnswer)
            {
                lengthAnswer=Math.min(way,lengthAnswer);
            }





    }

}