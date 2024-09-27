import java.util.*;
import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 입력으로 N을 받음
        N = Integer.parseInt(bf.readLine());
        
        // 두 번째 줄에서 x1, x2, x3을 받음
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int x3 = Integer.parseInt(st.nextToken());

        // dp1과 dp2는 처음 주어진 값을 그대로 저장
        int[] dp1 = new int[3];
        int[] dp2 = new int[3];
        
        dp1[0] = x1;
        dp1[1] = x2;
        dp1[2] = x3;

        dp2[0] = x1;
        dp2[1] = x2;
        dp2[2] = x3;

        // 이후 N-1번 반복
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            // 다음 세 개의 숫자를 입력받음
            x1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            x3 = Integer.parseInt(st.nextToken());

            // 최대값을 계산하기 위한 임시 변수
            int max1 = Math.max(dp1[0] + x1, dp1[1] + x1);  // x1에 올 수 있는 이전 값들
            int max2 = Math.max(dp1[0] + x2, Math.max(dp1[1] + x2, dp1[2] + x2));  // x2에 올 수 있는 이전 값들
            int max3 = Math.max(dp1[1] + x3, dp1[2] + x3);  // x3에 올 수 있는 이전 값들

            // 최소값을 계산하기 위한 임시 변수
            int min1 = Math.min(dp2[0] + x1, dp2[1] + x1);
            int min2 = Math.min(dp2[0] + x2, Math.min(dp2[1] + x2, dp2[2] + x2));
            int min3 = Math.min(dp2[1] + x3, dp2[2] + x3);

            // dp1과 dp2 갱신
            dp1[0] = max1;
            dp1[1] = max2;
            dp1[2] = max3;

            dp2[0] = min1;
            dp2[1] = min2;
            dp2[2] = min3;
        }

        // 결과 출력: dp1에서 최대값, dp2에서 최소값 출력
        System.out.print(Math.max(dp1[0], Math.max(dp1[1], dp1[2])) + " ");
        System.out.print(Math.min(dp2[0], Math.min(dp2[1], dp2[2])));
    }
}
