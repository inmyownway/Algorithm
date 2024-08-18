import java.util.*;
class Solution {
    static ArrayList<Person> arr;
    static class Person implements Comparable<Person>
    {
        int rank;
        int x;
        int y;
        Person(int rank,int x,int y)
        {
            this.rank=rank;
            this.x=x;
            this.y=y;
            
        }
        
        @Override
        public int compareTo(Person o1)
        {
            return o1.rank-this.rank;
        }
    }
    public int solution(int[][] scores) {
        int answer = 0;
        int[] want= scores[0];
        arr= new ArrayList<>();
        Arrays.sort(scores,(o1,o2) -> {
            if(o1[0]==o2[0])
            {
            return o1[1]-o2[1];
            
            }
            return o2[0]-o1[0];
        });
        
                 arr.add(new Person(scores[0][0]+scores[0][1],scores[0][0],scores[0][1]));

        int maxScore= scores[0][1];
        // for(int[] s:scores)
        // {
        //     System.out.println(Arrays.toString(s));
        // }
        for(int i=1;i<scores.length;i++)
        {
           if(scores[i][1] < maxScore)
           {
               if(scores[i][0]==want[0] && scores[i][1]==want[1])
                   return -1;
               
           }else{
               arr.add(new Person(scores[i][0]+scores[i][1],scores[i][0],scores[i][1]));
               maxScore= scores[i][1];
           }
        }
        Collections.sort(arr);
        

        
//     for(Person p : arr)
//     {
//         System.out.println(p.rank+" "+p.x+" "+p.y);
//     }
    
      for(int i=0;i<arr.size();i++)
        {
            Person person = arr.get(i);
            if(want[0]+want[1] == person.rank)
            {
                answer= i;
                break;
            }
            
        }
        
        return answer+1;
    }
}

