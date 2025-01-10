import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] board;
    static int answer;
    static int[] dx={1,0};
    static int[] dy={0,1};
    
    public static void main(String[] args) throws IOException{
        // 코드를 작성해주세
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        
        board= new int[N][M];
        
        for(int i=0;i<N;i++)
        {
            st= new StringTokenizer(bf.readLine());
        
            for(int j=0;j<M;j++)
            {
                board[i][j]= Integer.parseInt(st.nextToken());
                
            }
        }
        int[][] dist= new int[N][M];
        
        dist[0][0]= board[0][0];
        
        for(int i=1;i<N;i++)
        {
           dist[i][0]=  dist[i-1][0]+board[i][0];
        }
        
         for(int j=1;j<M;j++)
         {
                dist[0][j]= dist[0][j-1]+ board[0][j];
                
         }
        
            for(int i=1;i<N;i++)
            {
                for(int j=1;j<M;j++)
                {
                    dist[i][j]= Math.max(dist[i-1][j],dist[i][j-1]) + board[i][j];
                }
            }

System.out.println(dist[N-1][M-1]);
        }
        
    }


