import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();


        for(int i=0;i<=N-1;i++)
        {


            for(int j=0;j<N-i-1;j++)
            {
                System.out.print(" ");
            }

            System.out.print("*");

            for(int s=0;s<((i-1)*2)+1;s++)
            {
                System.out.print(" ");
            }
            if(i>=1)
            {
                System.out.print("*");
            }

            System.out.println();





        }

    }

}