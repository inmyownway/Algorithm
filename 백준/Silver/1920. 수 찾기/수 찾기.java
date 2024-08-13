import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new int[N];
    

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        M = Integer.parseInt(bf.readLine());

        st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            boolean flag = binarySearch(Integer.parseInt(st.nextToken()));
            if (flag) {
                sb.append(1);
            } else {
                sb.append(0);
            }

            if (i != M - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);

    }

    public static boolean binarySearch(int n) {

        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (A[mid] == n) {
                return true;
            }
            if (n > A[mid]) {
                left = mid + 1;
            } else if (n < A[mid]) {
                right = mid - 1;
            }
        }
        return false;
    }
}