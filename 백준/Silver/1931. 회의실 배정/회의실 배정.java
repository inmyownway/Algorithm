import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<int[]> arr;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine()); // 회의의 수 읽기

        arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken()); // 시작 시간
            int e = Integer.parseInt(st.nextToken()); // 종료 시간

            arr.add(new int[]{s, e});
        }

        // 종료 시간 기준으로 정렬, 종료 시간이 같으면 시작 시간으로 정렬
        Collections.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int cnt = 1;
        int[] pre = arr.get(0);
        for (int i = 1; i < N; i++) {
            int[] now = arr.get(i);
            if (pre[1] <= now[0]) { // 이전 회의의 종료 시간보다 현재 회의의 시작 시간이 같거나 늦다면
                cnt++;
                pre = now; // 현재 회의를 이전 회의로 설정
            }
        }
        System.out.println(cnt); // 최대 사용할 수 있는 회의실의 수 출력
    }
}