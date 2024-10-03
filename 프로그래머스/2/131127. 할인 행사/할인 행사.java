import java.util.*;

class Solution {
    static ArrayList<String> dis;
    static ArrayList<String> food;
    
    public int solution(String[] want, int[] number, String[] discount) {
        
    
        dis = new ArrayList<>();
        food = new ArrayList<>();
        
        for(int i=0;i<10;i++)
        {
            dis.add(discount[i]);
        }
        
        for(int i=0;i<want.length;i++)
        {
            for(int j=0;j<number[i];j++)
            {
                food.add(want[i]);   
            }
        }
        
        
        int startIdx=0;
        int endIdx=9;
        int answer=0;
         
        System.out.println(food);
        int day=1;
        while(endIdx<discount.length)
        {
            
           // System.out.println("day "+(day++));
       
           // System.out.println(dis);
            //System.out.println(startIdx+" "+endIdx);

            boolean[] v= new boolean[10];
            for(int i=0;i<10;i++)
            {
               for(int j=0;j<10;j++)
               {
                 if(!v[j] && dis.get(j).equals(food.get(i)))
                 {
                    v[j]=true;
                    break;
                 }
               }
               
                //System.out.println(Arrays.toString(v));
            }
             //System.out.println();
            
            boolean flag= true;
            for(int i=0;i<10;i++)
            {
                if(!v[i])
                {
                 flag=false;
                }
            }
            
            if(flag)
                answer++;
        
            dis.remove(0);
            
            if(endIdx+1<discount.length)
            {
           
                dis.add(discount[endIdx+1]);
                
            }
            endIdx++;
           //    System.out.println(dis);
          //  System.out.println();
        }
        return answer;
    }
}