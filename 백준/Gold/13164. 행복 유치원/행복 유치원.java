import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static int div;
    static int[] arr,gap;
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N= Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr= new int[N];

        st= new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++)
        {

            arr[i] = Integer.parseInt(st.nextToken());
        }

        gap= new int[N-1];
        for(int i=0;i<N-1;i++)
        {
            gap[i]=arr[i+1]-arr[i];
        }

        Arrays.sort(gap);
        int answer=0;
        for(int i=0;i<N-K;i++)
        {
            answer+=gap[i];
        }
        System.out.println(answer);

    }
}