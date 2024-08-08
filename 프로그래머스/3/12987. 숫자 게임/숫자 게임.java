import java.util.*;
class Solution {
    
    static ArrayList<Integer> arrA;
    static ArrayList<Integer> arrB;
    static int sizeA;
    static int cnt;
    public int solution(int[] A, int[] B) 
    {
        int answer = 0;

        arrA= new ArrayList<>();
        arrB= new ArrayList<>();
        
         
        for(int i=0;i<A.length;i++)
        {
           // System.out.println(A[i]);
            arrA.add(A[i]);
            arrB.add(B[i]);
        }
         sizeA=arrA.size();
        //System.out.println(sizeA);
        Collections.sort(arrA);
        Collections.sort(arrB);
        
        for(int i=sizeA-1;i>-1;i--){
          //  System.out.println(arrA.get(i)+" "+arrB.get(arrB.size()-1));
            if(arrA.get(i) < arrB.get(arrB.size()-1))
            {
                cnt++;
                arrB.remove(arrB.size()-1);
            }
            else{
                arrB.remove(0);
            }
        }
    return cnt;
    }

    
}

