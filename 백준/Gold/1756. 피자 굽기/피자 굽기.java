import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] oven;
    static int[] pizza;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        oven = new int[N];
        pizza = new int[M];

        // 오븐 입력
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            oven[i] = Integer.parseInt(st.nextToken());
        }

        // 피자 입력
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < M; i++) {
            pizza[i] = Integer.parseInt(st.nextToken());
        }

        // 오븐의 각 깊이별로, 윗쪽 오븐의 크기보다 크면 안되므로 최솟값으로 유지
        for (int i = 1; i < N; i++) {
            oven[i] = Math.min(oven[i], oven[i - 1]);
        }

        int lastIdx = N - 1; // 마지막 오븐의 위치

        // 각 피자를 오븐에 넣을 수 있는지 확인
        for (int i = 0; i < M; i++) {
            while (lastIdx >= 0 && oven[lastIdx] < pizza[i]) {
                lastIdx--; // 오븐의 크기가 피자보다 작으면 위로 올라감
            }
            if (lastIdx < 0) { // 더 이상 피자를 넣을 곳이 없음
                System.out.println(0);
                return;
            }
            lastIdx--; // 피자를 넣었으므로 그 위치는 더이상 사용 불가
        }

        // 마지막으로 피자가 들어간 위치 출력 (1-based index)
        System.out.println(lastIdx + 2);
    }
}