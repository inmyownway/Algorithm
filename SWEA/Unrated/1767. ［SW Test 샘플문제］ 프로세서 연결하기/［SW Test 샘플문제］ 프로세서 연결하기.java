import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[][] board;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx={0,0,-1,1,0};
    static int[] dy={1,-1,0,0,0};
    static int numIdx;
    static int allNum;
    static int minNum=Integer.MAX_VALUE;
    static boolean[] isVisited;
    static int maxNode=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(bf.readLine());

        int testCase= Integer.parseInt(st.nextToken());

        for(int tc=1;tc<testCase+1;tc++)
        {
            N= Integer.parseInt(bf.readLine());

            visited= new boolean[N][N];
            board= new int[N][N];

            numIdx=0;
            allNum=0;
            minNum=Integer.MAX_VALUE;
            maxNode=Integer.MIN_VALUE;
            for(int i=0;i<N;i++)
            { st= new StringTokenizer(bf.readLine());
                for(int j=0;j<N;j++)
                {
                    board[i][j]=Integer.parseInt(st.nextToken());
                    if(board[i][j]==1)
                    {
                        allNum++;
                        numIdx++;
                        visited[i][j]=true;
                    }
                }
            }

            int num=0;
            for(int i=0;i<N;i++)
            {
                if(board[0][i]==1)
                {
                    board[0][i]=0;
                    visited[0][i]=true;
                    num++;
                }
                if(board[N-1][i]==1)
                {
                    board[N-1][i]=0;
                    visited[N-1][i]=true;
                    num++;
                }

            }
            for(int i=1;i<N-1;i++)
            {
                if(board[i][0]==1){
                    board[i][0]=0;
                    visited[i][0]=true;
                    num++;
                }
                if(board[i][N-1]==1)
                {
                    board[i][N-1]=0;
                    visited[i][N-1]=true;
                    num++;
                }
            }

            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    if(board[i][j]==1)
                    {
                        int t=0;
                        for(int s=0;s<4;s++)
                        {
                            if(visited[i+dx[s]][j+dy[s]]==true)
                            {
                                t++;
                            }
                        }
                        if(t==4)
                        {
                            board[i][j]=0;
                            numIdx--;

                        }
                    }
                }
            }
            int ia=0;

            numIdx-=num;
            arr = new int[numIdx][2];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    if(board[i][j]==1)
                    {
                        arr[ia][0]=i;
                        arr[ia][1]=j;
                        ia++;
                    }
                }
            }
            //print(arr);
            isVisited = new boolean[arr.length];
            combi(0);
            
            
            int a= minNum;
            if(minNum==Integer.MAX_VALUE)
            {
                a=0;
            }

            System.out.println("#"+tc+" "+a);
        }
    }
    public static void combi(int depth) {

		if (depth == arr.length) {

			
					
				int tCount=0;
				for(int j=0;j<isVisited.length;j++)
				{
					if(isVisited[j])
						tCount++;
				}
				
				ArrayList<int []> comArr = new ArrayList<>();
				//System.out.println(tCount);
				for(int j=0;j<isVisited.length;j++)
				{
					if(isVisited[j])
						comArr.add(arr[j]);
				}
				
//				for(int[] a: comArr)
//				{
//					System.out.print(Arrays.toString(a));
//				}
				//System.out.println();
				int tempnumIdx=comArr.size();
				dfs(0,visited,comArr,tempnumIdx);
		//	System.out.println();
			return;

		}

		isVisited[depth] = true;
		combi(depth + 1);
		isVisited[depth] = false;
		combi(depth + 1);
	}
    public static void dfs(int idx,boolean[][] visit,ArrayList<int[]> com,int numIdxx)
    {

        int answerNum=0;
        if(idx==numIdxx)
        {
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    if(visit[i][j])
                    {
                        answerNum++;
                    }
                    else
                    {
                    }
                }
            }
            //System.out.println();
            //System.out.println(numIdxx);
            /*
             *         if (count > maxCount) {
            maxCount = count;
            minSum = sum;
        }

        if (count == maxCount) {
            minSum = Math.min(minSum, sum);
        }


             * */

            if(maxNode < numIdxx)
            {
            	maxNode=numIdxx;
            	minNum=answerNum-allNum;

           
            }
            else if(maxNode == numIdxx)
            {          
            	//System.out.println("@"+ numIdxx);
           // System.out.println(answerNum-allNum);
            	maxNode=numIdxx;
            	 minNum=Math.min(minNum,answerNum-allNum);
            }  
            
           
            return;
        }
        int[] current= com.get(idx);
       // System.out.println(idx);
      //  System.out.println(com);
      //  System.out.println("!!");
        int x= current[0];
        int y= current[1];


        for(int d=0;d<5;d++){

            int nx=0;
            int ny=0;

            boolean flag= true;
            for(int i=1;i<N+1;i++)
            {


                nx = x+ dx[d]*i;
                ny = y+ dy[d]*i;

                if(isBoundary(nx,ny))
                {
                    if(visit[nx][ny])
                    {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag)
            {
                nx=0; ny=0;
                for(int ci=1;ci<N+1;ci++)
                {
                    nx=x+dx[d]*ci;
                    ny=y+dy[d]*ci;
                    if(isBoundary(nx,ny))
                    {
                        visit[nx][ny]=true;
                    }
                }
                dfs(idx+1,visit,com,numIdxx);
                nx=0; ny=0;
                for(int ci=1;ci<N+1;ci++)
                {
                    nx=x+dx[d]*ci;
                    ny=y+dy[d]*ci;

                    if(isBoundary(nx,ny))
                    {
                        visit[nx][ny]=false;
                    }
                }



            }
        }



    }

    public static void print(int[][] ar)
    {
        for(int i=0;i<ar.length;i++)
        {
            for(int j=0;j<ar[i].length;j++)
            {
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
    }
    public static void printv(boolean[][] ar)
    {
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
    }
    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<N;
    }


}