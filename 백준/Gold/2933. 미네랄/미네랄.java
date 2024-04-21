import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R,C,N;
    static char[][] board;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int[] command;
    static int idx=1;
    static boolean[][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = bf.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        N = Integer.parseInt(bf.readLine());
        command = new int[N];

        st= new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int c = Integer.parseInt(st.nextToken());
            command[i] = R - c;
        }


        for(int i=0;i<N;i++)
         {
            // System.out.println("던지는방향 "+idx);
//             System.out.println();
//             System.out.println(i);
            remove();

//             for(char[]b:board)
//             {
//                 System.out.println(Arrays.toString(b));
//             }
            // System.out.println();
            check();

//            for(char[]b:board)
//            {
//                System.out.println(Arrays.toString(b));
//            }
//            System.out.println();
            idx++;
        }

        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static void check()
    {

        v= new boolean[R][C];

        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++) {
                if (board[i][j] == 'x' && !v[i][j]) {


                   boolean f=  bfs(i, j);

                   if(!f)
                       return;
                }
            }
        }
    }
    public static boolean bfs(int x,int y)
    {
        //System.out.println(x+" "+y);
        boolean flag= false;
        ArrayList<int[]> arr = new ArrayList<>();
        arr.add(new int[]{x,y});

        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{x,y});
        v[x][y]=true;

        while(!q.isEmpty())
        {
            int[] now = q.poll();

            int nowX = now[0];
            int nowY= now[1];

            if(nowX== R-1)
                flag=true;

            for(int id=0;id<4;id++)
            {
                int nx =nowX+dx[id];
                int ny= nowY+dy[id];

                if(isBoundary(nx,ny) && !v[nx][ny] && board[nx][ny]=='x')
                {
                    int[] temp =new int[]{nx,ny};
                    q.add(temp);
                    arr.add(temp);
                    v[nx][ny]=true;
                }
            }

        }

        if(!flag)
        {
           // System.out.println("무너짐");
            Collections.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return Integer.compare(o2[0],o1[0]);
                }
            });
            for(int[] now: arr)
            {

               board[now[0]][now[1]]='.';
            }


            boolean ff=false;

            while(true)
            {

                ArrayList<int[]> newArr = new ArrayList<>();


                // 1칸씩 내리기 원래꺼
                for(int[] now: arr)
                {

                    if(isBoundary(now[0]+1,now[1]) && board[now[0]+1][now[1]]=='.')
                    {
                        newArr.add(new int[]{now[0]+1,now[1]});
                    }
                    else
                    {
                        // 못내리니까 그냥 지금 끊고 체크 하기


                        for(int[] n: arr)
                        {
                            board[n[0]][n[1]]='x';
                        }

                        ff=true;
                        break;
                    }
                }
                if(ff)
                    break;

                //한칸씩 다 내려왔으니까 arr에 new 넣어주
                arr= new ArrayList<>();
                for(int[] now: newArr)
                {
                    arr.add(new int[]{now[0],now[1]});
                }

            }




        }
        return flag;
    }
    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<R && y>=0 && y<C;
    }

    public static void remove()
    {
        int row = command[idx-1];
       // System.out.println("던지는 row "+row);
        // 왼쪽
        if(idx%2==1)
        {
            for(int i=0;i<C;i++)
            {
            //    System.out.println(i);
                if(board[row][i]=='x')
                {
                   // System.out.println("@");
                    board[row][i]='.';
                    return;
                }
            }
        }
        else
        {
            for(int i=C-1;i>-1;i--)
            {
                if(board[row][i]=='x')
                {
                    board[row][i]='.';
                    return;
                }
            }
        }


    }

}