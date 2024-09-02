import java.util.*;

class Solution {
    static int N;
    static int zeroCnt, oneCnt;

    public int[] solution(int[][] arr) {
        zeroCnt = 0;
        oneCnt = 0;
        N = arr.length;

        dfs(0, 0, N, arr);

        return new int[]{zeroCnt, oneCnt};
    }

    public static void dfs(int x, int y, int size, int[][] board) {
        if (isUniform(x, y, size, board)) {
            if (board[x][y] == 0) {
                zeroCnt++;
            } else {
                oneCnt++;
            }
            return;
        }

        int newSize = size / 2;

        dfs(x, y, newSize, board); 
        dfs(x, y + newSize, newSize, board);
        dfs(x + newSize, y, newSize, board); 
        dfs(x + newSize, y + newSize, newSize, board); 
    }

    public static boolean isUniform(int x, int y, int size, int[][] board) {
        int first = board[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}
