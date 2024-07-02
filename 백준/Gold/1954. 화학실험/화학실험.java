import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int answer;
    static int N,M;
    static ArrayList<Point> point;
    static class Point{
        int a;
        int b;

        Point(int a,int b)
        {
            this.a=a;
            this.b=b;
        }

    }
    public static void main(String[] args) throws IOException {


        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        N= Integer.parseInt(st.nextToken());

        point= new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            st= new StringTokenizer(bf.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());

            point.add(new Point(a,b));
        }
        st= new StringTokenizer(bf.readLine());
        M= Integer.parseInt(st.nextToken());


        int[] arr= new int[N];
        check(0,0,M,arr);
        if(answer!=0)
        {
            System.out.println(answer);
        }
        else{
            System.out.println(0);
        }


    }
    public static void check(int idx,int pre,int use,int[] arr)
    {
        if(idx>=N)
        {     //   System.out.println(Arrays.toString(arr));
            //System.out.println(use);
            if(use==0)
            {
                boolean flag= false;
                for(int i=0;i<N-1;i++)
                {
                    if(arr[i]!=arr[i+1])
                    {
                        flag=true;
                    }
                }
                if(!flag)
                {
                   answer=arr[0];

                }
            }

            return;
        }

        Point p = point.get(idx);
        if(use<0)
            return;
        for(int i=1;i<=M;i++)
        {

            if(idx!=0)
            {
                if(pre==p.a*i+p.b)
                {
                    arr[idx]=p.a*i+p.b;
                    check(idx+1,p.a*i+p.b,use-i,arr);
                    arr[idx]=0;

                }

            }
            else{
                arr[idx]=p.a*i+p.b;

                check(idx+1,p.a*i+p.b,use-i,arr);
                arr[idx]=0;

            }
        }

    }


}