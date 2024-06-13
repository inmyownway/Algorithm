import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<int[]> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr.add(new int[]{x, y});
        }

        Collections.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o2[0] - o1[0];
                }
                return o1[1] - o2[1];
            }
        });

        int ans = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int[] now = arr.get(i);

            if (q.size() < now[1]) {
                q.add(now[0]);
            } else if (q.size() == now[1]) {

                if (q.peek() < now[0]) {
                    q.poll();
                    q.add(now[0]);
                }
            }
        }
        while (!q.isEmpty()) {
            ans += q.poll();
        }
        System.out.println(ans);
    }
}