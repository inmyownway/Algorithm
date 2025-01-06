import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int[][] board;
    static boolean[] v;
    
        public static void main(String[] args) throws IOException{

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        int testCase= Integer.parseInt(st.nextToken());
        
        for(int t=0;t<testCase;t++)
        
        {
            N= Integer.parseInt(bf.readLine());
            
            st= new StringTokenizer(bf.readLine());
            board= new int[N][N];
            v= new boolean[N];
            for(int i=0;i<N;i++)
            {
                int a= Integer.parseInt(st.nextToken());
                
                board[i][a-1]=1;
            }
            
            int cnt=0;
            
            for(int i=0;i<N;i++)
            {
                if(!v[i])
                {
                    v[i]=true;
                    cnt++;
                    Queue<Integer> q= new LinkedList<>();
                    q.add(i);
                    
                    while(!q.isEmpty())
                    {
                        int now= q.poll();
                        
                        for(int j=0;j<N;j++)
                        {
                            if(board[now][j]==1 && !v[j])
                            {
                                q.add(j);
                                v[j]=true;
                            }
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
