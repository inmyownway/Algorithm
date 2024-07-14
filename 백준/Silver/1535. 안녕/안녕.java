import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] hp;
    static int[] joy;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());

        hp = new int[N];
        joy = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {

            hp[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());
        for (int j = 0; j < N; j++) {
            joy[j] = Integer.parseInt(st.nextToken());

        }

        dfs(0, 100, 0);

        System.out.print(answer);
    }

    public static void dfs(int idx, int h, int sum) {
        if (idx == N || h <= 0) {
            answer = Math.max(sum, answer);
            return;
        }

        // 현재꺼 선택
        if (h - hp[idx] > 0) {
            dfs(idx + 1, h - hp[idx], sum + joy[idx]);
        }

        // 현재꺼 선택 x
        dfs(idx + 1, h, sum);


    }


}