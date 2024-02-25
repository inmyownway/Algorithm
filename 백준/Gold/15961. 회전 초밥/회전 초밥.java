import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, d, k, c;
    static int[] dishes;

    public static void main(String[] args) throws IOException {

        // 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인
        // 참여시 쿠폰 하나 줌. 벨트위에없으면 새로 만들어줌

        // 음식점 벨트 상태
        // 메뉴에있는 초밥의 가짓수
        // K(연속해서 먹는 경우)
        // 쿠폰 번호

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dishes = new int[N+k-1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            dishes[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<k-1;i++)
        {
            dishes[N++]=dishes[i];

        }

        int[] eat = new int[d+1];
        int max=1;
        eat[c]+=1;

        int start=0;
        for(int i=start;i<k;i++)
        {
            if(eat[dishes[i]]==0)
            {
                max++;
            }
            eat[dishes[i]]+=1;



        }

       

        int end=k;
        int result=max;

        for(int i=end;i<dishes.length;i++)
        {
            eat[dishes[start]]-=1;
            if(eat[dishes[start]]==0)
            {
                result-=1;
            }

            if(eat[dishes[i]]==0) result+=1;

            eat[dishes[i]]+=1;
            max=Math.max(max,result);
            start++;
        }
        System.out.println(max);
    }
}