import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();


        for(int i=0;i<N*2-1;i++)
        {

           if(i<N)
           {
               for(int star=0;star<i+1;star++)
               {
                   System.out.print("*");
               }

           }
           else
           {
               for(int star=0;star<2*N-i-1;star++)
               {
                   System.out.print("*");
               }

           }
            System.out.println();


        }


    }

}