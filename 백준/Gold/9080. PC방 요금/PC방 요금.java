
import java.util.*;
import java.io.*;

public class Main {
    static int starTime;
    static ArrayList<Integer> arr;
    public static void main(String[] args) throws IOException{
        
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(bf.readLine());
        
        
        int tc= Integer.parseInt(st.nextToken());
        
        for(int t=0;t<tc;t++)
        {
        
        String[] str= bf.readLine().split(" ");
    
        
        String[] temp= str[0].split(":");
        int H= Integer.parseInt(temp[0]);
        int M= Integer.parseInt(temp[1]) ;
        
        int useTime= Integer.parseInt(str[1]);
        
        int price=0;
        
        while(useTime>0)
        {
            if((H>=22 || H<3) && useTime > 300)
            {
                while(H!=8)
                {
                    H = (H+1)%24;
                    useTime-=60;
                }
                price+=5000;
                useTime+= M;
                M=0;
            }
            else{
                H= (H+1)%24;
                price+=1000;
                useTime-=60;
            }
        }
        
        System.out.println(price);
                   
        }       
    }
}
