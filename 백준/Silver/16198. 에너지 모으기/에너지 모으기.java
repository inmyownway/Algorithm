import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int answer= Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        ArrayList<Integer> arr= new ArrayList<>();
        
        N=Integer.parseInt(st.nextToken());
        
        st= new StringTokenizer(bf.readLine()); 
        
        for(int i=0;i<N;i++)
        {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        
        back(arr,0);
        System.out.println(answer);
    }
    public static void back(ArrayList<Integer> arr,int sum)
    {
        if(arr.size()==2)
        {
            answer= Math.max(sum,answer);
            return;
        }
    
    // 1 2 3 4
    
        for(int i=1;i<arr.size()-1;i++)
        {
            
            int temp= arr.get(i-1)*arr.get(i+1);
            
            int popOne = arr.get(i);
            arr.remove(i);
            back(arr,sum+temp);
            arr.add(i,popOne);
            
        }
    }
    
    
}
