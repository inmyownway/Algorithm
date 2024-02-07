import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[][] board;
    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        N=Integer.parseInt(bf.readLine());

        board =new boolean[101][101];

        for(int i=0;i<N;i++)
        {
            st=new StringTokenizer(bf.readLine());

            int x=Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());

            // 색칠

            for(int a=x;a<x+10;a++) {

                for (int b = y; b < y + 10; b++) {
                    board[a][b] = true;

                }
            }
            
        }

        for(int i=0;i<101;i++)
        {
            for(int j=0;j<101;j++)
            {
                if(board[i][j])
                {
                    answer++;
                }
            }
        }
        System.out.println(answer);




    }



}