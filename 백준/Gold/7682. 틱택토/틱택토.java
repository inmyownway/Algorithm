import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static int cntX,cntY;
    static String answer;
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while(true)
        {
            String str= bf.readLine();
            if(str.equals("end")) break;
            
            board= new char[3][3];
         
            cntX=0;
            cntY=0;
            answer= "";
            boolean flag=false;
            int idx=0;

            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++){
                    board[i][j]=str.charAt(idx);
                    if(board[i][j]=='X') cntX++;
                    else if(board[i][j]=='O') cntY++;
                    idx++;
                }
            }

//            for(char[]b:board)
//            {
//                System.out.println(Arrays.toString(b));
//            }
//
//            System.out.println(cntX+" "+cntY);

            if(cntX-1==cntY && cntY!=0)
            {
                if(isFull() || isThree('X'))
                    flag=true;

                if(isThree('O'))
                    flag= false;


            }
            else if (cntY!=0 && cntY!=0 && cntY==cntX)
            {
               if( isThree('O'))
                   flag=true;

               if(isThree('X'))
                   flag=false;
            }

            if (flag) {
                System.out.println("valid");

            }
            else
            {
                System.out.println("invalid");
            }
        }
    }

    private static boolean isThree(char ch) {

        // 가로 세로

        for (int i = 0; i < 3; i++) {
            int w=0;
            int h=0;
            for (int j = 0; j < 3; j++) {

                if(board[i][j]==ch)
                {
                    w++;
                }
                if(board[j][i]==ch)
                {
                    h++;
                }
            }
            if( w==3 || h==3 )
                return true;
        }


        // 대각
        if(board[0][0]==ch && board[1][1]==ch && board[2][2]==ch)
            return true;

        if(board[0][2]==ch && board[1][1]==ch && board[2][0]==ch)
            return  true;
        return  false;
    }

    private static boolean isFull() { int point=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if (board[i][j]=='.')
                    point++;
            }
        }
        if (point==0)
            return true;
        return false;
    }
}