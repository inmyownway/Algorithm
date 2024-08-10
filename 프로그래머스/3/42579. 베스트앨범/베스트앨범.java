import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
    
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<genres.length;i++)
        {
            if(map.containsKey(genres[i]))
            {
                map.replace(genres[i],map.get(genres[i])+plays[i]);
            }
            else{
                
            map.put(genres[i],plays[i]);
        
            }
            }
        
      
        List<Map.Entry<String,Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        
        for(Map.Entry<String,Integer> entry: entryList)
        {
            String gen = entry.getKey();
            
            ArrayList<int[]> arr = new ArrayList<>();
            
            for(int i=0;i<genres.length;i++)
            {
                if(gen.equals(genres[i])){
                    
                    arr.add(new int[]{i,plays[i]});
                    
                }
            }
            
            Collections.sort(arr,new Comparator<int[]>(){
               
                @Override
                public int compare(int[] a,int[] b)
                {
                    if(a[1]==b[1])
                        return a[0]-b[0];
                    return b[1]-a[1];
                
                }
            });
            
            if(arr.size()==1)
            {
                int[] now= arr.get(0);
                answer.add(now[0]);
            }
            else{
                for(int i=0;i<2;i++)
                {
                     
                int[] now= arr.get(i);
                answer.add(now[0]);
                }
            }
                
        }
        
        int[] ans= new int[answer.size()];
        for(int i=0;i<answer.size();i++)
        {
            ans[i]=answer.get(i);
        }
        return ans;
    }
}