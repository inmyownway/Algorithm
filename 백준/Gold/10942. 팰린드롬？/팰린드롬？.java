import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        N= Integer.parseInt(st.nextToken());

        arr= new int[N];
        st= new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++)
        {
            arr[i]= Integer.parseInt(st.nextToken());

        }

        st= new StringTokenizer(bf.readLine());
        int t= Integer.parseInt(st.nextToken());

        StringBuilder sb= new StringBuilder();
        for(int test=0;test<t;test++ )
        {
            st= new StringTokenizer(bf.readLine());
            int start= Integer.parseInt(st.nextToken())-1;
            int end= Integer.parseInt(st.nextToken())-1;

            boolean flag= true;
            while(true)
            {
                if(start==end || start > end) {

                    flag=false;
                    break;
                }
                if(arr[start]!=arr[end])
                {
                    flag=true;
                    break;

                }
                //System.out.println(arr[start]+" "+arr[end]);
                start++;
                end--;
            }
            if(flag)
               sb.append(0+"\n");
            else
                sb.append(1+"\n");


        }
        System.out.println(sb);
    }
}