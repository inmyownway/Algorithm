import java.util.*;
public class Main {
	static int N,S,arr[];
	static boolean[] isSelected;
	static int answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        generateSubSet(0, 0);
        if (S == 0) System.out.println(answer - 1); 
        //S 0일때가 전체 합이 0 일때랑 겹치기 때문에 -1 을 해주어야 합니다.
        //위의 사진에 공집합이 0이라고 볼 수 있습니다
         else  System.out.println(answer);
	
	
	}
	public static void generateSubSet(int idx,int ss)
	{
		 if (idx == N) {
			 
	            if (S == ss) {
	                answer++;
	            }
	            return;
	        }

	     //   isSelected[idx] = true;
	        generateSubSet(idx + 1, ss + arr[idx]);
	     //   isSelected[idx] = false;
	        generateSubSet(idx + 1, ss);
	}
	private static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) answer++;
            return;
        }
        //tree를 생각해서 직접 그려보면 이해하기가 쉽습니다.
        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum); 
    }
}
