import java.util.*;
import java.io.*;

class Solution {
    static int[][] board;
    static int nx,ny;
    static int n,N,M;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    
    
    public int[] solution(String[] park, String[] routes) {
        
        
        n= park.length;
        
        board= new int[park.length][park.length];
        
        N= park.length;
        M= park[0].length();
        for(int i=0;i<n;i++)
        {
            String str= park[i];
            for(int j=0;j<str.length();j++)
            {
                
                char s= str.charAt(j);
                if(s=='O')
                {
                    board[i][j]=0;
                    
                }
                else if(s=='X')
                {
                    board[i][j]=1;
                }
                else if(s=='S')
                {
                    nx= i;
                    ny= j;
                    board[i][j]=0;
                }
            }
            
        }
        
        for(String r: routes)
        {
            char command = r.charAt(0);
            int distance= r.charAt(2)-'0';
            
            boolean flag= true;
            
            int nowX=nx;
            int nowY=ny;
            int d=-1;
            
            if(command=='N')
            {
                d=0;
            }
            else if(command=='S')
            {
                d=1;
            }
            else if(command=='W')
            {
                d=2;
            }
            else{
                d=3;
            }
            int x=nx;
            int y=ny;
            for(int i=0;i<distance;i++)
            {
                x+=dx[d];
                y+=dy[d];
                if(isBoundary(x,y) && board[x][y]==0)
                {
                    continue;
                }
                else{
                    flag=false;
                    break;
                }
            }
            if(flag)
            {
                nx=x;
                ny=y;
            }
          //  System.out.println(nx+" "+ny);
        }
        int[] answer= new int[]{nx,ny};
        return answer;
    }
    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<M;
    }
}