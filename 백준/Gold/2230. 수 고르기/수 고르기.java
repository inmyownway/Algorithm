import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static ArrayList<Integer> arr;
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {


        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        // N= 10 만


        arr =new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            arr.add(Integer.parseInt(bf.readLine()));
        }


        Collections.sort(arr);

        int s=0;
        int e=0;

        // 1 2 3 4 5
        //
        while(e<N)
        {
            int r= arr.get(e)-arr.get(s);

            if(r<M)
            {
                e++;
            }
            else if(r>M)
            {
                answer= Math.min(r,answer);
                s++;
            }else{
                answer=r;
                break;
            }

        }
        System.out.println(answer);

    }

}