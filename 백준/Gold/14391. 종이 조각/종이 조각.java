import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] board;
    static boolean[][] slice;
    static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = bf.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        slice = new boolean[N][M];

        dfs1(0, 0);

        System.out.println(ans);
    }

    public static void dfs1(int x, int y) {

        if (x == N) {
            count();
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(slice[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            return;//
        }

        if (y == M) {
            dfs1(x + 1, 0);
            return;
        }

        // 가로
        slice[x][y] = true;
        dfs1(x, y + 1);

        //세로
        slice[x][y] = false;
        dfs1(x, y + 1);
    }


    public static void count() {
        int result = 0;

        int temp;

        for (int i = 0; i < N; i++) {
            temp = 0;
            for (int j = 0; j < M; j++) {
                if (slice[i][j]) {
                    temp *= 10;
                    temp += board[i][j];

                } else {
                    result += temp;
                    temp = 0;
                }
            }
            result += temp;

        }

        for (int i = 0; i < M; i++) {
            temp = 0;
            for (int j = 0; j < N; j++) {
                if (!slice[j][i]) {
                    temp *= 10;
                    temp += board[j][i];

                } else {
                    result += temp;
                    temp = 0;
                }
            }
            result += temp;

        }
        ans = Math.max(result, ans);
    }

}