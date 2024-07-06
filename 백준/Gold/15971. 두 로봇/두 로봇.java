import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, S, E;
    static int[][] board;
    static int[] A;
    static int[] B;
    static boolean[][] v;
    static long answer;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken()) - 1;
        E = Integer.parseInt(st.nextToken()) - 1;
        answer = Integer.MAX_VALUE;
        board = new int[N][N];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            board[x - 1][y - 1] = s;
            board[y - 1][x - 1] = s;
        }
        A = new int[N];
        B = new int[N];
        v = new boolean[N][2];

        Queue<Integer> a = new LinkedList<>();
        Queue<Integer> b = new LinkedList<>();

        a.add(S);
        b.add(E);
        if (S == E) {
            System.out.println(0);
            return;
        }
        v[S][0] = true;
        v[E][1] = true;
        while (!a.isEmpty() || !b.isEmpty()) {

            int nowA = a.poll();
            int nowB = b.poll();

            // A,B확인?
            if (board[nowA][nowB] != 0) {
                answer = Long.min(answer, A[nowA] + B[nowB]);
            }
            // A부터 돌림

            for (int i = 0; i < N; i++) {
                if (board[nowA][i] != 0 && !v[i][0]) {

                    v[i][0] = true;
                    a.add(i);
                    A[i] = A[nowA] + board[nowA][i];

                    //System.out.println(i + " " + A[i]);
                    for (int j = 0; j < N; j++) {
                        if (v[j][1]) {
                            if (board[i][j] > 0) {

                                answer = Long.min(answer, A[i] + B[j]);

                                // System.out.println(answer);
                            }
                        }
                    }

                }
            }

            // B

            for (int i = 0; i < N; i++) {
                if (board[nowB][i] != 0 && !v[i][1]) {

                    v[i][1] = true;
                    b.add(i);
                    B[i] = B[nowB] + board[nowB][i];

                    for (int j = 0; j < N; j++) {
                        if (v[j][0]) {
                            if (board[i][j] > 0) {
                                answer = Long.min(answer, B[i] + A[j]);

                            }
                        }
                    }

                }
            }
            // System.out.println(Arrays.toString(A));
            //System.out.println(Arrays.toString(B));
            //System.out.println();

        }
        System.out.println(answer);


    }
}