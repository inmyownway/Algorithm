import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(bf.readLine());

        }

        Arrays.sort(arr);
        int left = 0;
        int right = 0;
        int num = 0;
        // 1 2 3 4 5

        while (right < N) {

            // System.out.println(left + " " + right);
            num = arr[right] - arr[left];

            if (num < M) {
                right++;
            } else if (num > M) {
                answer = Math.min(answer, num);
                left++;
            } else {
                answer = num;
                break;
            }


        }
        System.out.println(answer);
        // 코드를 작성해주세요
    }
}