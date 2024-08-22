import java.util.*;
import java.io.*;

public class Main {
    static int[][][] check;
    static int[] cup;
    static int A, B, C;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        answer = new ArrayList<>();
        check = new int[201][201][201];
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dfs(0, 0, C);

        Collections.sort(answer);
        for (int num : answer) {
            System.out.print(num + " ");
        }

    }

    public static void dfs(int a, int b, int c) {

       // System.out.println(a + " " + b + " " + c);

        if (check[a][b][c] == 1) {
            return;
        }
        if (a == 0) {
            answer.add(c);
        }
        check[a][b][c] = 1;

        // C -> A
        if (a != A && c != 0) {
            int pA = A - a;
            if (pA >= c) {
                dfs(a + c, b, 0);

            } else {
                dfs(A, b, c - pA);
            }
        }

        // C -> B
        if (b != B && c != 0) {
            int pB = B - b;
            if (pB >= c) {
                dfs(a, b + c, 0);

            } else {
                dfs(a, B, c - pB);
            }
        }

        // B- > C
        if (c != C && b != 0) {
            int pC = C - c;
            if (pC >= b) {
                dfs(a, 0, b + c);

            } else {
                dfs(a, b - pC, C);
            }
        }
        // B -> A
        if (a != A && b != 0) {
            int pA = A - a;
            if (pA >= b) {
                dfs(a + b, 0, c);

            } else {
                dfs(A, b - pA, c);
            }
        }

        // A -> B
        if (b != B && a != 0) {
            int pB = B - b;
            if (pB >= a) {
                dfs(0, a + b, c);

            } else {
                dfs(a - pB, B, c);
            }
        }
        // A -> C
        if (c != C && a != 0) {
            int pC = C - c;
            if (pC >= a) {
                dfs(0, b, c + a);

            } else {
                dfs(a - pC, b, C);
            }
        }

    }
}