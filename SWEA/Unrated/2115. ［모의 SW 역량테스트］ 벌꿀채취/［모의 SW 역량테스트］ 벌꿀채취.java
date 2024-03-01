import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

    static int N,M,C;
    static int[][] board;
    static boolean[][] visited;
    static boolean[] isVisited;
    static int dMax;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc < testCase + 1; tc++) {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            board = new int[N][N];
            visited = new boolean[N][N];
            answer= Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N - M + 1; j++) {
                    //System.out.println("i j " + i + " " + j);
                    int[][] worker1 = new int[M][2];
                    visited = new boolean[N][N];

                    for (int idx = 0; idx < M; idx++) {
                        worker1[idx][0] = i;
                        worker1[idx][1] = j + idx;
                        visited[i][j + idx] = true;
                    }

                    //System.out.println("1이 선택한거");
                    //print(worker1);
                    //System.out.println("2 선택의수 ");
                    for (int a = i; a < N; a++) {
                        for (int b = 0; b < N - M + 1; b++) {
                            //System.out.println("a b " + a + " " + b);
                            int cnt=0;
                            int[][] worker2 = new int[M][2];

                            for(int idx=0 ;idx<M;idx++)
                            {
                                if(visited[a][b+idx] )
                                {
                                    break;

                                }
                                else

                                {    worker2[idx][0]=a;
                                    worker2[idx][1]=b+idx;
                                        cnt++;
                                }

                            }
                            if(cnt==M)
                            {
                                int num1 = find(worker1);
                                int num2= find(worker2);

                                if(answer<num1+num2)

                                {
                                    //System.out.println("worker1 : "+ num1);
                                   //print(worker1);
                                   // System.out.println("worker2 : "+num2);
                                    //print(worker2);
                                   // System.out.println();

                                }
                                answer=Math.max(answer,num1+num2);

                            }

                        }

                    }
                }

            }

            System.out.println("#"+tc+" "+answer);
        }
    }
                public static void print ( int[][] arr)
                {
                    for (int[] a : arr) {
                        System.out.print(Arrays.toString(a) + " ");

                    }
                    System.out.println();
                }
                public static void print ( boolean[][] arr)
                {
                    for (boolean[] a : arr) {
                        System.out.println(Arrays.toString(a));

                    }
                    System.out.println();
                }
                public static int find(int[][] worker)
                {

                    int l = worker.length;
                    Integer[] arr = new Integer[l];

                    for(int i=0;i<l;i++)
                    {
                        int x= worker[i][0];
                        int y= worker[i][1];
                        arr[i]=board[x][y];

                    }
                    Arrays.sort(arr, Collections.reverseOrder());
                    //System.out.println(Arrays.toString(arr));
                    int result=0;

                    int sum=0;

                    isVisited = new boolean[l];
                    dMax = Integer.MIN_VALUE;


                    dfs(0,l,arr);
//                    for(int i=0;i<l;i++)
//                    {
//                        if(sum+arr[i]<=C)
//                        {
//                            sum+=arr[i];
//                            result+=(arr[i]*arr[i]);
//                        }
//
//                    }
                    return dMax;

                }
                public static void dfs(int depth,int R,Integer[] a)
                {
                    if(depth==R)
                    {
                        int s=0;
                        int t=0;
                        for(int i=0;i<depth;i++)
                        {
                            if (isVisited[i])
                            {
                                s+=a[i];
                                t+= a[i]*a[i];
                            }
                        }

                        if(s<=C)
                            dMax=Math.max(dMax,t);
                        return;
                    }

                    isVisited[depth]=true;
                    dfs(depth+1,R,a);
                    isVisited[depth]=false;
                    dfs(depth+1,R,a);

                }
            }