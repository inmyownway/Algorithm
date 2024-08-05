import java.util.*;
import java.io.*;

public class Main {
    static int A, B;
    static String ans;
    static String[] command;
    static boolean[] v;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int testCase = Integer.parseInt(st.nextToken());

        for (int t = 0; t < testCase; t++) {

            v = new boolean[10000];
            st = new StringTokenizer(bf.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            command = new String[10001];
            for (int i = 0; i <= 10000; i++) {
                command[i] = "";
            }
            q = new LinkedList<>();
            q.add(A);
            v[A] = true;

            while (!q.isEmpty() && !v[B]) {

                int num = q.poll();

                int D = num * 2;
                if (D > 9999) {
                    D %= 10000;
                }
                int S = 0;
                if (num == 0) {
                    S = 9999;
                } else {
                    S = num - 1;
                }
                int L = (num % 1000) * 10 + num / 1000;// * 1000 + num / 10 * 100 + num % 1000 * 10 + num / 1000;
                int R = (num % 10) * 1000 + num / 10;
                if (!v[D]) {
                    q.add(D);
                    v[D] = true;
                    command[D] = command[num] + "D";
                }
                if (!v[S]) {
                    q.add(S);
                    v[S] = true;
                    command[S] = command[num] + "S";
                }
                if (!v[L]) {
                    q.add(L);
                    v[L] = true;
                    command[L] = command[num] + "L";
                }
                if (!v[R]) {
                    q.add(R);
                    v[R] = true;
                    command[R] = command[num] + "R";
                }

            }
            System.out.println(command[B]);
        }

    }


}