import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M,P;
    static int[][] board;
    static int[] distance;
    static Queue<Node>[] q;
    static int[] dx= {0,0,-1,1};
    static int[] dy= {1,-1,0,0};
    static int[] answer;
    static boolean flag;
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        P=Integer.parseInt(st.nextToken());

        q =new LinkedList[P+1];
        distance= new int[P+1];
        board= new int[N][M];

        for(int i=0;i<P+1;i++)
        {
            q[i]= new LinkedList<>();
        }

        st= new StringTokenizer(bf.readLine());
        for(int i=1;i<P+1;i++)
        {
            distance[i]=Integer.parseInt(st.nextToken());
        }
        //System.out.println(Arrays.toString(distance));
        int firstState=0;

        for(int i=0;i<N;i++)
        {
           String str= bf.readLine();
            for(int j=0;j<M;j++)
            {
                char n= str.charAt(j);
                if(n=='#')
                    board[i][j]=-1;
                else if(n!='.' && n!='#')
                {
                    int num= n-'0';
                    board[i][j]=num;
                    q[num].add(new Node(i,j));
                }
                else if(n=='.')
                {
                    firstState++;
                    board[i][j]=0;
                }
            }
        }


        int t=0;

        while (true)
        {
            //System.out.println(t++);
             flag=true;
            game();



            if(flag==false)
            {

                check();
                break;

            }


        }


        for(int i=1;i<=P;i++)
        {
            System.out.print(answer[i]+" ");
        }

    }

    private static void game() {

        int empty=0;

        for(int i=1;i<P+1;i++)
        {

            int d= distance[i];
            if(q[i].size()==0)
            {
                empty++;       continue;
            }

            for(int j=0;j<d;j++)
            {
                int size=q[i].size();
//                System.out.println(size);
                if(size==0)
                    break;
                for(int s=0;s<size;s++)
                {
                    Node now = q[i].poll();

                    int x= now.x;
                    int y= now.y;

                    for(int idx=0;idx<4;idx++)
                    {
                        int nx= x+dx[idx];
                        int ny= y+dy[idx];

                        if(isBoundary(nx,ny) && board[nx][ny]==0 )
                        {
                            board[nx][ny]=i;
                            //flag=true;
                            q[i].add(new Node(nx,ny));

                        }
                    }
                }


            }
        }
        if(empty==P)
        {
            flag=false;
        }
    }

    public static int check()
    {
        int c=0;
         answer= new int[P+1];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if (board[i][j]==0)
                    c++;
                if (board[i][j]>=1 && board[i][j]<=P)
                {
                    answer[board[i][j]]++;

                }
            }
        }
        return c;
    }
    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<M;
    }

}