import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,HP,H;
    static ArrayList<Milk> milks;
    static int homeX,homeY;
    static int answer=Integer.MIN_VALUE;
    static class Milk{
        int x;
        int y;

        public Milk(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Milk{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static int milkSize;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        N=Integer.parseInt(st.nextToken());
        HP=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());
        milks= new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            st= new StringTokenizer(bf.readLine());
            for(int j=0;j<N;j++)
            {
                int temp =Integer.parseInt(st.nextToken());

                if(temp==1)
                {
                    homeX=i;
                    homeY=j;
                }
                else if(temp==2)
                {

                    milks.add(new Milk(i,j));
                }
            }
        }

        milkSize=milks.size();
        num = new int[milkSize];
        for(int i=0;i<milkSize;i++)
        {
            num[i]=i;
        }
        perm(0);

        if (answer == Integer.MIN_VALUE) {
answer=0;        }
        System.out.println(answer);
    }

    public static void perm(int depth)
    {
        if(depth==milkSize)
        {
          //  System.out.println(Arrays.toString(num));
            check( num);
            return;
        }

        for(int i=depth;i<milkSize;i++)
        {
            swap(i,depth);
            perm(depth+1);
            swap(i,depth);
        }
    }
    public static void swap(int x,int y)
    {
        int temp = num[x];
        num[x]=num[y];
        num[y]=temp;
    }





    public static void check(int[] num)
    {
        int hp = HP;
        int nx= homeX;
        int ny= homeY;
        int cnt=0;
        for(int i=0;i<milkSize;i++)
        {
            Milk nowMilk = milks.get(num[i]);//
            //System.out.println(nowMilk);
            // System.out.println(cnt);
            int distance = Math.abs(nx- nowMilk.x)+Math.abs(ny- nowMilk.y);
            if(distance<=hp)
            {
                //System.out.println("@");
                cnt++;
                hp-=distance;
                hp+=H;

                if(canBack(nowMilk.x, nowMilk.y,hp))
                    answer=Math.max(answer,cnt);

                nx=nowMilk.x;
                ny= nowMilk.y;

            }
            else
            {
              return;
            }

        }
    }
    public static boolean canBack(int x,int y ,int hp)
    {            int distance = Math.abs(homeX- x)+Math.abs(homeY- y);

        if(distance<= hp)
            return true;
        return false;


    }



}