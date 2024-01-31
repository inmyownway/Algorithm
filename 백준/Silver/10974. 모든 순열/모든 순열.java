import java.util.Scanner;

public class Main {

    static int[] data;
    static int N;
    static int R;
    static int[] numbers;
    static boolean[] isSelected;
    public static void main(String[] args) {


        // flag 사용해서 해보기
        Scanner sc = new Scanner(System.in);

        N=sc.nextInt();
        data= new int[N];

        isSelected =new boolean[N];
        for(int i=1;i<=N;i++)
        {
            data[i-1]=i;
        }
        N=data.length;
        R=data.length;

    numbers=new int[R];

        permutation_flag(0);

    }
    public static void print()
    {
        for(int p : numbers)
        {
            System.out.print(p+" ");
        }
        System.out.println();
    }

    public static void permutation_flag(int idx)
    {
        if(idx==R)
        {
            print();
            return;
        }

        for(int i=0;i<N;i++)
        {
            if(isSelected[i]) continue;

            isSelected[i]=true;
            numbers[idx]=data[i];
            permutation_flag(idx+1);
            isSelected[i]=false;
        }


    }

}