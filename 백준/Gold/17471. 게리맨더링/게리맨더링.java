import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] people;
    static ArrayList<Integer>[] list;
    static boolean[] isSelected;
    static boolean[] visited;
    static ArrayList<Integer> teamA;
    static ArrayList<Integer> teamB;
    static int answer= Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{


        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. 조합으로 팀 나눔 -> 조건 안맞으면 return
        // 2. 나눠진 팀이 각각 연결되어있는지 확인 -> 아니면 return

        N= Integer.parseInt(bf.readLine());
        people= new int[N];
        list = new ArrayList[N];
        isSelected = new boolean[N];
        st=new StringTokenizer(bf.readLine());
        for(int i=0;i<N;i++)
        {
            list[i]=new ArrayList<>();
            people[i]=Integer.parseInt(st.nextToken());
        }


        for(int i=0;i<N;i++)
        {
            st= new StringTokenizer(bf.readLine());

            int cnt= Integer.parseInt(st.nextToken());

            for(int j=0;j<cnt;j++)
            {
                list[i].add(Integer.parseInt(st.nextToken())-1);

            }

        }


        subset(0);


        if(answer==Integer.MAX_VALUE)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(answer);
        }








    }
    public static void subset(int count)
    {

        if(count==N)
        {

            visited = new boolean[N];
            int teamA=0;
            int teamB=0;

            for(int i=0;i<N;i++)
            {
                if(isSelected[i])
                {
                    teamA+=people[i];
                }
                else
                {
                    teamB+=people[i];
                }
            }
          ///./  System.out.println(Arrays.toString(isSelected));
          //  System.out.println(teamA+" "+teamB);
            // 1 3 4

            // 2 5 6
            int cnt=0;
            for(int i=0;i<N;i++)
            {
                if(!visited[i])
                {
                    check(i,isSelected[i]);
                    cnt++;
                }

            }
          //  System.out.println(answer);
            if(cnt==2)
            {
                answer=Math.min(answer,Math.abs(teamA-teamB));
            }




            return;
        }

        isSelected[count]=true;
        subset(count+1);
        isSelected[count]=false;
        subset(count+1);

    }
    public static void check(int idx,boolean areaNum)
    {
        // 각자 연결되어있는지 확인

        Queue<Integer> q = new LinkedList<>();
        visited[idx]=true;
        q.add(idx);

      while(!q.isEmpty())
      {
          int currnet= q.poll();
          for(int i=0;i<list[currnet].size();i++)
          {
              int next= list[currnet].get(i);
              if(isSelected[next]== areaNum && !visited[next])
              {
                  q.offer(next);
                  visited[next]=true;
              }
          }
      }


    }

}