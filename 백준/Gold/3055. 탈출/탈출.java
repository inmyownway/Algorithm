import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

public class Main {
    static int R,C;
    static char[][] board;
    static Queue<Person> person;
    static Queue<Water> water;
    static int[] dx= {0,0,-1,1};
    static int[] dy={1,-1,0,0};
    static boolean[][] personV;
    static boolean[][] waterV;
    static boolean flag;
    public static class Person{
        int x;
        int y;
        int d;

        public Person(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    public static class Water
    {
        int x;
        int y;

        public Water(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }



    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());

         R = Integer.parseInt(st.nextToken());
         C = Integer.parseInt(st.nextToken());

         board= new char[R][C];
         person = new LinkedList<>();
         water= new LinkedList<>();

         personV = new boolean[R][C];
        waterV = new boolean[R][C];

         for(int i=0;i<R;i++)
         {
             String str= bf.readLine();
             for(int j=0;j<C;j++)
             {
                 board[i][j]=str.charAt(j);
                 if(board[i][j]=='S')
                 {
                     person.add(new Person(i,j,0));
                     personV[i][j]=true;
                 }
                 else if(board[i][j]=='*')
                 {
                     water.add(new Water(i,j));
                     waterV[i][j]=true;
                 }
             }
         }



         while(true)
         {

             // 고슴도치 이동 ( 큐사이즈만큼, 위에 물있으면 못감)
             movePerson();
             if(flag)
                break;
             if(person.size()==0)
             {
                 System.out.println("KAKTUS");
                 break;
             }
             // 물 이동 (큐사이즈만큼)
             moveWater();

         }
    }

    private static void moveWater() {

        int s = water.size();
        for (int i = 0; i < s; i++) {
            Water cur = water.poll();

            for (int idx = 0; idx < 4; idx++) {
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];
                if (isBoundary(nx, ny) && board[nx][ny] == '.' && waterV[nx][ny] == false) {
                    board[nx][ny]='*';
                    waterV[nx][ny]=true;
                    water.add(new Water(nx, ny));
                }
            }
        }
    }

    private static void movePerson() {

        int s= person.size();
        for(int i=0;i<s;i++)
        {
            Person cur= person.poll();

            if(board[cur.x][cur.y]=='*')
                continue;
            if(board[cur.x][cur.y]=='D')
            {
                System.out.println(cur.d);
                flag=true;
                return;
            }

            for(int idx=0;idx<4;idx++)
            {
                int nx= cur.x+dx[idx];
                int ny=cur.y+dy[idx];
                if(isBoundary(nx,ny) && board[nx][ny]!='*' && board[nx][ny] !='X' && personV[nx][ny]==false)
                {
                    personV[nx][ny]=true;
                    person.add(new Person(nx,ny,cur.d+1));
                }
            }



        }
    }
    private static boolean isBoundary(int x,int y)
    {
        return x>=0 && x<R && y>=0 && y<C;
    }

}