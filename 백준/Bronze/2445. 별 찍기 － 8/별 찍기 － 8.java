import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {

            for (int star = 0; star < i + 1; star++) {
                System.out.print("*");
            }
            // 8 6 4 2 0
            for (int star = 0; star < (N * 2) - (i + 1) * 2; star++) {
                System.out.print(" ");
            }
            for (int star = 0; star < i + 1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=N-1;i>0;i--)
        {
            for (int star = 0; star < i; star++) {
                System.out.print("*");
            }
            // 2 4 6 8
            //
            for(int s=0;s<N*2-(i*2);s++)
            {
                System.out.print(" ");
            }
            for (int star = 0; star < i; star++) {
                System.out.print("*");
            }
            System.out.println();
        }


    }

}