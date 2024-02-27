import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R=0;
    static int G=1;
    static int B=2;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N= Integer.parseInt(bf.readLine());

        int[][] cost = new int[N][3];

        for(int i=0;i<N;i++)
        {
            st= new StringTokenizer(bf.readLine());

            cost[i][R]=Integer.parseInt(st.nextToken());
            cost[i][G]=Integer.parseInt(st.nextToken());
            cost[i][B]=Integer.parseInt(st.nextToken());

        }

        for(int i=1;i<N;i++)
        {
            cost[i][R] += Math.min(cost[i - 1][G], cost[i - 1][B]);
            cost[i][G] += Math.min(cost[i - 1][R], cost[i - 1][B]);
            cost[i][B] += Math.min(cost[i - 1][R], cost[i - 1][G]);
        }
        System.out.println(Math.min(Math.min(cost[N - 1][R], cost[N - 1][G]), cost[N - 1][B]));

    }
}