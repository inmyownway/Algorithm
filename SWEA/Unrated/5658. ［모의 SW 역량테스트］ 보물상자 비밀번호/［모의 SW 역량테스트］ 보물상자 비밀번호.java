import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    /*
    5
    12 10
    1B3B3B81F75E
    * */
    static int N,K;
    static ArrayList<char[][]> allNum;
    static char[][] arr;
    static String password;
    static Set<String> s;
    public static  void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

        int testCase= Integer.parseInt(st.nextToken());


        for(int tc=1;tc<testCase+1;tc++)
        {
            st= new StringTokenizer(bf.readLine());
            N=Integer.parseInt(st.nextToken());
            K=Integer.parseInt(st.nextToken());
            password= bf.readLine();

            allNum= new ArrayList<>();
            arr = new char[4][N/4];
            s= new HashSet<>();
            // 1B3B3B81F75E


            // 초기값은 그냥 넣어주자
            int idx=0;
            for(int i=0;i<4;i++)
            {
                for(int j=0;j<N/4;j++)
                {
                    arr[i][j]=password.charAt(idx++);
                }
            }
          //  System.out.println("처음");
        //print(arr);

        allNum.add(arr);

            while(true)
            {
                // 회전시키고 ( 한칸씩)

               password= rotate();
               // System.out.println("패스워드 "+password);
               divide();

               // 넣기
                allNum.add(arr);



                // 지금 맨앞과 맨뒤 같으면 break
                if(check()){
                  //  System.out.println("same");
                    break;
                }


            }

            for(char[][] c : allNum)
            {
                for(int i=0;i<4;i++)
                {
                    String ss="";
                    for(int j=0;j<N/4;j++)
                    {
                        ss+=c[i][j];
                    }
                    s.add(ss);
                }
            }

            // F75, E1B, B81, B3B, 81F, 75E, 5E1, 3B8, 3B3, 1F7, 1B3
            ArrayList<String> ta = new ArrayList<>();
            for(String ss : s)
            {
                ta.add(ss);
            }
            Collections.sort(ta,Collections.reverseOrder());
           // System.out.println(ta);

            String ans = ta.get(K-1);//System.out.println(ans);




            int sum = Integer.parseInt(ans, 16);

            System.out.println("#"+tc+" "+sum);





        }

    }
    public static String rotate()
    {
        String temp = "";

        temp += Character.toString(password.charAt(password.length()-1));
        for(int i=0;i<password.length()-1;i++)
        {
            temp+=Character.toString(password.charAt(i));
        }
        return temp;
    }
    public static void divide()
    {    arr = new char[4][N/4];
        int idx=0;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<N/4;j++)
            {
               // System.out.println(i+" "+j+" "+idx);
                arr[i][j]=password.charAt(idx++);
             //   System.out.println("@");
            }
        }
       // print(arr);
    }
    public static boolean check()
    {
        char[][] first= allNum.get(0);
        char[][] last= allNum.get(allNum.size()-1);

        boolean flag= true;

        for(int i=0;i<4;i++)
        {
            for(int j=0;j<N/4;j++)
            {//System.out.println(first[i][j]+" "+last[i][j]);
                if (first[i][j]!=last[i][j])
                {

                    flag=false;
                }
            }

        }
        return flag;
    }
    public static void print(char[][] a)
    {

        for(int i=0;i<a.length;i++)
        {
            System.out.print(Arrays.toString(a[i])+", ");
        }
        System.out.println();
    }

}