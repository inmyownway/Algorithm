import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,C,R;
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N= Integer.parseInt(st.nextToken());

        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2,N);


        check(R,C,size);
        System.out.println(cnt);
    }

    // r = 4
    // c = 5
    // n= 3 , size= 8
    public static void check(int r,int c,int size)
    {

        if(size==1){
            return;
        }
        // 1사분면
        if(r < size/2 && c<size/2)
        {
            check(r,c,size/2);
        }
        else if(r<size/2 && c>= size/2)
        {
            // 2사분면
            cnt+= size*size/4;
            check(r,c-size/2,size/2);

        }
        else if(r>=size/2 && c< size/2)
        {
            // 3사분면
            cnt+= (size*size/4)*2;
            check(r-size/2,c,size/2);
        }
        else
        {
            cnt+= (size*size/4)*3;
            check(r - size/2, c - size/2, size/2);
        }
    }

}