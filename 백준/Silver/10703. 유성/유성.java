import java.util.*;
import java.io.*;


public class Main {
    static int R,S;
    static char[][] board;

    static ArrayList<int[]> arr;
    public static void main(String[] args) throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        // 코드를 작성해주세요
        
        R= Integer.parseInt(st.nextToken());
        S= Integer.parseInt(st.nextToken());
        
        board= new char[R][S];
        
        arr= new ArrayList<>();
        for(int i=0;i<R;i++)
        {
            
            String str= bf.readLine();
            for(int j=0;j<S;j++)
            {
                board[i][j]= str.charAt(j);
            }
        }
        
        for(int i=0;i<S;i++)
        {
            for(int j=R-1;j>-1;j--)
            {
                if(board[j][i]=='X')
                {
                    arr.add(new int[]{j,i});
                    break;
                }
            }
        }
        
        int canGo=0;
        for(int i=1;i<R;i++)
        {
            boolean check= true;
            for(int[] t: arr)
            {
                if(!isBoundary(t[0]+i,t[1]))
                {
                    check=false;
                }
                if(!check)
                {
                    canGo=i-1;
                    break;
                }
            }
            if(!check)
            {
                break;
            }
        }
        
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<S;i++)
        {
            for(int j=R-1;j>-1;j--)
            {
                if(board[j][i]=='X')
                {
                    board[j+canGo][i]='X';
                    board[j][i]='.';
                    
                }
             
            }
           
        }
        
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<S;j++)
            {
                   sb.append(board[i][j]);
            }
             sb.append("\n");
        }
        System.out.println(sb.toString());
      
             
        
    ///    System.out.println(canGo);
    //
        
    }
    public static boolean isBoundary(int x,int y)
    {
       
        
        if(x<R && board[x][y]=='.')
        {
            return true;
        }
        return false;
    }
}
