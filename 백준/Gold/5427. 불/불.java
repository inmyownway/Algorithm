import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static boolean[][] v;
    static char[][] board;
    static int fx,fy,sx,sy;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int answer;
    static   Queue<int[]> fire;
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase= Integer.parseInt(bf.readLine());

        for(int t=0;t<testCase;t++)
        {
            st= new StringTokenizer(bf.readLine());
            M=Integer.parseInt(st.nextToken());
            N=Integer.parseInt(st.nextToken());
            board = new char[N][M];
            v= new boolean[N][M];
            answer=0;
            fire= new LinkedList<>();
            for(int i=0;i<N;i++)

            {
                String str = bf.readLine();
                for(int j=0;j<M;j++)
                {
                    board[i][j]=str.charAt(j);
                    if(board[i][j]=='*')
                    {
                        fire.add(new int[]{i,j});
                    }
                    if(board[i][j]=='@')
                    {
                        sx=i;
                        sy=j;
                    }
                }
            }

            bfs();

            if (answer == 0) {
                System.out.println("IMPOSSIBLE");
            }
            else
            {
                System.out.println(answer);
            }
        }

    }

    private static void bfs() {

        //Queue<int[]> fire= new LinkedList<>();
        Queue<int[]> person = new LinkedList<>();
        //v= new boolean[][]
        //fire.add(new int[]{fx,fy});
        person.add(new int[]{sx,sy,0});


        while(!person.isEmpty())
        {


          //  System.out.println(Arrays.toString(nowPerson));
            // fire move



            int fsize= fire.size();;
            for(int i=0;i<fsize;i++)
            {

                int[] nowFire = fire.poll();

                for(int idx=0;idx<4;idx++)
                {
                    int nx= nowFire[0]+dx[idx];
                    int ny= nowFire[1]+dy[idx];

                    if(isBoundary(nx,ny) && board[nx][ny]!='#' && board[nx][ny]!='*')
                    {
                        board[nx][ny]='*';
                        fire.add(new int[]{nx,ny});
                    }

                }
            }


            int psize= person.size();
         //   System.out.println(psize);
            for(int i=0;i<psize;i++) {

                int[] nowPerson= person.poll();
                //System.out.println(Arrays.toString(nowPerson));
                for (int idx = 0; idx < 4; idx++) {
                    int nx = nowPerson[0] + dx[idx];
                    int ny = nowPerson[1] + dy[idx];


                    if (!isBoundary(nx, ny)) {
                        answer = nowPerson[2] + 1;
                        return;
                    }
                    //System.out.println(nx+" "+ny);
                    //System.out.println(board[nx][ny]);
                    if (isBoundary(nx, ny) && board[nx][ny] == '.') {
                        person.add(new int[]{nx, ny, nowPerson[2] + 1});
                        board[nx][ny]='@';

                    }

                }
            }
//
//            for(char[]b:board)
//            {
//                System.out.println(Arrays.toString(b));
//            }
//            System.out.println();
        }



    }
    private static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<M;
    }

}