import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static int N;
    static int[][] arr;
    static int[] originColor;
    static boolean[] visited;
    static int[] permColor;
    static int answer= Integer.MAX_VALUE;
    static int[] nums;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;


        int testcase=Integer.parseInt(bf.readLine());

        for(int t=1;t<testcase+1;t++) {
            N = Integer.parseInt(bf.readLine());

            st = new StringTokenizer(bf.readLine());

            // 나라 컬러 입력받는곳
            originColor = new int[N];
            for (int i = 0; i < N; i++) {
                originColor[i] = Integer.parseInt(st.nextToken());
            }

            // 2차원 배열 입력받는 부분
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {

                    int tt = Integer.parseInt(st.nextToken());
                    if (tt == 1) {
                        arr[i][j] = j + 1;
                    } else
                        arr[i][j] = 0;

                }
            }


            nums = new int[N];
            permColor = new int[]{1,2,3,4};
            answer=Integer.MAX_VALUE;

            perm(0);
            System.out.println("#"+t+" "+answer);
        }
    }

    public static void perm(int cnt) {
        if (cnt == N) {
            check(nums);
            return;
        }

        for (int i = 0; i < 4; i++) {
            nums[cnt] = permColor[i];
            perm(cnt + 1);
        }
    }
    public static void check(int[] ccolor)
    {
        // 노드를 하나씩 순회후 만약 전 노드와 지금 노드의 색이 같다면 true반환함

        boolean flag= false;
        visited= new boolean[N];

        for(int i=0;i<N;i++)
        {
            if(!visited[i]) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                int color;
              
                while (!q.isEmpty()) {

                    int current = q.poll();
                    color = ccolor[current];
                    visited[current] = true;
                    for (int node : arr[current]) {
                        if (node >= 1)
                            node -= 1;
                        if (visited[node] == false) {

                            if (color == ccolor[node]) {
                                flag = true;
                            }

                            q.add(node);
                            visited[node] = true;
                        }

                    }
                }
            }
        }

        if(flag==false)
        {

            int tt=0;
            for(int i=0;i<N;i++)
            {
                tt +=Math.abs(originColor[i]-ccolor[i]);

            }

                answer=Math.min(answer,tt);


        }
    }


}
// &t4L8%hw
// [1] [0,2] [1,3] [2]
// 1  2  2  1
// 1  3  2  3


// 현재 1 1 2 2
// [1 ] [0,2 ] [1,3 ] [2 ]
// 1 2 2 2