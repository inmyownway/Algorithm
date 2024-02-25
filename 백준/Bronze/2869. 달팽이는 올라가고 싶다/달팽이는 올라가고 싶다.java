import java.util.Scanner;
import javax.swing.text.Style;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();


        V= V-A; // V= 전날까지 가고 남은곳
       // System.out.println(V%(A-B));

        if(V%(A-B)==0)
        {
            System.out.println(V/(A-B)+1);

        }
        else
        {
            System.out.println(V/(A-B)+2);
        }
    }

}