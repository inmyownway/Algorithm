import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int N = 9;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
    }

    public static void dfs(int x, int y) {
        if (x == N) {
            // 모든 셀이 채워졌을 때 출력 후 종료
            printBoard();
            System.exit(0);
        }

        if (board[x][y] == 0) {
            for (int num = 1; num <= 9; num++) {
                if (isValid(x, y, num)) { // 사용 가능한 숫자인지 체크
                    board[x][y] = num; // 해당 숫자를 채워 넣음
                    int nextY = (y + 1) % N; // 다음 열로 이동
                    int nextX = (nextY == 0) ? x + 1 : x; // 다음 행으로 이동
                    dfs(nextX, nextY); // 다음 셀로 이동
                    board[x][y] = 0; // 재귀 호출이 끝나면 해당 셀을 초기화하여 다른 숫자를 시도
                }
            }
        } else { // 이미 숫자가 채워진 셀인 경우 다음 셀로 이동
            int nextY = (y + 1) % N;
            int nextX = (nextY == 0) ? x + 1 : x;
            dfs(nextX, nextY);
        }
    }

    // 주어진 숫자가 현재 셀에 사용 가능한지 체크하는 함수
    public static boolean isValid(int x, int y, int num) {
        // 가로, 세로 체크
        for (int i = 0; i < N; i++) {
            if (board[x][i] == num || board[i][y] == num) {
                return false;
            }
        }

        // 3x3 영역 체크
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    // 현재 보드 상태 출력 함수
    public static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}