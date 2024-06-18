import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static long T;
    static int n, m;

    static long[] a, b;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        T = Long.parseLong(st.nextToken());

        n = Integer.parseInt(bf.readLine());
        a = new long[n];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        m = Integer.parseInt(bf.readLine());

        b = new long[m];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Long.parseLong(st.nextToken());
        }

        List<Long> sumA = new ArrayList<>();
        List<Long> sumB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long temp = a[i];
            sumA.add(temp);
            for (int j = i + 1; j < n; j++) {
                temp += a[j];
                sumA.add(temp);
            }
        }
        for (int i = 0; i < m; i++) {
            long temp = b[i];
            sumB.add(temp);
            for (int j = i + 1; j < m; j++) {
                temp += b[j];
                sumB.add(temp);
            }
        }

        Collections.sort(sumA);
        Collections.sort(sumB, Comparator.reverseOrder());

        long answer = 0;

        int ptA = 0;
        int ptB = 0;

        //  sum = ptA + ptB
        // sum > T 면 ptB +1;
        // sum < T 면 ptA +1;
        // sum= == T 게속 찾아봐야함 같은게 몇개있는지

        while (true) {

            long currentA = sumA.get(ptA);
            long currentB = sumB.get(ptB);

            long sum = currentA + currentB;

            if (sum == T) {
                long countA = 0;
                long countB = 0;

                while (ptA < sumA.size() && currentA == sumA.get(ptA)) {
                    countA++;
                    ptA++;
                }

                while (ptB < sumB.size() && currentB == sumB.get(ptB)) {
                    countB++;
                    ptB++;
                }
                answer += countA * countB;

            } else if (sum > T) {
                ptB++;
            } else if (sum < T) {
                ptA++;
            }

            if (ptA == sumA.size() || ptB == sumB.size()) {
                break;
            }
        }
        System.out.println(answer);
    }
}