import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N];

        int maxExpense = 0;
        int totalExpense = 0;

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(bf.readLine());
            maxExpense = Math.max(maxExpense, money[i]);
            totalExpense += money[i];
        }

        // 이분 탐색을 위해 초기화
        int left = maxExpense;  // 최소 인출 금액은 하루에 필요한 최대 금액이어야 함
        int right = totalExpense;  // 최대 인출 금액은 모든 금액을 한 번에 인출하는 경우

        while (left <= right) {
            int K = (left + right) / 2;

            // K로 인출할 때 필요한 인출 횟수를 계산
            int count = 1;
            int currentAmount = K;

            for (int i = 0; i < N; i++) {
                if (currentAmount < money[i]) {
                    count++;
                    currentAmount = K;
                }
                currentAmount -= money[i];
            }

            if (count <= M) {
                right = K - 1;  // 가능한 K의 범위를 줄이기 위해 상한을 낮춤
            } else {
                left = K + 1;  // 인출 횟수가 너무 많다면 K를 늘려야 함
            }
        }

        // 최종적으로 left는 최소 인출 금액을 가리킴
        System.out.println(left);
    }
}