import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static ArrayList<Node>[][] board;
    static boolean[][] v;
    static boolean[][] lightOn;

    static int[] dx={0,0 ,-1,1};
    static int[] dy={1,-1,0,0};
    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        board= new ArrayList[N][N];

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++) {

                board[i][j]= new ArrayList<Node>();
                }

        }

        for(int i=0;i<M;i++)
        {
            st= new StringTokenizer(bf.readLine());
            int sx= Integer.parseInt(st.nextToken());
            int sy= Integer.parseInt(st.nextToken());
            int ex= Integer.parseInt(st.nextToken());
            int ey= Integer.parseInt(st.nextToken());
           // System.out.println(sx+" "+sy+" "+ ex+" "+ey);
            board[sx-1][sy-1].add(new Node(ex-1,ey-1));

        }


        lightOn=new boolean[N][N];
        lightOn[0][0]=true;

       answer= bfs(0,0);
        System.out.println(answer+1);

    }

    public static int bfs(int sx,int sy)
    {

        Queue<Node> q= new ArrayDeque<>();
        q.add(new Node(sx,sy));
        v= new boolean[N][N];
        int cnt=0;
        v[sx][sy]=true;
        boolean flag= false;

        while(!q.isEmpty())
        {
            Node currnet = q.poll();

            for(Node node: board[currnet.x][currnet.y])
            {
                if(lightOn[node.x][node.y]==false)
                {
                    cnt++;
                    lightOn[node.x][node.y]=true;
                    flag=true;            // 새로 켜진게 있는거임


                }

            }


            for(int idx=0;idx<4;idx++)
            {
                int nx= currnet.x+dx[idx];
                int ny= currnet.y+dy[idx];

                // 범위 안이고 , 갈수있는곳인니까 , 거기가 켜져잇으면 갈수있
                if(isBoundary(nx,ny) && lightOn[nx][ny] && v[nx][ny]==false)
                {
                    q.add(new Node(nx,ny));
                    v[nx][ny]=true;
                }
            }

       


        }     if(flag)
    {
        cnt+=    bfs(0,0);
    }

        return cnt;







    }
    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<N;
    }


}