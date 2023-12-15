import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int num=666;
        int count=1;

        while(count!=n)
        {
            num++;

            if(String.valueOf(num).contains("666")){
                count++;
            }
        }
        System.out.println(num);
    }
}
