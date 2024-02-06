import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    static int N;
    static int[][] arr;
    static int[] team;
    static int[] startTeam;
    static int[] linkTeam;
    static int minNum= Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        N=Integer.parseInt(bf.readLine());
        arr = new int[N][N];
        for(int i=0;i<N;i++)
        {
            st=new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++)
            {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }

        }


        team= new int[N];
        for(int i=0;i<N;i++)
        {
            team[i]=i;
        }

       // System.out.println(Arrays.toString(team));
     startTeam= new int[N/2];
      //  linkTeam= new int[N/2];


         linkTeam= new int[N/2] ;
        dfs(0,0,linkTeam);
        System.out.println(minNum);
    }

    public static void dfs(int idx,int cnt,int[] linkTeam)
    {if(cnt==N/2)
    {
        int sidx=0;
        for(int i=0;i<N;i++)
        {
            int a =i;
        if(!(IntStream.of(linkTeam).anyMatch(x-> x== a)))
        {
            startTeam[sidx++]=i;
        }

        }
        getScore(startTeam,linkTeam);
        return;
    }
        if(idx==N)

        {
            return;
        }



        dfs(idx+1,cnt,linkTeam);
        linkTeam[cnt]=team[idx];
        dfs(idx+1,cnt+1,linkTeam);



    }
    public static void getScore(int[] a,int[] b)
    {

        int aScore=0;
        int bScore=0;

        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(b));
        for(int i=0;i<a.length;i++)
        {
            for(int j=i+1;j<a.length;j++)
            {
                aScore+=arr[a[i]][a[j]]+arr[a[j]][a[i]];

            }
        }

        for(int i=0;i<b.length;i++)
        {
            for(int j=i+1;j<b.length;j++)
            {
                bScore+=arr[b[i]][b[j]]+arr[b[j]][b[i]];

            }
        }

        //System.out.println("a: "+aScore);
        //System.out.println("b: "+bScore);
        minNum=Math.min(minNum,Math.abs(aScore-bScore));


        // a=[0 1 2]
        // 01 02 12 21

    }


}