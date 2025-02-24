import java.util.*;
class Solution {
    static char[][] board;
    static int N,M;
    static int answer;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    
    public int solution(String[] storage, String[] requests) {
        answer = 0;
        N= storage.length;
        M= storage[0].length();
        
        board= new char[N+2][M+2];
        boolean[][] v= new boolean[N+2][M+2];
        
        Queue<int[]> q= new LinkedList<>();
        
        for(int i=0;i<N+2;i++)
        {
            for(int j=0;j<M+2;j++)
            {
                board[i][j]= '1';
            }
        }
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
              board[i+1][j+1]= storage[i].charAt(j);
            }
        }
        
        
        for(String str: requests)
        {  
        //System.out.println();
          //      System.out.println(str.charAt(0));
            if(str.length()>=2)
            {
                for(int i=1;i<N+1;i++)
                {
                    for(int j=1;j<M+1;j++)
                    {
                        if(board[i][j]==str.charAt(0))
                        {
                            board[i][j]='1';
                        }
                    }
                }
            }
            else
            {
                //System.out.println("bfs");
                
                q = new LinkedList<>();
                q.add(new int[]{0,0});
                 v= new boolean[N+2][M+2];
                v[0][0]=true;
                
               
                while(!q.isEmpty())
                {
                    int[] now= q.poll();
                    int x=now[0];
                    int y=now[1];
                    for(int idx=0;idx<4;idx++)
                    {
                        int nx = x+dx[idx];
                        int ny = y+dy[idx];
                        
                        if(isBoundary(nx,ny) && !v[nx][ny])
                        {
                            
                          //  System.out.println("nx ny "+nx+" "+ny +" "+ board[nx][ny]);
                            if( board[nx][ny]==str.charAt(0))   
                            {
                               // System.out.println("delete");
                                board[nx][ny]='1';
                                v[nx][ny]=true;
                            }
                            else if(board[nx][ny]=='1')
                            {
                                q.add(new int[]{nx,ny});
                                v[nx][ny]=true;
                            }
                            
                        }
                    }
                    
                }
            }
         
        
           
        }
       
        
        for(int i=1;i<N+2;i++)
        {
            for(int j=1;j<M+2;j++)
            {
                if(board[i][j]!='1')
                {
                    answer++;
                }
            }
        }
        
     
        
        
        
        return answer;
        
    }
    public static boolean isBoundary(int x,int y)
    {
     return x>=0 && x<N+2 && y>=0 && y<M+2;
    }
}