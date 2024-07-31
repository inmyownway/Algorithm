import java.util.*;
import java.io.*;

public class Main {

    static int[] damage = new int[]{9, 3, 1};
    static int arr[];
    static int answer = Integer.MAX_VALUE;
    static boolean[][][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        arr = new int[3];
        v = new boolean[61][61][61];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, arr[0], arr[1], arr[2]);
        System.out.println(answer);
    }

    public static void dfs(int cnt, int a, int b, int c) {
        boolean flag = false;
        if (a < 0) {
            a = 0;
        }
        if (b < 0) {
            b = 0;
        }
        if (c < 0) {
            c = 0;
        }
        if (a < 1 && b < 1 && c < 1) {
            flag = true;
        }
        if (answer < cnt) {
            return;
        }
        if (flag) {
            answer = Math.min(answer, cnt);

            return;

        }

        int[] s = new int[]{a, b, c};
        Arrays.sort(s);

        a = s[2];
        b = s[1];
        c = s[0];
      

        if (v[a][b][c]) {
            return;
        } else {
            v[a][b][c] = true;
        }

        dfs(cnt + 1, a - 9, b - 3, c - 1);
        dfs(cnt + 1, a - 9, b - 1, c - 3);
        dfs(cnt + 1, a - 3, b - 9, c - 1);
        dfs(cnt + 1, a - 3, b - 1, c - 9);
        dfs(cnt + 1, a - 1, b - 9, c - 3);
        dfs(cnt + 1, a - 1, b - 3, c - 9);
        return;
    }
}