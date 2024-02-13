import java.util.Scanner;

public class Main {
    static int N;
    static int minNum=Integer.MAX_VALUE;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N=sc.nextInt();

        int answer= 0;

        boolean flag= false;
        while(true)
        {
            if(N%5==0)
            {
                answer+=N/5;

              System.out.println(answer);
              flag=true;
            break;
            }
            if(N<3)
            {
                System.out.println(-1);
                flag=true;
                break;
            }

            N-=3;
            answer++;
        }
        if(!flag)
            System.out.println(answer);
    }


}