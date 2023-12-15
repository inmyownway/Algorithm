import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        StringBuilder sb = new StringBuilder();
        int[] arr =new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=in.nextInt();
        }
        Arrays.sort(arr);

        int m = in.nextInt();

        for(int i=0;i<m;i++)
        {
            if(binarySerach(arr,in.nextInt())>=0)
            {
                sb.append(1+"\n");

            }
            else
            {
                sb.append(0+"\n");
            }
        }
        System.out.println(sb);

    }
    public static int binarySerach(int[] arr,int target)
    {
        int low = 0;
        int high= arr.length-1;

        while(low<=high)
        {
            int mid=(low+high)/2;

            if (target<arr[mid])
            {
                high=mid-1;
            }
            else if (target>arr[mid])
            {
                low=mid+1;

            }
            else{
                return mid;
            }
        }
        return -1;


    }




}
