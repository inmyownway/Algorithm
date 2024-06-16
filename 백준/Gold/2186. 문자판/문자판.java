import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import javax.swing.Popup;

public class Main {
    static int N, M, K;
    static char[][] arr;
    static String answer;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int cnt;
    static int[][][] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = bf.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        answer = bf.readLine();
        memo = new int[N][M][answer.length()];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int z = 0; z < answer.length(); z++) {
                    memo[i][j][z] = -1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // System.out.print(arr[i][j] + " ");
                if (arr[i][j] == answer.charAt(0)) {

                    dfs(i, j, 0);
                    cnt += memo[i][j][0];

                }
            }
        }
        System.out.println(cnt);
    }

    public static void dfs(int x, int y, int idx) {

        if (idx == answer.length() - 1) {

            memo[x][y][idx] = 1;
            return;
        }

        if (memo[x][y][idx] != -1) {
            return;
        }
        // 방문처리
        memo[x][y][idx] = 0;

        char findWord = answer.charAt(idx + 1);

        ArrayList<int[]> pos = new ArrayList<>();
        for (int dir = 0; dir < 4; dir++) {
            int nx = x;
            int ny = y;
            for (int kk = 0; kk < K; kk++) {
                nx += dx[dir];
                ny += dy[dir];

                if (isBoundary(nx, ny) && arr[nx][ny] == findWord) {
                    dfs(nx, ny, idx + 1);
                    memo[x][y][idx] += memo[nx][ny][idx + 1];
                }

            }
        }

    }

    public static boolean isBoundary(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }


}