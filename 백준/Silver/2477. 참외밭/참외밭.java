import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int maxW, minW, maxH, minH;
    static int idxH, idxW;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        // 코드를 작성해주세요
        maxW = Integer.MIN_VALUE;
        maxH = Integer.MIN_VALUE;

        minW = Integer.MAX_VALUE;

        int[] dir = new int[6];
        int[] r = new int[6];
        minH = Integer.MAX_VALUE;

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            dir[i] = num;
            if (n == 1 || n == 2) {
                if (maxW < num) {
                    idxW = i;
                }
                maxW = Math.max(maxW, num);


            } else {
                if (maxH < num) {
                    idxH = i;
                }
                maxH = Math.max(maxH, num);

            }
        }

//        int minW = dir[(idxW + 3) % 6];
//        int minH = dir[(idxH + 3) % 6];
        // System.out.println(minW * minH);
        System.out.println(N * (maxW * maxH - (dir[(idxW + 3) % 6]) * dir[(idxH + 3) % 6]));
    }
}
