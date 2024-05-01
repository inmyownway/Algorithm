import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    static int N,M,C;
    static int[][] board;
    static boolean[][] visited;
    static ArrayList<Integer> first,second;
    static int answer;
    static int f,s;
    static boolean[] tempV;




    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase= Integer.parseInt(bf.readLine());

        for(int test=1;test<testCase+1;test++)
        {
            st= new StringTokenizer(bf.readLine());
            N= Integer.parseInt(st.nextToken());
            M= Integer.parseInt(st.nextToken());
            C= Integer.parseInt(st.nextToken());

            board= new int[N][N];
            answer= Integer.MIN_VALUE;

            for(int i=0;i<N;i++)
            {
                st= new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++)
                {
                    board[i][j]=Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0;i<N;i++)
            {
                for(int j=0;j<=N-M;j++)
                {
                    visited = new boolean[N][N];

                    first= new ArrayList<>();
                    //second= new ArrayList<>();

                    f=0;
                    //System.out.println("first start = i,j "+ i+" "+j);
                    fisrtGetHoney(i,j);
                    //System.out.println(f);
                    secondGetHoney();


                }
            }
            System.out.println("#"+test+" "+answer);
        }

    }
    private static void fisrtGetHoney(int x,int y)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        for(int idx=y;idx<y+M;idx++)
        {
            temp.add(board[x][idx]);
            visited[x][idx]=true;
        }

        tempV= new boolean[temp.size()];
        f=0;

        //System.out.println("first " +f);
        makeSubset(temp,0);

    }
    private static void secondGetHoney() {

        s=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<=N-M;j++)
            {
                second= new ArrayList<>();

                boolean flag= false;
                ArrayList<Integer> temp = new ArrayList<>();
                for(int idx=j;idx<j+M;idx++)
                {
                    if(visited[i][idx])
                    {
                        flag=true;
                        break;
                    }
                    temp.add(board[i][idx]);
                }
                if(!flag)
                {

                    s=0;
                    tempV= new boolean[temp.size()];
                    makeSubset1(temp,0);
                }

                check();

            }
        }

    }
    public static void makeSubset(ArrayList<Integer> temp,int cnt)
    {


        if(cnt==temp.size())
        {
            int sum=0;

            for(int i=0;i<tempV.length;i++)
            {
                if(tempV[i])
                {
                    //System.out.print(temp.get(i)+" ");
                    sum+=temp.get(i);
                }

            }
            //System.out.println();
            int sumTemp=0;
            if(sum<=C)
            {
                for(int i=0;i<tempV.length;i++)
                {
                    if(tempV[i])
                    {
                        sumTemp+=temp.get(i)*temp.get(i);
                    }

                }
            }
       //     System.out.println(f);
            f= Integer.max(f,sumTemp);
         //   System.out.println(f);

            return;
        }


        tempV[cnt]=true;
        makeSubset(temp,cnt+1);
        tempV[cnt]=false;
        makeSubset(temp,cnt+1);




    }

    public static void makeSubset1(ArrayList<Integer> temp,int cnt)
    {

        if(cnt==temp.size())
        {
            int sum=0;

            for(int i=0;i<tempV.length;i++)
            {
                if(tempV[i])
                {
                    sum+=temp.get(i);
                }

            }
            int sumTemp=0;
            if(sum<=C)
            {
                for(int i=0;i<tempV.length;i++)
                {
                    if(tempV[i])
                    {
                        sumTemp+=temp.get(i)*temp.get(i);
                    }

                }
            }
          //  System.out.println(s);
            s= Integer.max(s,sumTemp);

            return;
        }


        tempV[cnt]=true;
        makeSubset1(temp,cnt+1);
        tempV[cnt]=false;
        makeSubset1(temp,cnt+1);




    }




    public static void check()
    {


        answer= Integer.max(answer,f+s);
    }
}