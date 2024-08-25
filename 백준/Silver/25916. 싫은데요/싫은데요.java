import java.util.*;
import java.io.*;
public class Main {
    static int N,M;
    static int[] holes;
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세요
        
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        N= Integer.parseInt(st.nextToken());///.readLine());
        M= Integer.parseInt(st.nextToken());
        
        holes= new int[N];
        st= new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++)
        {
            holes[i]= Integer.parseInt(st.nextToken());
        }
        
        int left=0;
        int right=0;
        int cnt=0;
        int v=0;
        int ans=0;
        while(right<N)
        {
            v+= holes[right++];
            cnt++;
            if(v>M)
            {
                while(true)
                {
                    if(v<=M)
                    {
                        break;
                    }
                    v-=holes[left++];
                    cnt--;
                }
            }
            ans=Math.max(ans,v);
        }
        System.out.println(ans);
    }
}