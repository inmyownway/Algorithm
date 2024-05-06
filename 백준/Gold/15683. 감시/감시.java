import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] board;
    static int[] dx= {0,0,-1,1};
    static int[] dy= {1,-1,0,0};
    static class CCTV{
        int x;
        int y;
        int num;

        @Override
        public String toString() {
            return "CCTV{" +
                    "x=" + x +
                    ", y=" + y +
                    ", num=" + num +
                    '}';
        }

        public CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
    static int answer= Integer.MAX_VALUE;
    static ArrayList<CCTV> cctv;
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        board= new int[N][M];
        cctv= new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            st= new StringTokenizer(bf.readLine());
            for(int j=0;j<M;j++)
            {
                board[i][j]=Integer.parseInt(st.nextToken());
                if(board[i][j]>=1 && board[i][j]< 6)
                {
                    cctv.add(new CCTV(i,j,board[i][j]));
                }
            }
        }

        dfs(0,board,cctv);

        System.out.println(answer);

    }

    public static void dfs(int cnt,int[][] board,ArrayList<CCTV> cctv)
    {

        if(cnt== cctv.size()){
            //
            int sum=0;
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<M;j++)
                {
                    if(board[i][j]==0)
                        sum++;
                }

            }
           // print();
            answer= Math.min(answer,sum);
            return;
        }
        //System.out.println(cnt);
        CCTV now = cctv.get(cnt);
       // System.out.println(now);
        int num= now.num;
        int x= now.x;
        int y= now.y;
        int[][] temp;
        if(num==1)
        {
            temp= copyMap(board);
            checkLeft(temp,x,y);
            dfs(cnt+1,temp,cctv);

            temp= copyMap(board);
            checkRight(temp,x,y);
            dfs(cnt+1,temp,cctv);

            temp= copyMap(board);
            checkDown(temp,x,y);
            dfs(cnt+1,temp,cctv);

            temp= copyMap(board);
            checkUp(temp,x,y);
            dfs(cnt+1,temp,cctv);

        }
        else if(num==2)
        {
            temp= copyMap(board);
            checkRight(temp,x,y);
            checkLeft(temp,x,y);
            dfs(cnt+1,temp,cctv);

            temp= copyMap(board);
            checkUp(temp,x,y);
            checkDown(temp,x,y);
            dfs(cnt+1,temp,cctv);

        }
        else if(num==3)
        {
            temp = copyMap(board);
            checkLeft(temp, x, y);
            checkUp(temp, x, y);
            dfs(cnt+1, temp, cctv);

            temp = copyMap(board);
            checkUp(temp, x, y);
            checkRight(temp, x, y);
            dfs(cnt+1, temp, cctv);

            temp = copyMap(board);
            checkRight(temp, x, y);
            checkDown(temp, x, y);
            dfs(cnt+1, temp, cctv);

            temp = copyMap(board);
            checkDown(temp, x, y);
            checkLeft(temp, x, y);
            dfs(cnt+1, temp, cctv);
        }
        else if(num==4)
        {
            temp = copyMap(board);
            checkLeft(temp, x, y);
            checkUp(temp, x, y);
            checkRight(temp, x, y);
            dfs(cnt+1, temp, cctv);

            temp = copyMap(board);
            checkUp(temp, x, y);
            checkRight(temp, x, y);
            checkDown(temp, x, y);
            dfs(cnt+1, temp, cctv);

            temp = copyMap(board);
            checkRight(temp, x, y);
            checkDown(temp, x, y);
            checkLeft(temp ,x , y);
            dfs(cnt+1, temp, cctv);

            temp = copyMap(board);
            checkDown(temp, x, y);
            checkLeft(temp ,x , y);
            checkUp(temp, x, y);
            dfs(cnt+1, temp, cctv);
        }
        else if(num==5)
        {
            temp = copyMap(board);
            checkRight(temp, x, y);
            checkDown(temp, x, y);
            checkLeft(temp ,x , y);
            checkUp(temp, x, y);
            dfs(cnt+1, temp, cctv);
        }

    }
    public static void checkLeft(int[][] map, int x, int y) {
        for(int i=y-1; i>=0; i--) {
            if(map[x][i] == 6) return;
            if(map[x][i] != 0) continue;
            map[x][i] = -1;
        }
    }

    public static void checkRight(int[][] map, int x, int y) {
        for(int i=y+1; i<M; i++) {
            if(map[x][i] == 6) return;
            if(map[x][i] != 0) continue;
            map[x][i] = -1;
        }
    }

    public static void checkUp(int[][] map, int x, int y) {
        for(int i=x-1; i>=0; i--) {
            if(map[i][y] == 6) return;
            if(map[i][y] != 0) continue;
            map[i][y] = -1;
        }
    }

    public static void checkDown(int[][] map, int x, int y) {
        for(int i=x+1; i<N; i++) {
            if(map[i][y] == 6) return;
            if(map[i][y] != 0) continue;
            map[i][y] = -1;
        }
    }
//    private static void checkLeft(int[][] temp, int x, int y) {
//
//        int nx =x;
//        int ny= y;
//        for(int idx=0;idx<M;idx++)
//        {
//            ny-=1;
//            if(!isBoundary(nx,ny) || temp[nx][ny]==6)
//                break;
//            temp[nx][ny]=-1;
//        }
//    }
//    private static void checkRight(int[][] temp, int x, int y) {
//
//        int nx =x;
//        int ny= y;
//        for(int idx=0;idx<M;idx++)
//        {
//            ny+=1;
//            if(!isBoundary(nx,ny) || temp[nx][ny]==6)
//                break;
//            temp[nx][ny]=-1;
//        }
//    }
//    private static void checkUp(int[][] temp, int x, int y) {
//
//        int nx =x;
//        int ny= y;
//        for(int idx=0;idx<N;idx++)
//        {
//            nx-=1;
//            if(!isBoundary(nx,ny) || temp[nx][ny]==6)
//                break;
//            temp[nx][ny]=-1;
//        }
//    }
//    private static void checkDown(int[][] temp, int x, int y) {
//
//        int nx =x;
//        int ny= y;
//        for(int idx=0;idx<M;idx++)
//        {
//            nx+=1;
//            if(!isBoundary(nx,ny) || temp[nx][ny]==6)
//                break;
//            temp[nx][ny]=-1;
//        }
//    }
    public static void print()
    {
        for(int[]b:board)
        {
            System.out.println(Arrays.toString(b));
        }
        System.out.println();
    }

    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<M;
    }

    public static int[][] copyMap(int[][] board)
    {
        int[][] t= new int[N][M];

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                t[i][j]=board[i][j];
            }
        }
        return t;
    }

}