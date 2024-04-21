import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main
{
    static int N,M;
    static class Meat implements Comparable<Meat>{
    int w;
    int p;

        public Meat(int w, int p) {
            this.w = w;
            this.p = p;
        }


        @Override
        public int compareTo(Meat o) {

            int result = Integer.compare(this.p,o.p);
            if(result==0)
            {
                return o.w-this.w;
            }

                return Integer.compare(this.p,o.p);
        }

        @Override
        public String toString() {
            return "Meat{" +
                    "w=" + w +
                    ", p=" + p +
                    '}';
        }
    }
    static ArrayList<Meat> meat;
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        meat= new ArrayList<>();

        for(int i=0;i<N;i++)
        {
            st= new StringTokenizer(bf.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            meat.add(new Meat(w,p));
        }

        Collections.sort(meat);

        Meat t= meat.get(0);

        int currentW = t.w;
        int currentP = t.p;

        int all=currentP;
        boolean flag =true;
        if(currentW>= M)
        {
            System.out.println(currentP);
            flag=false;

        }

        boolean isPossbile =false;
        int answer =Integer.MAX_VALUE;
        if(flag)
        {
            for(int i=1;i<N;i++)
            {
                Meat nowMeat = meat.get(i);

               // System.out.println(nowMeat);
                if(currentP > nowMeat.p)
                {
                    Meat preMeat= meat.get(i-1);
                    if(preMeat.p!= nowMeat.p) {
                        currentP = nowMeat.p;
                        currentW += nowMeat.w;
                    }
                    else
                    {
                        currentP += nowMeat.p;

                        currentW += nowMeat.w;
                    }
                }
                else {
                   // System.out.println("@");
                    currentP += nowMeat.p;

                    currentW += nowMeat.w;
                }
             /*   System.out.println("currentW: "+currentW);
                System.out.println("currentP: "+currentP);
                System.out.println();*/
                if(currentW>= M)
                {

                    isPossbile=true;
                    answer=Math.min(answer,currentP);
                }
            }
        }
        if(isPossbile)
        {
            System.out.println(answer);
        }
        else {
            System.out.println(-1);
        }
    }
}