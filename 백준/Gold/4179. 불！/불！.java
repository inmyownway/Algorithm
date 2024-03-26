import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static boolean[][] v;
    static class Person{
        int x;
        int y;
        int t;

        public Person(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
    static class Fire{
        int x;
        int y;

        public Fire(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static ArrayList<Person> person;
    static ArrayList<Fire> fire;
    static int answer;
    static int[] dx= {0,0,-1,1};
    static int[] dy ={1,-1,0,0};
    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        v=  new boolean[N][M];

        person = new ArrayList<>();
        fire = new ArrayList<>();

        for(int i=0;i<N;i++)
        {
            String s= bf.readLine();
            for(int j=0;j<s.length();j++)
            {

                char c= s.charAt(j);

                if(c=='#')
                {
                    v[i][j]=true;
                }
                if(c=='J')
                {
                    person.add(new Person(i,j,0));
                }
                if(c=='F')
                {
                    v[i][j]=true;
                    fire.add(new Fire(i,j));
                }

            }
        }

        while(true)
        {
            // 사람이동 , 나한테 불있으면 이동x , 만약 밖으로 나가면 끝남
            boolean isEsapce = movePerson();

            if(isEsapce)
            {
                System.out.println(answer);
                break;
            }
            // 불 이동
            moveFire();


            if(person.size()==0)
            {
                System.out.println("IMPOSSIBLE");
                break;
            }
        }
    }

    private static void moveFire() {
        ArrayList<Fire> newFire= new ArrayList<>();

        for(Fire f:fire)
        {
            v[f.x][f.y]=true;

            for(int i=0;i<4;i++)
            {
                int nx=f.x+dx[i];
                int ny=f.y+dy[i];
                if(isBoundary(nx,ny) && !v[nx][ny])
                {
                    v[nx][ny]=true;
                    newFire.add(new Fire(nx,ny));
                }
            }
        }

        fire = new ArrayList<>();
        for(Fire nf : newFire )
        {
            fire.add(nf);
        }
    }

    private static boolean movePerson() {

      ArrayList<Person> newPerson = new ArrayList<>();
        for(Person p : person)
        {


            if(!v[p.x][p.y])
            {   v[p.x][p.y]=true;
                for(int i=0;i<4;i++)
                {
                    int nx=p.x+dx[i];
                    int ny=p.y+dy[i];
                    if(!isBoundary(nx, ny))
                    {
                        answer=p.t+1;
                        return true;
                    }
                    else if(isBoundary(nx,ny) && !v[nx][ny])
                    {
                        newPerson.add(new Person(nx,ny,p.t+1));

                    }
                }
            }
        }

        person= new ArrayList<>();
        for(Person np: newPerson)
        {
            person.add(np);
          //  System.out.println(np);
        }
        return false;
    }

    public static boolean isBoundary(int x,int y)
    {
        return x>=0&& x<N && y>=0 && y<M;
    }
}