import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] degree;
    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] v;


    public static void main(String[] agrs) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        degree = new int[N + 1];
        arr = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {

            arr.add(new ArrayList<>());

        }

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            degree[y] += 1;

            arr.get(x).add(y);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now + " ");

            for (int num : arr.get(now)) {

                degree[num]--;
                if (degree[num] == 0) {
                    q.add(num);
                }
            }
        }

        System.out.println(sb);
    }


}