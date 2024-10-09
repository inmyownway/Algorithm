import java.util.*;
import java.io.*;

public class Main {


    static int N, M, R, com;
    static int[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < R; i++) {
            com = Integer.parseInt(st.nextToken());

            if (com == 1) {
                {
                    simul1();

                }
            } else if (com == 2) {
                simul2();

            } else if (com == 3) {
                simul3();

            } else if (com == 4) {
                simul4();
            } else if (com == 5) {
                simul5();
            } else if (com == 6) {
                simul6();
            }


        }
        print();

    }

    public static void simul1() {
        int[][] temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                temp[N - 1 - i][j] = board[i][j];
            }
        }

        copy(temp);


    }

    public static void simul2() {
        int[][] temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                temp[i][M - 1 - j] = board[i][j];
            }
        }

        copy(temp);


    }

    public static void simul3() {
        int[][] temp = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                temp[j][N - 1 - i] = board[i][j];
            }
        }

        int tt = M;
        M = N;
        N = tt;
        board = temp;

        //copy(temp);

    }

    public static void simul4() {
        int[][] temp = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                temp[M - j - 1][i] = board[i][j];
            }
        }
        int tt = M;
        M = N;
        N = tt;
        board = temp;

        //copy(temp);

    }

    public static void simul5() {
        int[][] temp = new int[N][M];

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                temp[i][(M / 2 + j)] = board[i][j];
            }
        }

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                temp[N / 2 + i][(M / 2 + j)] = board[i][(M / 2) + j];
            }
        }

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                temp[N / 2 + i][j] = board[N / 2 + i][(M / 2) + j];
            }
        }

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                temp[i][j] = board[N / 2 + i][j];
            }
        }
        copy(temp);


    }

    public static void simul6() {

        int[][] temp = new int[N][M];

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                temp[(N / 2) + i][j] = board[i][j];
            }
        }

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                temp[N / 2 + i][(M / 2 + j)] = board[(N / 2) + i][j];
            }
        }

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                temp[i][M / 2 + j] = board[N / 2 + i][(M / 2) + j];
            }
        }

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                temp[i][j] = board[i][M / 2 + j];
            }
        }
        copy(temp);
    }

    public static void copy(int[][] temp) {

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = temp[i][j];
            }
        }
    }

    public static void copy2(int[][] temp) {

        board = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = temp[i][j];
            }
        }
    }

    public static void print() {

//        if (board.length <= board[0].length) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
//        } else {
//            for (int i = 0; i < M; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(board[i][j] + " ");
//                }
//                System.out.println();
//            }
//        }
    }

}