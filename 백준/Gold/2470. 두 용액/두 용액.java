import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int ax, ay;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N]
        ;

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int leftIdx = 0;
        int rightIdx = N - 1;
        int min = Integer.MAX_VALUE;
        while (leftIdx < rightIdx) {

            int sum = arr[leftIdx] + arr[rightIdx];

            if (min > Math.abs(arr[leftIdx] + arr[rightIdx])) {
                min = Math.abs(arr[leftIdx] + arr[rightIdx]);
                ax = arr[leftIdx];
                ay = arr[rightIdx];
            }

            if (sum > 0) {
                rightIdx--;

            } else {
                leftIdx++;
            }
        }

        // -99 -2 -1 4 98a
        System.out.printf(ax + " " + ay);
    }

}