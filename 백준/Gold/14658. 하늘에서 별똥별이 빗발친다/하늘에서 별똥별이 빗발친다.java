import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int W, H, L, K;
    static int[][] board;
    static int answer = Integer.MIN_VALUE;
    static ArrayList<int[]> arr;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //  board[y - 1][x - 1] = 1;
            arr.add(new int[]{x, y});
        }
        Collections.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

//        for (int k = 0; k < K; k++) {
//
//            int[] now = arr.get(k);
//
//            //System.out.println(Arrays.toString(now));
//            check(now[0], now[1]);
//
//        }

        for (int[] now1 : arr) {

            for (int[] now2 : arr) {
                check(now1[0], now2[1]);
            }
        }
        System.out.println(K - answer);

    }

    public static void check(int x, int y) {
        int cnt = 0;

        for (int idx = 0; idx < K; idx++) {
            int[] now = arr.get(idx);

            if (now[0] >= x && now[0] <= x + L && now[1] >= y && now[1] <= y + L) {
                {
                    cnt++;
                }
            }

        }

        answer = Math.max(answer, cnt);


    }


}