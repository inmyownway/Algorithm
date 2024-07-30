import java.io.*;//BufferedReader;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] arr;
    static int start, end;
    static boolean[] v;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 1
        // 2 3
        N = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }
        st = new StringTokenizer(bf.readLine());

        start = Integer.parseInt(st.nextToken()) - 1;
        end = Integer.parseInt(st.nextToken()) - 1;
        M = Integer.parseInt(bf.readLine());
        v = new boolean[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            arr[x].add(y);
            arr[y].add(x);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});

        v[start] = true;

        int answer = -1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == end) {
                answer = now[1];
                break;
            }
            for (int num : arr[now[0]]) {
                if (!v[num]) {
                    q.add(new int[]{num, now[1] + 1});
                    v[num] = true;
                }
            }
        }

        System.out.println(answer);
    }
}