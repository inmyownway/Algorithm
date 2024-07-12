import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static ArrayList<Node> arr;
    static class Node implements Comparable<Node>{
        int start;
        int end;


        public Node(int start,int end)
        {
            this.start=start;
            this.end=end;
        }

        @Override
        public int compareTo(Node o)
        {
            if(this.end==o.end)
                return this.start-o.start;
            return this.end-o.end;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
    static long answer;
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        arr= new ArrayList<>();
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++)
        {
            st= new StringTokenizer(bf.readLine());
            int s= Integer.parseInt(st.nextToken());
            int e= Integer.parseInt(st.nextToken());

            if(s > e)
                arr.add(new Node(s,e));
        }

        Collections.sort(arr);


        long startPoint= arr.get(0).start;
        long endPoint = arr.get(0).end;

        long result=0;

        // 5 3
        // 7 4
        for(int i=1;i<arr.size();i++)
        {
            long start= arr.get(i).start;
            long end= arr.get(i).end;


            if(end <= startPoint)
            {
                startPoint=Math.max(startPoint,start);
            }
            else{
                result+= 2 * (startPoint-endPoint);
                endPoint=end;
                startPoint=start;
            }




        }
        result+= 2 * (startPoint-endPoint);

        System.out.println((result+M));
    }
}