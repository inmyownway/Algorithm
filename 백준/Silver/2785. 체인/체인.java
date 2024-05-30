import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] board = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            board[i] = (Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(board);

        int idx = 0;

        int cnt = 0;
        int start = 0;
        int last = board.length - 1;

        while (true) {

            if (last <= idx) {
                break;
            }
            board[idx] -= 1;
            last--;

            if (board[idx] == 0) {
                idx++;
            }

            cnt++;


        }
        System.out.println(cnt);


    }
}