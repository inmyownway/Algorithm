import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {


        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str= bf.readLine();


        Queue<Integer> a = new LinkedList<>();
        Queue<Integer> b= new LinkedList<>();

        int aIdx=0;
        int bIdx=0;
        int answer=0;
        for(int i=0;i<str.length();i++)
        {
            char now = str.charAt(i);

            if(now=='C')
            {
                if(b.size()>=1)
                {
                    answer++;
                    b.poll();
                }
            }
            else if(now=='A')
            {
                a.add(i);
            }
            else {
                b.add(i);
            }

        }

        //System.out.println(a);
       // System.out.println(b);
        while(true)
        {
            if(  a.isEmpty() || b.isEmpty() )
            {
                break;
            }

            if(a.peek() > b.peek())
            {
                b.poll();
                //answer++;
            }
            else if(a.peek() < b.poll())
            {
                a.poll(); answer++;
            }
           // System.out.println();
          //  System.out.println(a);
          //  System.out.println(b);

        }
        System.out.println(answer);



    }

}