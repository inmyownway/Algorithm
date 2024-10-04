import java.util.*;
import java.io.*;
public class Main {
    
    static int N;
    static int[] num;
    static int[] command;
    static int maxNum = Integer.MIN_VALUE;
    static int minNum = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
    
    
    BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(bf.readLine());
    
        N = Integer.parseInt(st.nextToken());
        
        st= new StringTokenizer(bf.readLine());
        num = new int[N];
        
        for(int i=0;i<N;i++)
        {
            num[i]= Integer.parseInt(st.nextToken());
            
            
        }
        command =new int[4];
           st= new StringTokenizer(bf.readLine());
        for(int i=0;i<4;i++)
        {
            command[i]= Integer.parseInt(st.nextToken());
        }
        
        simul(1,num[0]);
        System.out.println(maxNum);
        System.out.println(minNum);
    }
    public static void simul(int idx,int result)
    {
        if(idx==N)
        {
            maxNum= Math.max(maxNum,result);
            minNum= Math.min(minNum,result);    
            return;
        }
        
        for(int i=0;i<4;i++)
        {
            if(command[i]!=0)
            {
                if(i==0)
                {
                    
                    command[i]-=1;
                    simul(idx+1,result + num[idx]);               
                    command[i]+=1;
                }
                else if(i==1)
                {
                    command[i]-=1;
                    simul(idx+1,result - num[idx]);               
                    command[i]+=1;
                }
                    else if(i==2)
                {
                    command[i]-=1;
                    simul(idx+1,result * num[idx]);               
                    command[i]+=1;
                }
                    else if(i==3)
                {
                    command[i]-=1;
                    simul(idx+1,result / num[idx]);               
                    command[i]+=1;
                }
            }
        }
        
    }
}