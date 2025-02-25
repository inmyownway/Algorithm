import java.util.*;

class Solution {
    static boolean[][] redV,blueV;
    static int rx,ry,bx,by;
    static int rEx,rEy,bEx,bEy;
    static int answer,N,M;
    //static boolean blueFlag,redFlag;
    static int[] dx={0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static int[][] maze;
    public int solution(int[][] maze) {
        this.maze=maze;
        N= maze.length;
        M= maze[0].length;
        
        answer= Integer.MAX_VALUE;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(maze[i][j]==1)
                {
                    rx=i;
                    ry=j;
                }
                else if(maze[i][j]==2)
                {
                    bx=i;
                    by=j;
                }
                else if(maze[i][j]==3)
                {
                    rEx=i;
                    rEy=j;
                    
                }
                else if(maze[i][j]==4)
                {
                    bEx=i;
                    bEy=j;
                }
            }
        }
        boolean blueFlag=false;
        boolean redFlag=false;
        
        blueV = new boolean[N][M];
        redV = new boolean[N][M];
        
        blueV[bx][by]=true;
        redV[rx][ry]=true;
        
        dfs(rx,ry,bx,by,0,blueFlag,redFlag);
        
        if(answer== Integer.MAX_VALUE)
        {
    answer=0;
        }
        
        return answer;
    }
    public static void dfs(int rx,int ry,int bx,int by,int cnt,boolean blueFlag,boolean redFlag)
    {
        if(rx== rEx && ry== rEy && bx==bEx && by==bEy)
        {
            answer=Math.min(answer,cnt);
            return;
        }
        if(rx==rEx && ry==rEy)
        {
        redFlag=true;
        }
        
        if(bx==bEx && by==bEy)
        {
            blueFlag=true;
        }
        
        if(redFlag)
        {
            for(int idx=0;idx<4;idx++)
            {
                int bNx= bx+dx[idx];
                int bNy= by+dy[idx];
                
                if(isBoundary(bNx,bNy) && maze[bNx][bNy]!=5 && !blueV[bNx][bNy] && !(bNx == rx && bNy == ry))
                {   
                    blueV[bNx][bNy]=true;
                    dfs(rx,ry,bNx,bNy,cnt+1,blueFlag,redFlag);
                     blueV[bNx][bNy]=false;
                }
            }
        }
        else if(blueFlag)
        {
            for(int idx=0;idx<4;idx++)
            {
                int rNx= rx+dx[idx];
                int rNy= ry+dy[idx];
                
                if(isBoundary(rNx,rNy) && maze[rNx][rNy]!=5 && !redV[rNx][rNy] && !(rNx == bx && rNy == by))
                {
                    redV[rNx][rNy]=true;
                    dfs(rNx,rNy,bx,by,cnt+1,blueFlag,redFlag);
                        redV[rNx][rNy]=false;
                }
            }
        }
        else
        {
            for(int a=0;a<4;a++)
            {
                int rNx= rx+dx[a];
                int rNy= ry+dy[a];
                
                for(int b=0;b<4;b++)
                {
                       int bNx= bx+dx[b];
                       int bNy= by+dy[b]; 
                        
                     if(isBoundary(bNx,bNy) && isBoundary(rNx,rNy) && !blueV[bNx][bNy] && !redV[rNx][rNy] && maze[bNx][bNy] !=5 && maze[rNx][rNy]!=5)
                     {
                         if(!(bNx == rx && bNy ==ry && rNx==bx && rNy== by) && !(bNx==rNx && bNy==rNy))
                         {
                            redV[rNx][rNy]=true;
                            blueV[bNx][bNy]=true;
                            dfs(rNx,rNy,bNx,bNy,cnt+1,blueFlag,redFlag);
                             redV[rNx][rNy]=false;
                            blueV[bNx][bNy]=false;
                         }
                     }
                }
                
            }
        }
    }
    public static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<N && y>=0 && y<M;
    }
}