import java.util.*;
import java.io.*;

public class Main {
    static int n, x, y;
    static int[] arr;
    static boolean[] v;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 코드를 작성해주세요
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        arr = new int[n * 2 + 1];
        v = new boolean[13];

        arr[y] = arr[x] = y - x - 1;
        v[y - x - 1] = true;
        cnt = 0;

        dfs(1);
        System.out.println(cnt);
    }

    public static void dfs(int idx) {

        if (idx == n * 2 + 1) {
            cnt++;
            return;
        }
        if (arr[idx] == 0) {

            for (int i = 1; i < n + 1; i++) {
                if (!v[i]) {
                    if (idx + i + 1 <= n * 2 && arr[idx + i + 1] == 0) {

                        v[i] = true;
                        arr[idx] = arr[idx + i + 1] = i;

                        dfs(idx + 1);

                        arr[idx] = arr[idx + i + 1] = 0;
                        v[i] = false;
                    }
                }
            }
        } else {
            dfs(idx + 1);
        }
    }


}