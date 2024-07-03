import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,P;
    static boolean[] v;
    static int[] arr;
    public static void make()

    {
        arr= new int[N+1];
        for(int i=1;i<=N;i++)
        {
            arr[i]=i;

        }
    }

    public static int find(int x){

        if(x==arr[x])
        {
            return x;

        }
        return arr[x]=find(arr[x]);
    }
    public static void union(int x,int y)
    {
        int aRoot= find(x);

        int bRoot =find(y);

        if(aRoot>bRoot)
        {
            arr[aRoot]=bRoot;


        }
        else{
            arr[bRoot]=aRoot;
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());


        N= Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        P = Integer.parseInt(st.nextToken());
        v= new boolean[N+1];

        make();
    //    System.out.println(Arrays.toString(arr));
        int answer=0;
        for(int i=0;i<P;i++)
        {
            st= new StringTokenizer(bf.readLine());
            int n= Integer.parseInt(st.nextToken());

            int p = find(n);



            if(p==0){
                break;
            }
            answer++;

            union(p,p-1);


        }
      //  System.out.println(Arrays.toString(arr));
        System.out.println(answer);


    }
}