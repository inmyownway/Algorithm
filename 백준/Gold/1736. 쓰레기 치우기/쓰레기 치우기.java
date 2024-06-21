import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] card, result;

    static int N, M;
    static int[][] board;
    static int trashCnt;
    static int robotCnt;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 1) {
                    trashCnt++;
                }

            }

        }
        while (trashCnt > 0) {

            // 반복문 돌때마다 청소기 추가
            robotCnt++;

            if (board[0][0] == 1) {
                board[0][0] = 0;
                trashCnt--;
            }
            clean(0, 0);
        }
        System.out.println(robotCnt);
    }

    public static void clean(int x, int y) {
        if (x == N - 1 && y == M - 1) {
            if (board[x][y] == 1) {
                board[0][0] = 0;
                trashCnt--;
            }
            return;
        }

        for (int i = x; i < N; i++) {
            for (int j = y; j < M; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                    trashCnt--;
                    clean(i,j );
                    return;

                }
            }
        }
        return;
    }
}