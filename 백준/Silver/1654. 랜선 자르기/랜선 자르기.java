import java.util.*;
import java.io.*;

public class Main {
    static int K, N;
    static int[] line;
    static long answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        // 코드를 작성해주세요

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        line = new int[K];

        long left = 1;
        long right = 0;
        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(bf.readLine());//.nextToken());
            right = Math.max(line[i], right);
        }

        while (left <= right) {
            long mid = (left + right) / 2;

            long temp = 0;
            for (int i = 0; i < K; i++) {
                temp += line[i] / mid;
            }
            if (temp < N) { //

                right = mid - 1;

            } else {

                left = mid + 1;
            }
        }
        System.out.println(right);
    }
}