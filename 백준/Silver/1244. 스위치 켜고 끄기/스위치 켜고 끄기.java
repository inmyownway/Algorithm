import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] arr;
    static int studentNum;

    public static void main(String[] args) {


        // 남학생은 스위치 번호가 자기가 받은수
        Scanner sc = new Scanner(System.in);

        N=sc.nextInt();

        arr=new int[N+1];

        for(int i=1;i<=N;i++)
        {
            arr[i]=sc.nextInt();
        }

        studentNum=sc.nextInt();

        for(int i=0;i<studentNum;i++)
        {

            int gender=sc.nextInt();
            int num= sc.nextInt();

            if(gender==1)
            {
                for(int j=num;j<=N;j+=num)
                {
                    if(arr[j]==1)
                        arr[j]=0;
                    else
                        arr[j]=1;
                }
            }
            if(gender==2)
            {
                if(arr[num]==1)
                    arr[num]=0;
                else
                    arr[num]=1;

                for(int j=1;j<=N ;j++)
                {
                    int left=num-j;
                    int right=num+j;

                    if(left >=1 && right<=N && arr[left]==arr[right])
                    {
                        //System.out.println(left+" "+right);
                        change(left);
                        change(right);
                    }
                    else
                        break;
                }
            }

//            for(int a=1;a<=N;a++)
//            {
//                System.out.print(arr[a]+" ");
//            }
//            System.out.println();
        }
       // System.out.println();
        for(int a=1;a<=N;a++)
        {
            System.out.print(arr[a]+" ");
            if(a%20==0)
            {
                System.out.println();
            }
        }
        //System.out.println(Arrays.toString(arr));
    }
    public static void change(int x)
    {
        if(arr[x]==1)
            arr[x]=0;
        else
            arr[x]=1;
    }

}