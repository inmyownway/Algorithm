import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.security.CodeSource;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static Pos start;
    static Pos end;
    static Pos[] home;
    static int N;
    static int[] homeIdx;
    static int answer;//=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int testCase=Integer.parseInt(bf.readLine());

        for(int tc=1;tc<=testCase;tc++) {

            N = Integer.parseInt(bf.readLine());

            String[] str = bf.readLine().split(" ");

            start = new Pos(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
            end = new Pos(Integer.parseInt(str[2]),Integer.parseInt(str[3]));

            home =new Pos[N];
            homeIdx = new int[N];
            for(int i=0;i<N;i++)
            {
                homeIdx[i]=i;
            }
            int h=0;
            for(int i=4;i<4+2*N;i+=2)
            {
                home[h]= new Pos(Integer.parseInt(str[i]),Integer.parseInt(str[i+1]));

                h++;
            }


            answer=Integer.MAX_VALUE;
            permu(0);

            System.out.println("#"+tc+" "+answer);
        }

    }
    public static void permu(int depth)
    {
        if(depth==N)
        {

            calDistance();
            return;
        }

        for(int i=depth;i<N;i++)
        {
            swap(i,depth);
            permu(depth+1);
            swap(i,depth);
        }

    }
    public static void calDistance()
    {


        int distance=0;

        int nx=start.x;
        int ny=start.y;

        for(int ai : homeIdx)
        {
        distance+=Math.abs(home[ai].x - nx )+ Math.abs(home[ai].y-ny);
        nx=home[ai].x;
        ny=home[ai].y;
        }
        distance+=Math.abs(nx-end.x )+ Math.abs(ny-end.y);

        answer=Math.min(answer,distance);

    }

    public static void swap(int x,int y)
    {
        int temp = homeIdx[x];
        homeIdx[x]=homeIdx[y];
        homeIdx[y]=temp;
    }
    public static class Pos{
        int x;
        int y;
        Pos(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}