import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] arr;
    static String answer;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(bf.readLine());

        arr = new int[N][N];
        for(int i=0;i<N;i++)
        {
            String str= bf.readLine();
            for(int j=0;j<N;j++)
            {
                arr[i][j]=str.charAt(j)-'0';
            }
        }


       answer="";

        q(0,0,N);
        System.out.println(answer);

    }
    public static void q(int x,int y,int n)
    {
        boolean flag= true;
        int check = arr[x][y];

        for(int i=x;i<x+n;i++)
        {
            for(int j=y;j<y+n;j++)
            {
                if(check!=arr[i][j])
                    flag=false;
            }
        }

        if(flag)
        {
            answer+=check;
            return;
        }

        answer+="(";
        q(x,y,n/2);
        q(x,y+n/2,n/2);
        q(x+n/2,y,n/2);
        q(x+n/2,y+n/2,n/2);
        answer+=")";


    }


}