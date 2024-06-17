import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static char[][] arr;
    static boolean[][][] v;
    static String answer;
    static int cnt;
    static int maxLen = Integer.MIN_VALUE;
    static Map<String, Integer> map;
    static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = bf.readLine();

            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        map = new HashMap<>();
        String[] valueSet = new String[K];
        for (int i = 0; i < K; i++) {
            answer = bf.readLine();

            map.put(answer, 0);

            valueSet[i] = answer;
            maxLen = Math.max(maxLen, answer.length());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                find(i, j, "" + arr[i][j]);
            }
        }

        for (int i = 0; i < K; i++) {
            System.out.println(map.get(valueSet[i]));
        }
    }

    public static void find(int x, int y, String words) {

        if (map.get(words) != null) {

            map.put(words, map.get(words) + 1);

        }
        if (words.length() == maxLen) {
            return;
        }

        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            nx = checkX(nx);
            ny = checkY(ny);

            find(nx, ny, words + arr[nx][ny]);


        }


    }

    public static int checkX(int x) {
        if (x >= N) {
            return 0;
        } else if (x < 0) {
            return N - 1;
        }

        return x;
    }

    public static int checkY(int x) {
        if (x >= M) {
            return 0;
        } else if (x <0) {
            return M - 1;
        }

        return x;
    }
}