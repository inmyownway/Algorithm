import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();


        for(int i=0;i<N*2-1;i++)
        {

            if(i<N)
            {
                for(int s=0;s<N-i-1;s++)
                {
                    System.out.print(" ");
                }for(int star=0;star<i+1;star++)
            {
                System.out.print("*");
            }
                System.out.println();
            }
            else
            {
             // i가 3부터 시작

                for(int s=0;s<i-N+1;s++)
                {
                    System.out.print(" ");
                }
                for(int star=0;star<2*N-i-1;star++)
                {
                    System.out.print("*");
                }
                System.out.println();
            }



        }


    }

}