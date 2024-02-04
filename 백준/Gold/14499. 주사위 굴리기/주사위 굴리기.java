import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M,x,y,K;
    static int[][] board;
    static int[] command;

    static int[] dx ={0,0,-1,1};
    static int[] dy= {1,-1,0,0};
    static int nx,ny;
    static int[] dice;

    public static int[] turn(int d)
    {

        int[] newDice=new int[6];
      // System.out.println("turn "+d);
        // 동쪽
        //   위 아래 북 남 동 서
        if(d==1)
        {        newDice[0]=dice[5];
            newDice[1]=dice[4];


            newDice[2]=dice[2];
            newDice[3]=dice[3];

            newDice[4]=dice[0];
            newDice[5]=dice[1];

        }
        if(d==2) // 서쪽
        {//   위 아래 북 남 동 서
            newDice[0]=dice[4];
            newDice[1]=dice[5];

            newDice[2]=dice[2];
            newDice[3]=dice[3];

            newDice[4]=dice[1];
            newDice[5]=dice[0];
        }
           /*
                dice = new int[]{0,0,0,0,0,0};
        //                  (북)
                           //   위 아래 북 남 동 서
         */
        if(d==3)
        {
            newDice[0]=dice[3];
            newDice[1]=dice[2];

            newDice[2]=dice[0];
            newDice[3]=dice[1];

            newDice[4]=dice[4];
            newDice[5]=dice[5];
        }
        /*
                dice = new int[]{0,0,0,0,0,0};
        //                  (남)
                           //   위 아래 북 남 동 서
         */
        if(d==4)
        {
            newDice[0]=dice[2];
            newDice[1]=dice[3];

            newDice[2]=dice[1];
            newDice[3]=dice[0];

            newDice[4]=dice[4];
            newDice[5]=dice[5];
        }
    return newDice;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());


        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        board= new int[N][M];

        for(int i=0;i<N;i++)
        {
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++)
            {
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        command=new int[K];
        st=new StringTokenizer(bf.readLine());

        for(int i=0;i<K;i++)
        {
            command[i]=Integer.parseInt(st.nextToken());
        }

        dice = new int[]{0,0,0,0,0,0};
        //             하늘 바닥, 위 아래 오 왼
        nx=x;
        ny=y;
        for(int i=0;i<K;i++)
        {
            int curretCommand = command[i]-1;
           // System.out.println("nx ny "+nx+" "+ny);
            int tx=nx+dx[curretCommand];
            int ty=ny+dy[curretCommand];

            //System.out.println("command: "+curretCommand);
           // System.out.println("current: "+tx+" "+ty);

            if(isBoundary(tx,ty))
            {

               dice= turn(curretCommand+1);

                // 옮긴 칸이 0 인 경우
                if(board[tx][ty]==0)
                {
                    board[tx][ty]=dice[1];
                }
                else
                {
                    dice[1]=board[tx][ty];
                    board[tx][ty]=0;
                }
              //  System.out.println(Arrays.toString(dice));
               System.out.println(dice[0]);
                nx=tx;//[curretCommand];
                ny=ty;//[curretCommand];
             //   System.out.println("현위치:"+nx+" "+ny);
            }
            //System.out.println();
// 동 서 북 남
        }
    }
    public static void turnUp()
    {
        dice[0]=dice[3];
        dice[1]=dice[2];
        dice[2]=dice[0];
        dice[3]=dice[1];
        dice[4]=dice[4];
        dice[5]=dice[5];
    }
    /*        dice = new int[]{0, 0,    0, 0, 0, 0};
        //                     하늘 바닥, 위 아래 오 왼
    * */
    public static void turnDown()
    {
        dice[0]=dice[2];
        dice[1]=dice[3];

        dice[2]=dice[1];
        dice[3]=dice[0];

        dice[4]=dice[4];
        dice[5]=dice[5];
    }
    /*        dice = new int[]{0, 0,    0, 0, 0, 0};
        //                     하늘 바닥, 위 아래 오 왼
    * */
    public static void turnLeft()
    {
        dice[0]=dice[0];
        dice[1]=dice[1];

        dice[2]=dice[4];
        dice[3]=dice[5];

        dice[4]=dice[3];
        dice[5]=dice[2];
    }


    /*        dice = new int[]{0, 0,    0, 0, 0, 0};
        //                     하늘 바닥, 위 아래 오 왼
    * */
    public static void turnRight()
    {
        dice[0]=dice[0];
        dice[1]=dice[1];


        dice[2]=dice[5];
        dice[3]=dice[4];

        dice[4]=dice[2];
        dice[5]=dice[3];

    }

    public static boolean isBoundary(int x,int y){
        return x>=0 && x<N && y>=0 && y<M;
    }
}