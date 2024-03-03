import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static double[][] arr;
    static int[] workers;
    static double answer;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase= Integer.parseInt(bf.readLine());
        for(int tc=1;tc<testCase+1;tc++)
        {
            N=Integer.parseInt(bf.readLine());


            arr= new double[N][N];
            workers= new int[N];
            isVisited= new boolean[N];
            for(int i=0;i<N;i++)
            {
                st=new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++)
                {
                    arr[i][j]=Double.parseDouble(st.nextToken())/100.0;
                }
            }
            for(int i=0;i<N;i++)
            {
                workers[i]=i;
            }
            answer=0;
            comb(0,1);
            System.out.printf("#%d %.6f",tc,answer);
            System.out.println();
        }

    }
    public static void comb(int cnt,double sum)
    {
        if(answer>=sum*100)
            return;
        if(cnt==N)
        {
            answer=Math.max(answer,sum*100);
            return;

        }
        for(int i=0;i<N;i++)
        {

            if(!isVisited[i])
            {
                isVisited[i]=true;
                comb(cnt+1,sum*arr[cnt][i]);
                isVisited[i]=false;

            }
        }
    }


}