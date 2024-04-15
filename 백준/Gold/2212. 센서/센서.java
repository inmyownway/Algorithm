import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static int[] board;
    static int[] diff;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        N= Integer.parseInt(bf.readLine());
        K=Integer.parseInt(bf.readLine());
        board = new int[N];
        diff = new int[N-1];
        st= new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++)
        {
            board[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(board);
        //aSystem.out.println(Arrays.toString(board));
        for(int i=0;i<N-1;i++)
        {
            diff[i]=board[i+1]-board[i];
          //  System.out.println(diff[i]);
        }

        Arrays.sort(diff);

      //  System.out.println(Arrays.toString(diff));

        int answer=0;
       // System.out.println(Arrays.toString(diff));
        for(int i=0;i<N-1-(K-1);i++)
            answer+=diff[i];
        System.out.println(answer);


    }

}