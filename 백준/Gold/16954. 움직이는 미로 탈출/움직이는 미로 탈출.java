import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N=8;
    static char[][] board;
    static int[] dx={0,0,-1,1, 1,1,-1,-1,0 };
    static int[] dy={1,-1,0,0, -1,1,-1,1,0};
    static int answer;
    public static class Person{
        int x;
        int y;

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        board= new char[N][N];
        for(int i=0;i<N;i++)
        {
            String str = bf.readLine();
            for(int j=0;j<N;j++)
            {
                board[i][j]= str.charAt(j);



            }
        }


        bfs();

        if(answer==1)
        {
            System.out.println(answer);
        }
        else
        {
            System.out.println(0);
        }



    }
    public static void bfs()
    {
        Queue<Person> q = new LinkedList<>();
        q.add(new Person(7,0));

        while(!q.isEmpty())
        {
            int s= q.size();

            for(int i=0;i<s;i++)
            {

                Person cur = q.poll();

                //System.out.println(cur);
                if(board[cur.x][cur.y]=='#')
                    continue;
                if(cur.x==0 && cur.y==7)
                {
                    answer=1;
                    return;
                }

                for(int idx=0;idx<9;idx++)
                {
                    int nx= cur.x+dx[idx];
                    int ny= cur.y+dy[idx];

                    if(isBoundary(nx,ny) && board[nx][ny]=='.')
                    {
                        q.add(new Person(nx,ny));
                    }

                }



            }


            moveWall();



        }

    }


    private static void moveWall() {

        for(int i=7;i>-1;i--)
        {
            for(int j=0;j<8;j++)
            {
                if (board[i][j]=='#'){
                if(i==7)
                {
                    board[i][j]='.';
                }
                else
                {
                    board[i][j]='.';
                    board[i+1][j]='#';
                }
            }}
        }
    }

    public static boolean isBoundary(int x,int y)

    {
        return x>=0 && x<8 && y>=0 && y<8;
    }
    }