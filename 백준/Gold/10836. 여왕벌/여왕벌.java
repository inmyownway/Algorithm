import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] board;
    static int[][] add;
    static ArrayList<int[]> arr;
    static int[] dx={-1,-1,0};
    static int[] dy={0,-1,-1};
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        M= Integer.parseInt(st.nextToken());
        N= Integer.parseInt(st.nextToken());

        board= new int[M][M];
        add =new int[M][M];
        arr = new ArrayList<>();


        for(int i=0;i<M;i++)
        {
        Arrays.fill(board[i],1);
        }
        for(int i=0;i<N;i++)
        {
            int[] temp= new int[M+M-1];
            st= new StringTokenizer(bf.readLine());
            int cc=0;
            for(int j=0;j<3;j++)
            {
                int num =Integer.parseInt(st.nextToken());
                if(j==0)
                {
                    for(int idx=0;idx<num;idx++)
                    {
                        temp[cc++]=0;
                    }
                }
                if(j==1)
                {
                    for(int idx=0;idx<num;idx++)
                    {
                        temp[cc++]=1;
                    }
                }
                if(j==2)
                {
                    for(int idx=0;idx<num;idx++)
                    {
                        temp[cc++]=2;
                    }
                }
            }
            arr.add(temp);
        }

        for(int[] command : arr)
        {
            increase(command);
        }

        for(int i=1;i<M;i++)
        {
            for(int j=1;j<M;j++)
            {
                int max=0;
                for(int idx=0;idx<3;idx++)
                {
                    max=Math.max(max,board[i+dx[idx]][j+dy[idx]]);
                }
                board[i][j]=max;
            }
        }

        for(int i=0;i<M;i++) {
            for (int j = 0; j < M; j++) {

                System.out.print(board[i][j]+" ");
               }
            System.out.println();
        }

    }

    private static void increase(int[] c) {

        int idx=0;
       // System.out.println(Arrays.toString(c));
        for(int j=0;j<M;j++)
        {
            //System.out.println(j);

            board[M-1-j][0]+=c[idx++];
         //   System.out.println(M-1-j);


        }
        for(int j=1;j<M;j++)
        {
            board[0][j]+=c[idx++];
        }
//        for(int[]b :board)
//        {
//            System.out.println(Arrays.toString(b));
//        }
//        System.out.println();
    }
}