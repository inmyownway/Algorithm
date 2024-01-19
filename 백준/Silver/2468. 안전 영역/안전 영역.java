import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int maxNum=Integer.MIN_VALUE;
    static int[] dx ={0,0,-1,1};
    static int[] dy ={1,-1,0,0};
    public static void main(String[] args)
    {


        Scanner sc= new Scanner(System.in);

        N=sc.nextInt();
        arr=new int[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                arr[i][j]=sc.nextInt();

            }
        }
      int roop=0;
        while(true)
        {
            find();
            rain();
           // System.out.println(Arrays.deepToString(arr));

            boolean flag=false;

            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {

                    if(arr[i][j]!=0)
                    {
                        flag=true;
                    }
                }
            }
            //System.out.println(1);
            if(flag==false)
            {
                System.out.println(maxNum);
                break;
            }
           // if(roop==5) break;
        }
    }
    public static void rain()
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                arr[i][j]-=1;
                if(arr[i][j]<=0)
                {
                    arr[i][j]=0;
                }
            }
        }
    }
    public static void find()
    {
        int cnt=0;
        visited= new boolean[N][N];

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(arr[i][j]>0 && visited[i][j]==false)

                {
                    //System.out.println(i+" "+j+" "+arr[i][j]);
                    cnt+=1;
                    Queue<int[]> q= new LinkedList<int[]>();
                    q.add(new int[]{i,j});

                    visited[i][j]=true;

                    while(!q.isEmpty())
                    {
                        //System.out.println(1);
                        int[] now=q.poll();
                        int x=now[0];
                        int y=now[1];

                        for(int idx=0;idx<4;idx++)
                        {
                            int nx=x+dx[idx];
                            int ny=y+dy[idx];

                            if(nx>=0 && nx<N && ny>=0 && ny<N)
                            {
                                if(visited[nx][ny]==false && arr[nx][ny]>0)
                                {
                                    q.add(new int[]{nx,ny});

                                    visited[nx][ny]=true;
                                }
                            }
                        }

                    }

                }
            }
        }
        //System.out.println(cnt);
        maxNum=Math.max(cnt,maxNum);

    }

}