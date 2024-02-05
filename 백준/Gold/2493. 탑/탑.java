import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr;
	static int[] answer;
	static Stack<int[]> st;
	public static void main(String[] argrs) throws IOException
	{
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
	    int N= Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        Stack<int[]> stack = new Stack<>();
        for(int i = 1; i <= N; i++) {
            int top = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()) {
                if(stack.peek()[1] >= top) {
                    System.out.print(stack.peek()[0] + " ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()) {
                System.out.print("0 ");
            }
            stack.push(new int[] {i, top}); 
		}
		



				
				
				
				
				
			}
}
			//System.out.println(Arrays.toString(answer));
			//System.out.println(st);
		
		//System.out.println(Arrays.toString(answer));