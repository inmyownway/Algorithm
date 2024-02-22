import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L;
    static int C;
    static char[] password;
    static char[] word;

    public static void main(String[] args) throws IOException {


        // 1. 4가지 문자를 뽑아서 암호만듬.
        // 2. 조건검사
        // 2-1 자음2개 ,모음1개 있는지 확인
        // 2-2 오름차순인지 확인

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(bf.readLine());

        L=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());


        word = new char[C];
        password=new char[L];
        st= new StringTokenizer(bf.readLine());
        for(int i=0;i<C;i++)
        {
            String str= st.nextToken();
            word[i]=str.charAt(0);
        }

    Arrays.sort(word);
        make(0,0);



    }
    public static void make(int depth,int start)
    {
        if(depth==L)
        {
            if( check() && isUp())
            {
                String str="";
                for(int z=0;z<L;z++)
                {
                    str+=password[z];
                }
                System.out.println(str);
            }
            return;
        }

        for(int i=start;i<C;i++)
        {
            password[depth]=word[i];
            make(depth+1,i+1);
        }


    }
    public static boolean check()
    {
        int vowelCnt=0;
        char[] vowel={'a','e','i','o','u'};
        int conCnt=0;

        for(int i=0;i<L;i++)
        {

                if(password[i]=='a' ||password[i]=='e'||password[i]=='i'||password[i]=='o'||password[i]=='u')
                {
                    vowelCnt++;
                }
                else
                {
                    conCnt++;
                }

        }
        if(vowelCnt>=1 && conCnt>=2)
        {
            return true;

        }
        else return false;
    }
    public static boolean isUp()
    {
        boolean flag= true;

        for(int i=0;i<L-1;i++)
        {
            if(password[i]>password[i+1])
            {
                flag=false;
            }


        }
        return flag;
    }

}