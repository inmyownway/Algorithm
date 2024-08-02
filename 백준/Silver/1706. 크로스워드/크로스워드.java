import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static char[][] board;
    static ArrayList<String> arr;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = bf.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        int cnt;
        for (int i = 0; i < N; i++) {
            String str = "";
            cnt = 0;
            for (int j = 0; j < M; j++) {

                if (board[i][j] != '#') {
                    str += board[i][j];
                    cnt++;

                    if (j + 1 == M && cnt > 1) {
                        arr.add(str);
                    }
                } else {
                    if (cnt > 1) {
                        arr.add(str);
                    }
                    str = "";
                    cnt = 0;
                }
            }
        }

        cnt = 0;
        for (int i = 0; i < M; i++) {
            String str = "";
            cnt = 0;
            for (int j = 0; j < N; j++) {

                if (board[j][i] != '#') {
                    str += board[j][i];
                    cnt++;

                    if (j + 1 == N && cnt > 1) {
                        arr.add(str);
                    }
                } else {
                    if (cnt > 1) {
                        arr.add(str);
                    }
                    str = "";
                    cnt = 0;
                }
            }
        }

        Collections.sort(arr);

        System.out.println(arr.get(0));


    }
}
