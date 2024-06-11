import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
                return Integer.compare(o1[0], o2[0]);
            }
        });

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < arr.size(); i++) {
            int[] now = arr.get(i);

            // 데드라인이 큰 경우
            if (q.size() < now[0]) {
                q.add(now[1]);
            } else if (q.size() >= now[0]) {
                // 지금까지 푼 시간보다 데드라인이 같거나 작은경우
                if (q.peek() < now[1]) {
                    q.poll();
                    q.add(now[1]);
                }
            }
            //System.out.println(q.size() + " " + q.peek());

        }
        int ans = 0;
        //System.out.println(q.size());
        int size = q.size();
        for (int i = 0; i < size; i++) {
            ans += q.poll();
        }
        System.out.println(ans);

    }
}