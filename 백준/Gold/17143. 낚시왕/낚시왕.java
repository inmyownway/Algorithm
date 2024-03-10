import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Shark{
        int x;
        int y;
        int s;
        int d;
        int z;



        public Shark(int x,int y,int s,int d,int z)
        {
            this.x=x;
            this.y=y;
            this.s=s;
            this.d=d;
            this.z=z;

        }

        @Override
        public String toString() {
            return "Shark{" +
                    "x=" + x +
                    ", y=" + y +
                    ", s=" + s +
                    ", d=" + d +
                    ", z=" + z +
                    '}';
        }
    }
    //d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미한다.
    static int R,C,M;
    static int rx,ry;
    static int[][][] board;
    static int speed,dir,power,nx,ny;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,1,-1};
    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R= Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        board= new int[R][C][3];
        for(int i=0;i<M;i++)

        {
         //   System.out.println(i);
            st= new StringTokenizer(bf.readLine());

            int tx= Integer.parseInt(st.nextToken());
            int ty= Integer.parseInt(st.nextToken());
            int ts = Integer.parseInt(st.nextToken());
            int td = Integer.parseInt(st.nextToken());
            int tz = Integer.parseInt(st.nextToken());
            board[tx-1][ty-1][0]=ts;
            board[tx-1][ty-1][1]=td-1;
            board[tx-1][ty-1][2]=tz;

        //    System.out.println(tx+" "+ty+" "+ts+" "+td+" "+tz);

        }
        rx=0;
        ry=-1;
       // System.out.println("@@");
   //print();
        for(int time=0;time<C;time++)
        {
            // 사람 이동
           // System.out.println("time "+time);

            ry++;

            // 열에 가까운 상어 제거
            for(int i=0;i<R;i++)
            {
                if (board[i][ry][2] >= 1) {

                    answer+=board[i][ry][2];
                    board[i][ry][0] = 0;
                    board[i][ry][1] = 0;
                    board[i][ry][2] = 0;

                    break;
                }
            }


            // 상어이동
            moveShark();
         //   print();


        }
        System.out.println(answer);
    }
    public static void moveShark()
    {
        int[][][] tempBoard = new int[R][C][3];

        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                if(board[i][j][2]>=1)
                {

                    speed=board[i][j][0];
                    dir= board[i][j][1];
                    power = board[i][j][2];
                    // init(i,j);
                    nx= i;
                    ny= j;

                    for(int m=0;m<speed;m++)
                    {
                        nx+=dx[dir];
                        ny+=dy[dir];
                        if(!isBoundary(nx,ny))
                        {

                            changeDir(dir);
                            nx+=dx[dir]*2;
                            ny+=dy[dir]*2;
                        }
                    }

                    // 만약 상어가 있는경우
                    if(tempBoard[nx][ny][2]!=0)
                    {
                        if(tempBoard[nx][ny][2]<power)
                        {
                            tempBoard[nx][ny][0]=speed;
                            tempBoard[nx][ny][1]=dir;
                            tempBoard[nx][ny][2]=power;
                        }
                    }
                    else if(tempBoard[nx][ny][2]==0)
                    {
                        tempBoard[nx][ny][0]=speed;
                        tempBoard[nx][ny][1]=dir;
                        tempBoard[nx][ny][2]=power;
                    }
                }
            }
        }
        copyBoard(tempBoard);

    }
    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<R && y>=0 && y<C;
    }
    public static void changeDir(int x)
    {
        if(x==0)
            dir=1;
        else if(x==1)
            dir=0;
        else if(x==2)
            dir=3;
        else
            dir=2;
    }
    public static void init(int x,int y)
    {
        board[x][y][0]=0;
        board[x][y][1]=0;
        board[x][y][2]=0;
    }
    public static void print()
    {
        for(int i=0;i<R;i++)
        {
          for(int j=0;j<C;j++)
          {
              System.out.print(board[i][j][0]+" ");
          }
            System.out.println();
        }

        System.out.println();
    }

    public static void copyBoard(int[][][] temp)
    {
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                for(int idx=0;idx<3;idx++)
                {
                    board[i][j][idx]=temp[i][j][idx];
                }
            }
        }

    }


}