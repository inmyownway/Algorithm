import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] paper;
    static int cnt;
    static int[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(bf.readLine());

        paper = new int[6];
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(bf.readLine());
            paper[i] = Integer.parseInt(st.nextToken());
        }

        
        boolean first= true;
        for (int i = 0; i < 6; i++) {
            if (paper[i] != 0) {
                first=false;
            }

        }
        if(first)
        {
            System.out.println(0);
            return;
        }
        //System.out.println(Arrays.toString(paper));

        while (true) {
            boolean flag = false;
            board = new int[6][6];
            cnt++;
            //System.out.println("사용 판:" + cnt);

            for (int i = 5; i > -1; i--) {
                //ystem.out.println("i " + i);
                if (paper[i] >= 1) {
                    //System.out.println((i + 1) + "*" + (i + 1) + " 접기 시작");
                    flag = true;

                    int c = paste(i + 1);
                    //  System.out.println("쓴 횟수 " + c);
                    // 붙이기
                    paper[i] -= c;
                }
                // System.out.println();
            }

            // 다 0 이면 종료

            boolean exit = false;
            for (int i = 0; i < 6; i++) {
                if (paper[i] != 0) {
                    exit = true;
                }

            }
            if (!exit) {
                break;
            }
            // System.out.println();
            //System.out.println("@@@@@@@@@@");
            //  System.out.println();
        }
        System.out.println(cnt);

    }

    public static int paste(int idx) {
        int paperCnt = paper[idx - 1];

        int useCnt = 0;
        // System.out.println("idx " + idx);

        // System.out.println("paper수: " + paperCnt);
        for (int c = 0; c < paperCnt; c++) {

            for (int i = 0; i < 6 - idx + 1; i++) {
                for (int j = 0; j < 6 - idx + 1; j++) {
                    if (paperCnt - useCnt == 0) {
                        break;
                    }
                    boolean check = false;

                    for (int a = i; a < i + idx; a++) {
                        for (int b = j; b < j + idx; b++) {
                            if (board[a][b] == 1) {
                                check = true;
                                break;
                            }
                        }
                        if (check) {
                            break;
                        }
                    }

                    if (!check) {
                        //System.out.println("사용");
                        for (int a = i; a < i + idx; a++) {
                            for (int b = j; b < j + idx; b++) {
                                board[a][b] = 1;

                            }

                        }
                        useCnt++;
                    }

                }
            }

        }
        //System.out.println("useCnt " + useCnt);
        return useCnt;
    }

}