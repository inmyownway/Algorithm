import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int H, W;
    static char[][] board;
    static char[] command;
    static int tx, ty;
    static char currentDir;
   // static int[] dx= new int{0,}
   // static int[] dy= new int{1,}
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc < testCase + 1; tc++) {

            st = new StringTokenizer(bf.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            board = new char[H][W];

            for (int i = 0; i < H; i++) {
                String str = bf.readLine();
                for (int j = 0; j < W; j++) {
                    board[i][j] = str.charAt(j);
                    if (board[i][j] == '>' || board[i][j] == '<' || board[i][j] == '^' || board[i][j] == 'v') {
                        currentDir = board[i][j];
                        tx = i;
                        ty = j;
                    }
                }
            }
            int commnadCnt = Integer.parseInt(bf.readLine());
            command=new char[commnadCnt];
            String str = bf.readLine();
            for (int i = 0; i < commnadCnt; i++) {
                command[i] = str.charAt(i);
            }

            game();

            System.out.print("#"+tc+" ");
            for(int i=0;i<H;i++)
            {
                for(int j=0;j<W;j++)
                {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }


        }


    }

    public static void game() {


        for(char com : command)
        {

            if(com == 'U') {
               // System.out.println(1);
                currentDir = '^';
                if (isBoundary(tx - 1, ty) && board[tx - 1][ty] == '.')
                {
                    board[tx][ty]='.';
                    tx=tx-1;


                }
                board[tx][ty]=currentDir;
            }
            else if(com=='D')
            {
                currentDir = 'v';
                if (isBoundary(tx +1, ty) && board[tx + 1][ty] == '.')
                {  board[tx][ty]='.';
                    tx=tx+1;

                }
                board[tx][ty]=currentDir;
            }
            else if(com=='L')
            {
                currentDir = '<';
                if (isBoundary(tx , ty-1) && board[tx ][ty-1] == '.')
                {board[tx][ty]='.';
                    ty=ty-1;

                }
                board[tx][ty]=currentDir;
            }
            else if(com=='R')
            {
                currentDir = '>';
                if (isBoundary(tx , ty+1) && board[tx ][ty+1] == '.')
                {board[tx][ty]='.';
                    ty=ty+1;
                }
                board[tx][ty]=currentDir;

            }
            else if(com=='S')
            {
                //System.out.println(currentDir);
                if(currentDir=='^')
                {
                    for(int i=tx-1;tx>-1;i--)
                    {
                        if(!isBoundary(i,ty))
                        {
                            break;
                        }
                        if(board[i][ty]=='*')
                        {
                            board[i][ty]='.';
                            break;
                        }
                        else if(board[i][ty]=='#')
                        {
                            break;
                        }

                    }
                }

                else if(currentDir=='v')
                {
                    for(int i=tx+1;tx<H;i++)
                    {
                        if(!isBoundary(i,ty))
                        {
                            break;
                        }
                        if(board[i][ty]=='*')
                        {
                            board[i][ty]='.';
                            break;
                        }
                        else if(board[i][ty]=='#')
                        {
                            break;
                        }

                    }
                }
                else if(currentDir=='>')
                {
                    for(int i=ty+1;ty<W;i++)
                    {
                      //  System.out.println(i);
                        if(!isBoundary(tx,i))
                        {
                            break;
                        }
                        if(board[tx][i]=='*')
                        {
                            board[tx][i]='.';
                            break;
                        }
                        else if(board[tx][i]=='#')
                        {
                            break;
                        }

                    }
                }
                else if(currentDir=='<')
                {
                    for(int i=ty-1;ty>-1;i--)
                    {
                        if(!isBoundary(tx,i))
                        {
                            break;
                        }
                        if(board[tx][i]=='*')
                        {
                            board[tx][i]='.';
                            break;
                        }
                        else if(board[tx][i]=='#')
                        {
                            break;
                        }

                    }
                }
            }
//            System.out.println("c: "+com);
//            for(int i=0;i<H;i++)
//            {
//                for(int j=0;j<W;j++)
//                {
//                    System.out.print(board[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println();
        }

    }
    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<H && y>=0 && y<W;
    }

}