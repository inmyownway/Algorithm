import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static ArrayList<Integer> arr;
    static int[] alpha;

    public static void main(String[] args) throws IOException


    {


        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        N= Integer.parseInt(st.nextToken());
        arr= new ArrayList<>();
        alpha = new int[26];

        for(int i=0;i<N;i++)
        {
            String str= bf.readLine();


            int num= (int)Math.pow(10,str.length()-1);
            // 3
            // 100 ,10 ,1

            for(int x=0;x<str.length();x++)
            {
              //  System.out.println(str.charAt(x));

                int idx= str.charAt(x)-'A';
                //System.out.println(idx);
                alpha[idx]+=num;
                num=num/10;
            }
        }
        Collections.sort(arr);

        int sum=0;
        int number=9;
        Arrays.sort(alpha);
        for(int i= alpha.length-1;i>-1;i--)//i<alpha.length;i++)
        {
            if(alpha[i]==0)
                break;
            sum+= alpha[i]*number;
            number--;
        }

        //System.out.println(Arrays.toString(alpha));
        System.out.println(sum);



    }


}