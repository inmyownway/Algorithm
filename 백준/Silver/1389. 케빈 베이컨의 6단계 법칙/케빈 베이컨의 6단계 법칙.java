import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static int N, M;
    static boolean[] v;
    static int answer = Integer.MAX_VALUE;
    static int answerPerson = Integer.MAX_VALUE;
    static int[] cnt;
    static int[] temp;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();

        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x - 1].add(y - 1);
            arr[y - 1].add(x - 1);
        }
        temp = new int[N];
        for (int i = 0; i < N; i++) {
            v = new boolean[N];
            cnt = new int[N];

            for (int j = 0; j < N; j++) {
                cnt[j] = Integer.MAX_VALUE;
            }
            cnt[i] = 0;
            find(i);
        }

        for (int i = 0; i < N; i++) {
            if (temp[i] == answer) {
                answerPerson = i;
                break;
            }
        }
        System.out.println(answerPerson + 1);
    }

    public static void find(int x) {
        Queue<int[]> q = new LinkedList<>();

        //     System.out.println("X: " + x);
        q.add(new int[]{x, 0});
        v[x] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int n = now[0];
            int c = now[1];

            for (int num : arr[n]) {
                if (!v[num] && cnt[num] > c) {
                    cnt[num] = Math.min(cnt[num], c + 1);
                    v[num] = true;
                    q.add(new int[]{num, c + 1});
                }
            }


        }
        //  System.out.println(Arrays.toString(cnt));
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += cnt[i];
        }
        temp[x] = result;
        answer = Math.min(answer, result);
    }
}