import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<int[]> arr;
    public static void main(String[] args) throws IOException{
      
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(bf.readLine());
    
    arr= new ArrayList<>();
    N= Integer.parseInt(st.nextToken());
    for(int i=0;i<N;i++)
    {
        st = new StringTokenizer(bf.readLine());
        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
         
        arr.add(new int[]{x,y});
    

    }
        
      Collections.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
    int[] n= arr.get(0);
    int answer=n[1]-n[0];
    int end= n[1];
    for(int i=1;i<N;i++)
    {
        int[] now= arr.get(i);
        
        if(end <= now[0])
        {
            answer+= now[1]-now[0];
            end= now[1];
        }
        else if(end > now[1])
        {
            continue;
        }
        else {           
             answer+= now[1]-end;

                        end= now[1];

        }
    }   
    System.out.println(answer);
    
    }
}
