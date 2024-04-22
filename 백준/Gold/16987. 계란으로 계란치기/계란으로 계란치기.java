import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    static int N;
    static int answer=Integer.MIN_VALUE;
    static class Egg
    {
        int h;
        int w;
        public Egg(int h, int w) {
            super();
            this.h = h;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Egg [x=" + h + ", y=" + w + "]";
        }


    }
    static ArrayList<Egg> eggs;
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N= Integer.parseInt(bf.readLine());
        eggs= new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            st= new StringTokenizer(bf.readLine());
            int h= Integer.parseInt(st.nextToken());
            int w= Integer.parseInt(st.nextToken());

            eggs.add(new Egg(h,w));
        }

        dfs(0,0);
        System.out.println(answer);
    }
    public static void dfs(int idx,int cnt)
    {

        if(idx==N)
        {

            answer=Math.max(answer, cnt);
            return;
        }

        Egg left= eggs.get(idx);

        if(left.h <=0  || cnt == N-1)
        {
            dfs(idx+1,cnt);
            return;
        }

        // 다른 계란들과 모두 부딪히기

        int nCnt= cnt;


        for(int i=0;i<N;i++)
        {
            if(i!=idx && eggs.get(i).h>0)
            {
                // 깬다

                    eggs.get(i).h -= left.w;
                    left.h -= eggs.get(i).w;

                    if(eggs.get(i).h <=0)
                        cnt++;

                    if(left.h <=0)
                        cnt++;


                dfs(idx+1,cnt);
                eggs.get(i).h+= left.w;
                left.h += eggs.get(i).w;
                cnt=nCnt;

            }

        }



    }

}