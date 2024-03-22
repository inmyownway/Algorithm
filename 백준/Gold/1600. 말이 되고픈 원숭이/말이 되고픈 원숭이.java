import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K;
    static int W,H;
    static int[][] board;
    static boolean[][][] v;

    static int[] dx={1,0,0,-1};
    static int[] dy={0,1,-1,0};

    static int[] hx={2,1,-1,-2,-2,-1,1,2};
    static int[] hy={1,2,2,1,-1,-2,-2,-1};
    public static class Point{
        int x;
        int y;
        int k;
        int d;

        public Point(int x, int y, int k, int d) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        K=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(bf.readLine());


        int w= Integer.parseInt(st.nextToken());
        int h= Integer.parseInt(st.nextToken());
        W=h;
        H=w;


    board = new int[W][H];
        for(int i=0;i<W;i++)
        {
            st= new StringTokenizer(bf.readLine());
            for(int j=0;j<H;j++)
            {
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        v= new boolean[W][H][K+1];
       int answer= bfs(0,0);
        System.out.println(answer);
    }
    public static int bfs(int x,int y)
    {
        Queue<Point> q = new LinkedList<>();

        v[x][y][0]=true;


        q.add(new Point(x,y,0,0));

        int a=0;
        while(!q.isEmpty())
        {
            Point current = q.poll();


            int vx=current.x;
            int vy=current.y;

            if(vx==W-1 && vy== H-1)
            {
                return current.d;
            }

            for(int i=0;i<4;i++)
            {
                int nx= vx+dx[i];
                int ny = vy+dy[i];

                if(isBoundary(nx,ny) && board[nx][ny]==0 && v[nx][ny][current.k]==false)
                {
                    v[nx][ny][current.k]=true;
                    q.add(new Point(nx,ny,current.k,current.d+1));
                }
            }

            if(current.k<K)
            {

                for(int i=0;i<8;i++)
                {
                    int nx= vx+hx[i];
                    int ny = vy+hy[i];

                    if(isBoundary(nx,ny) && board[nx][ny]==0 && v[nx][ny][current.k+1]==false)
                    {
                        v[nx][ny][current.k+1]=true;
                        q.add(new Point(nx,ny,current.k+1,current.d+1));
                    }
                }
            }


        }

        return -1;
    }
    public static boolean isBoundary(int x,int y)
    {

        return x>=0 && x<W && y>=0 && y<H;
    }


}