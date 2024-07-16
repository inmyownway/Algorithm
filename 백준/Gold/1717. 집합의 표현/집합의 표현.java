import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        // 코드를 작성해주세요
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N+1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (num == 0) {
                union(a, b);
            } else if (num == 1) {
                if (a == b) {
                    System.out.println("YES");
                } else if (find(a) == find(b)) {
                    System.out.println("YES");
                } else if (find(a) != find(b)) {
                    System.out.println("NO");
                }
            }
        }


    }

    public static int find(int num) {
        if (num == parents[num]) {
            return num;
        }

        return parents[num] = find(parents[num]);
    }

    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot < bRoot) {
            parents[bRoot] = aRoot;
        } else {
            parents[aRoot] = bRoot;

        }
    }
}