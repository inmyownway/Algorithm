import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int test = 0; test < testCase; test++) {

            st = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(st.nextToken());
            arr = new int[N];

            st = new StringTokenizer(bf.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long ans = 0L;

            int max = arr[N - 1];

            for (int j = N - 2; j > -1; j--) {
                if (arr[j] <= max) {

                    ans += max - arr[j];
                } else {
                    max = arr[j];
                }
            }
            System.out.println(ans);


        }


    }
}