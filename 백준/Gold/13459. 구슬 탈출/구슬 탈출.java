import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static char[][] board;
    static int Rx,Ry,Bx,By;
    static int[] dx= {0,0,-1,1};
    static int[] dy= {-1,1,0,0};
    static boolean[][][][][] v;
    static Queue<int[]> q;
    static int answer;
    public static void main(String[] args) throws IOException {



        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        N= Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board= new char[N][M];
        v= new boolean[N][M][N][M][4];

        for(int i=0;i<N;i++)
        {
            String str= bf.readLine();
            for(int j=0;j<M;j++)
            {
                board[i][j]=str.charAt(j);
                if(board[i][j]=='B')
                {
                    Bx= i;
                    By =j;
                  //  board[i][j]='.';
                }
                else if(board[i][j]=='R')
                {
                    Rx=i;
                    Ry=j;
                  //  board[i][j]='.';
                }
            }
        }


        q = new LinkedList<>();

        q.add(new int[] {Rx,Ry,0,Bx,By,1,1});

        boolean answerFlag= bfs();

        if(answerFlag)
            System.out.println(1);
        else
            System.out.println(0);
    }

    public static boolean bfs()
    {

        while(!q.isEmpty()){

            int[] now =q.poll();

            int rx=now[0]; int ry=now[1]; int rColor=now[2]; int bx=now[3];int by=now[4];int bColor= now[5];int cnt= now[6];

            // 왼 오 밑 위
            for(int idx=0;idx<4;idx++)
            {
                int[] n= move(rx,ry,bx,by,idx);
                int fx=n[0]; int fy=n[1]; int fColor=n[2]; int sx=n[3];int sy=n[4];int sColor= n[5];
//                System.out.println();
//                System.out.println("RedBall : "+fx+" "+fy);
//                System.out.println("BlueBall: "+sx+" "+sy);
//                System.out.println("cnt : " +cnt);
//                System.out.println("방향: "+idx);
                boolean redIn = false;
                boolean blueIn= false;
                // visit 체크
                if(checkVisit(fx,fy,fColor,sx,sy,sColor,idx))
                {
                    // 방문하지 않음 (레드,블루,방향) 이게 처음임

                    // first 움직임
                    while (true)
                    {
                        fx+=dx[idx];
                        fy+=dy[idx];
                        if(board[fx][fy]=='O' && fColor==0)
                        {
                            redIn=true;
                            break;
                        }
                        else if(board[fx][fy]=='O' && fColor==1)
                        {
                         blueIn=true;
                         break;
                        }
                        if(board[fx][fy]=='#' || board[fx][fy]==sColor)
                        {
                            fx-=dx[idx];
                            fy-=dy[idx];

                            break;
                        }
                    }
                    // second 움직임
                    while (true)
                    {
                        sx+=dx[idx];
                        sy+=dy[idx];
                        if(board[sx][sy]=='O' && sColor==0)
                        {
                            redIn=true;
                            break;
                        }
                        else if(board[sx][sy]=='O' && sColor==1)
                        {
                            blueIn=true;
                            break;
                        }
                        if(board[sx][sy]=='#' || (sx==fx && sy==fy))
                        {
                            sx-=dx[idx];
                            sy-=dy[idx];

                            break;
                        }
                    }


//                    System.out.println("---AFter---");
//                    System.out.println("RedBall : "+fx+" "+fy);
//                    System.out.println("BlueBall: "+sx+" "+sy);
//                    System.out.println("red in "+ redIn +"   ||  blue in "+ blueIn);
                   // System.out.println(cnt);
                    if(redIn && blueIn)
                        continue;
                    if(redIn && !blueIn)// && cnt+1 <=10)
                    {
                  //  System.out.println("cnt "+(cnt));
                        return true;
                    }
                    if(!redIn && blueIn)
                        continue;


                    checkVisitAfter(fx,fy,fColor,sx,sy,sColor,idx);
                    if(fColor==0)
                    {
                        if(cnt+1<=10)
                            q.add(new int[]{fx,fy,fColor,sx,sy,sColor,cnt+1});
                    }
                    else
                    {
                        if(cnt+1<=10)
                            q.add(new int[]{sx,sy,sColor,fx,fy,fColor,cnt+1});

                    }

                }
            }
        }


        return  false;
    }

    private static boolean checkState(boolean redIn, boolean blueIn) {

       if(redIn && !blueIn)
           return true;

       if(redIn && blueIn)
           return false;

       return false;
    }

    private static boolean checkVisit(int fx, int fy, int fColor, int sx, int sy, int sColor,int idx) {

        if (fColor==0)
        {
            if(v[fx][fy][sx][sy][idx])
                return false;
            else
                return true;
        }
        else
        {
            if(v[sx][sy][fx][fy][idx])
                return false;
            else
                return true;
        }

    }

    private static void checkVisitAfter(int fx, int fy, int fColor, int sx, int sy, int sColor,int idx) {

        if (fColor==0)
        {
            v[fx][fy][sx][sy][idx]=true;

        }
        else
        {
            v[sx][sy][fx][fy][idx]=true;

        }

    }

    public static int[] move(int rx,int ry,int bx,int by,int d)
    {
        int firstX=0;
        int firstY=0;
        int secondX=0;
        int secondY=0;

        int fc=0;
        int sc=0;
        // 왼쪽으로 이동
        if(d==0)
        {
            if(ry < by)
            {
                firstX= rx;
                firstY= ry;
                secondX=bx;
                secondY=by;

                fc=0;
                sc=1;
            }
            else
            {

                firstX= bx;
                firstY= by;
                secondX= rx;
                secondY = ry;

                fc=1;
                sc=0;
            }
        }
        else if(d==1)
        {
            // 오른쪽
            if(ry < by)
            {
                firstX= bx;
                firstY= by;
                secondX=rx;
                secondY=ry;

                fc=1;
                sc=0;
            }
            else
            {
                firstX= rx;
                firstY= ry;
                secondX=bx;
                secondY=by;

                fc=0;
                sc=1;
            }
        }
        else if(d==2)
        {
            // 위쪽
            if(rx < bx)
            {
                firstX= rx;
                firstY= ry;
                secondX=bx;
                secondY=by;
                fc=0;
                sc=1;
            }
            else
            {
                firstX= bx;
                firstY= by;
                secondX=rx;
                secondY=ry;
                fc=1;
                sc=0;
            }
        }
        else if(d==3)
        {
            // 아래쪽
            if(rx < bx)
            {
                firstX= bx;
                firstY= by;
                secondX=rx;
                secondY=ry;

                fc=1;
                sc=0;

            }
            else
            {
                firstX= rx;
                firstY= ry;
                secondX=bx;
                secondY=by;
                fc=0;
                sc=1;
            }
        }

        return new int[] {firstX,firstY,fc,secondX,secondY,sc};
    }
    public static void print()
    {
        for(char[]b:board)
        {
            System.out.println(Arrays.toString(b));

        }
        System.out.println();
    }

}