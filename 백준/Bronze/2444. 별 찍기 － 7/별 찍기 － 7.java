import java.util.Scanner;

public class Main {
    public static void main(String[] args )
    {

        Scanner sc = new Scanner(System.in);

        int N= sc.nextInt();

        for(int i=0;i<N;i++)
        {
            for(int s=0;s<N-i-1;s++)
            {
                System.out.print(" ");
            }
            for(int star=0;star<i*2+1;star++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0;i<N-1;i++)
        {
            for(int s=0;s<i+1;s++)
            {
                System.out.print(" ");
            }
            // 7 5 3 1
            // 0 1 2 3
            for(int star=0;star<N*2-((i+1)*2)-1;star++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}