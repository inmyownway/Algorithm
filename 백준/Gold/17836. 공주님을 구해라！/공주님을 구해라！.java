import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M,T;

    static int[][] board;


    static int[] dx = new int[]{0,0,-1,1};
    static int[] dy = new int[]{1,-1,0,0};
    static boolean[][][] visited;
    public static class Point{
        int x;
        int y;
        int time;
        boolean s;

        public Point(int x, int y,int time, boolean s) {
            this.x = x;
            this.y = y;
            this.time=time;
            this.s = s;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        T=Integer.parseInt(st.nextToken());

        board=new int[N][M];
        visited= new boolean[N][M][2];
        for(int i=0;i<N;i++)
        {
            st= new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++)
            {
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }


        int ans = bfs(0,0);
        if(ans==-1)
        {
            System.out.println("Fail");
        }
        else {
            System.out.println(ans);
        }


    }
    public static int bfs(int x, int y)
    {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x,y,0,false));
        visited[x][y][0]=true;

        while(!q.isEmpty())
        {
         Point pos = q.poll();

            //System.out.println(pos.x+" "+pos.y+" time: "+pos.time);
         if(pos.time>T)
             break;
         if(pos.x == N-1&& pos.y==M-1)
         {

             return pos.time;
         }

         for(int i=0;i<4;i++)
         {
             int nx=pos.x+dx[i];
             int ny=pos.y+dy[i];

             if(isBoundary(nx,ny))
             {
                 if(!pos.s)
                 {
                     if(!visited[nx][ny][0] && board[nx][ny]==0)
                     {
                         q.add(new Point(nx,ny,pos.time+1,pos.s));
                     }
                     else if(!visited[nx][ny][0] && board[nx][ny]==2)
                     {
                         q.add(new Point(nx,ny,pos.time+1,true));
                     }
                     visited[nx][ny][0]=true;

                 }
                 else
                 {
                     if(!visited[nx][ny][1])
                     {
                         q.add(new Point(nx,ny,pos.time+1,pos.s));
                         visited[nx][ny][1]=true;
                     }
                 }

             }
         }

        }
        return -1;
    }


    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<M;
    }


}