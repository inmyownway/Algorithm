import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedMap;
class Solution {
    static int[][] board;
    static int answer=Integer.MAX_VALUE;
    static int N;
    public static int solution(int n, int[][] wires) {

        N=wires.length;
        System.out.println(N);

        for(int i=0;i<N;i++)
        {
            board= new int[n][n];
           // System.out.println(i+" 빼고 연결하기");
            for(int idx=0;idx<N;idx++)
            {
                if(i!=idx)
                {

                    //      System.out.println(idx);
                    int[] t= wires[idx];
                  //  System.out.println(Arrays.toString(t));
                    board[t[0]-1][t[1]-1]=1;
                    board[t[1]-1][t[0]-1]=1;

                }


            }
//            for(int[] b:board)
//            {
//                System.out.println(Arrays.toString(b));
//
//            }
//
//            System.out.println();


            graph(i);

        }
       // System.out.println(answer);
return answer;

    }
    public static void graph(int d)
    {

        int n = board.length;
        boolean[] v= new boolean[n];

        ArrayList<Integer> arr =new ArrayList<>();


        for(int i=0;i<n;i++)
        {

            if(!v[i])
            { //System.out.println("i "+i);
                int cnt=1;

                Queue<Integer> q= new LinkedList<>();
                q.add(i);
                v[i]=true;


                while(!q.isEmpty())
                {
                    int current= q.poll();
                    for(int idx=0;idx<n;idx++)
                    {
                        int num = board[current][idx];
                 //       System.out.println(num);
                        if(num==1 && !v[idx] )
                        {
                            q.add(idx);
                            v[idx]=true;
                            cnt++;
                        }
                    }
                }
arr.add(cnt);
            }
        }
      //  System.out.println(arr);
        answer=Integer.min(answer,Math.abs(arr.get(0)-arr.get(1)));// - Math.abs(arr.get(1)));

    }

}