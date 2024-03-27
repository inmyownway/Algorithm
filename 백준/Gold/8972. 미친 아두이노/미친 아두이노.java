import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int R,C;
    static Character[][] board;
    static int ax,ay;
    static ArrayList<Mad> mad;
    public static class Mad
    {
        int x;
        int y;
        public Mad(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "Mad [x=" + x + ", y=" + y + "]";
        }

    }
    static int[] dx = {1,1,1,   0,  0, 0,    -1,  -1,-1};
    static int[] dy= {-1,0,1,   -1 ,0,1,  -1,0,1};
    static ArrayList<Integer> command;
    public static void main(String[] args) throws IOException
    {

        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());

        mad = new ArrayList<>();
        command = new ArrayList<>();

        board= new Character[R][C];


        for(int i=0;i<R;i++)
        {
            String str= bf.readLine();
            for(int j=0;j<C;j++)
            {
                char c= str.charAt(j);
board[i][j]='.';
                if(c=='I')
                {
                    ax=i;
                    ay=j;
                }
                else if(c=='R') {

                    mad.add(new Mad(i,j));
                }
            }
        }

        String str= bf.readLine();



        for(int i=0;i<str.length();i++)
        {
            command.add (str.charAt(i)-'0' );
        }

        int idx=0;
        int round=0;
        while(true)
        {


            move(command.get(idx)-1);
            idx++;
            if (!check())
            {
                System.out.println("kraj "+idx);
                break;
            }

            madMove();

            if (!check())
            {
                System.out.println("kraj "+idx);
                break;
            }
          
            dupDelete();

            if(idx==command.size())
            {

                for(int i=0;i<R;i++)
                {
                    for(int j=0;j<C;j++)
                    {
                        board[i][j]='.';
                    }
                }
                board[ax][ay]='I';
                for(Mad m : mad)
                {
                    board[m.x][m.y]='R';
                }
                for(int i=0;i<R;i++)
                {
                    for(int j=0;j<C;j++)
                    {
                        System.out.print(board[i][j]);
                    }
                    System.out.println();
                }

              break;
            }

        }



    }

    private static void dupDelete() {


        boolean[] dup = new boolean[mad.size()];
        for(int i=0;i<mad.size();i++)
        {
            for(int j=i+1;j<mad.size();j++)
            {
                if(i!=j )
                {
                    if(mad.get(i).x == mad.get(j).x && mad.get(i).y== mad.get(j).y)

                    {
                        dup[i]=true;
                        dup[j]=true;
                    }
                }
            }
        }
        ArrayList<Mad> temp= new ArrayList<>();
        for(int i=0;i<mad.size();i++)
        {
            if(dup[i]==false)
            {
                temp.add(mad.get(i));
            }
        }

        mad= new ArrayList<>();
        for(int i=0;i<temp.size();i++)
        {

            mad.add(temp.get(i));
        }
    }

    private static void madMove() {

        // 한개 한개 종수한테 가까운 방향으로 이동

        int idx=0;


        for(int i=0;i<mad.size();i++)
        {
            Mad temp = mad.get(i);
            int d=Integer.MAX_VALUE;
            for(int j=0;j<9;j++)
            {
                int tx = temp.x+dx[j];
                int ty= temp.y+dy[j];
                int dir = Math.abs(ax-tx)+Math.abs(ay-ty);

                if(d>dir)
                {
                    d=dir;
                    idx=j;
                }

            }

            int nx= temp.x+dx[idx];
            int ny= temp.y+dy[idx];

            temp.x=nx;
            temp.y=ny;


        }

    }
    private static boolean check() {

        for(int i=0;i<mad.size();i++)
        {
            if( ax==mad.get(i).x && ay==mad.get(i).y)
            {
                return false;
            }
        }
        return true;

    }
    private static void move(int idx) {

        ax+=dx[idx];
        ay+=dy[idx];


    }
}