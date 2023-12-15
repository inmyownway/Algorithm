import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int N= sc.nextInt();

        int[] nums = new int[N];

        for(int i=0;i<N;i++)
        {
            nums[i]=sc.nextInt();

        }

        int cnt=0;

        for(int i=0;i<N;i++)
        {
            cnt+=isPrime(nums[i]);
        }
        System.out.println(cnt);

    }

    public static int isPrime(int num) {


        if (num==1)
        {
            return 0;
        }
        for(int i=2;i<num;i++)
        {
            if(num%i==0)
            {
                return 0;
            }

        }
        return 1;

    }
}
