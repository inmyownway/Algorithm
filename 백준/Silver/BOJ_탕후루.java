import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] num;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        num = new int[10];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            arr[i] = t;

        }

        int left = 0;
        int right = 0;
        int idx = 0;
        int cnt = 0;
        int kind = 0;

        while (right < N) {

            num[arr[right++]] += 1;

            cnt = 0;

            for (int i = 0; i < 10; i++) {
                if (num[i] >= 1) {
                    cnt++;
                }
            }

            kind = cnt;

            if (kind > 2) {

                while (true) {
                    if (kind <= 2) {
                        break;
                    }

                    num[arr[left++]] -= 1;

                    cnt = 0;
                    for (int i = 0; i < 10; i++) {
                        if (num[i] >= 1) {
                            cnt++;
                        }
                    }

                    kind = cnt;

                }
            }
            cnt = 0;
            for (int i = 0; i < 10; i++) {
                cnt += num[i];
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }

    public static void simul(int start, int end, int[] num) {
        if (check(num)) {
            int temp = 0;
            for (int i = 0; i < 10; i++) {
                temp += num[i];
            }
            answer = Math.max(temp, answer);
            return;

        }
        if (start <= end) {
            return;
        }
        // 처음꺼 빼기
        num[arr[start]] -= 1;
        simul(start + 1, end - 1, num);
        num[arr[start]] += 1;

        // 뒤에꺼 빼기
        num[arr[end]] -= 1;
        simul(start + 1, end - 1, num);
        num[arr[end]] += 1;

        // 둘다뺴기
        num[arr[end]] -= 1;
        num[arr[start]] -= 1;
        simul(start + 1, end - 1, num);
        num[arr[end]] += 1;
        num[arr[start]] += 1;
    }

    public static boolean check(int[] num) {
        int cnt = 0;

        for (int i = 0; i < 10; i++) {
            if (num[i] >= 1) {
                cnt++;
            }
        }
        if (cnt >= 2) {
            return true;
        }
        return false;

    }
}
