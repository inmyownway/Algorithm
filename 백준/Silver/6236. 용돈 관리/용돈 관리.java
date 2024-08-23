import java.util.*;
import java.io.*;

// N일동안 M번만 K원 인출
// 모자라면 나머지금액 넣고 다시 K원 인출


public class Main {
    static int N, M;
    static int[] money;
    static long answer;

    public static void main(String[] args) throws IOException {
        // 코드를 작성해주세요

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N];

        int left = 0;
        int right = 0;
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(bf.readLine());
            left = Math.max(left, money[i]);
            right += money[i];
        }

        while (left <= right) {

            int K = (left + right) / 2;

            long now = K;
            int cnt = 1;

            boolean exceed = false;
            for (int i = 0; i < N; i++) {
                if (now < money[i]) {

                    cnt++;
                    now = K;
                }
                now -= money[i];
            }

            if (cnt <= M) {
                right = K - 1;

            } else {
                left = K + 1;
            }


        }
        System.out.println(left);


    }
}