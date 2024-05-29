import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] board;
    static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());


        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());


        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        st= new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++)
        {
            int number= Integer.parseInt(st.nextToken());
            if( number<0)
                negative.add(number);
            else
                positive.add(number);
        }

        Collections.sort(negative);
        Collections.sort(positive,Collections.reverseOrder());

        ArrayList<Integer> answer= new ArrayList<>();

       while(!negative.isEmpty())
        {
            int firstOne= negative.remove(0);

            for(int j=1;j<M;j++)
            {
                if(!negative.isEmpty())
                {
                    negative.remove(0);
                }
            }
            answer.add(Math.abs(firstOne));
        }



        while(!positive.isEmpty())
        {
            int firstOne= positive.remove(0);

            for(int j=1;j<M;j++)
            {
                if(!positive.isEmpty())
                {
                    positive.remove(0);
                }
            }
            answer.add(Math.abs(firstOne));
        }
        int result=0;

        Collections.sort(answer);
        result+=answer.get(answer.size()-1);


        for(int i=0;i<answer.size()-1;i++)
        {
            result+=answer.get(i)*2;
        }
        System.out.println(result);

    }
}