import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int answer=Integer.MAX_VALUE;
    static int K,N;
    static int[] timeArr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

         N= Integer.parseInt(st.nextToken());
         K= Integer.parseInt(st.nextToken());
        timeArr= new int[1000001];
        Arrays.fill(timeArr,Integer.MAX_VALUE);
        move(N,0);
        System.out.println(answer);
    }
    public static void move(int pos,int time)
    {

        Queue<int[]> q = new LinkedList<>();



        q.add(new int[]{pos,0});

        while(!q.isEmpty())
        {
            int[] now= q.poll();

            int nowPos= now[0];
            int t= now[1];


            if(nowPos==K)
            {
                answer=Math.min(answer,t);
            }

            if(nowPos <0 || nowPos>100000)
                continue;

            if( nowPos!= 100000 && timeArr[nowPos+1]> t+1){
                timeArr[nowPos+1]=t+1;
                q.add(new int[]{nowPos+1,t+1});
            }
            if(nowPos!=0 && timeArr[nowPos-1] > t+1) {
                timeArr[nowPos - 1] = t + 1;
                q.add(new int[]{nowPos - 1, t + 1});
            }

            if(nowPos*2<=100000 && timeArr[nowPos*2] > t) {
                timeArr[nowPos * 2] = t ;
                q.add(new int[]{nowPos *2, t });
            }



        }


    }

}