import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] trees;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];

        int right = Integer.MIN_VALUE;
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {

            int num = Integer.parseInt(st.nextToken());
            trees[i] = num;
            right = Integer.max(right, num);
        }

        int left = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            long sum = 0;
            //System.out.println(left + " " + right);

            for (int i = 0; i < trees.length; i++) {
                if (trees[i] - mid > 0) {
                    sum += (trees[i] - mid);
                }

            }
            // System.out.println(sum);
            if (M <= sum) {

                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left - 1);
    }
}