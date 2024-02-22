import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Solution {


    static int[][] board;
    static boolean[] visited;
    static int start;
    static int dataLength;
    static int answer=0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=1;tc<=10;tc++)
        {
            StringTokenizer st= new StringTokenizer(bf.readLine());

            board= new int[101][101];
            visited= new boolean[101];

            dataLength=Integer.parseInt(st.nextToken());
            start= Integer.parseInt(st.nextToken());

            st= new StringTokenizer(bf.readLine());

            for(int i=0;i<dataLength/2;i++)
            {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                board[from][to]=1;
            }
            bfs();
            System.out.println("#"+tc+" "+answer);
        }

    }

    public static void bfs()
    {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start]=true;
        int max=0;

        ArrayList<Integer> list = new ArrayList<>();

        while(!q.isEmpty())
        {
            int qSize= q.size();
            max=0;

            for(int i=0;i<qSize;i++)
            {
                int now= q.poll();

                for(int j=1;j<101;j++)
                {
                    if(board[now][j]== 1 && visited[j]==false)
                    {
                        q.offer(j);
                        visited[j]=true;
                        max=Math.max(max,j);
                    }
                }

            }
            //24 2
            //100 17 39 22 100 8 100 7 7 100 2 7 2 15 15 4 6 2 11 6 4 10 4 2System.out.println(list);
            list.add(max);
        }

        answer=list.get(list.size()-2);
    }


}