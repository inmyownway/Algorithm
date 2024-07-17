import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] arr;
    static boolean[] v;
    static boolean answer;

    public static void main(String[] args) throws IOException {
        // 코드를 작성해주세요
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];
        v = new boolean[N];
        for (int i = 0; i < N; i++) {

            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);

        }

        for (int i = 0; i < N; i++) {
            v[i] = true;
            dfs(i, 0);
            v[i] = false;
            if(answer)
                break;

        }

        if (answer) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void dfs(int idx, int depth) {
        if (depth == 4) {
            answer = true;
            return;
        }

        if (depth >= 5) {
            return;
        }

        for (int num : arr[idx]) {
            if (!v[num]) {
                v[num] = true;
                dfs(num, depth + 1);
                v[num] = false;
            }
        }


    }


}