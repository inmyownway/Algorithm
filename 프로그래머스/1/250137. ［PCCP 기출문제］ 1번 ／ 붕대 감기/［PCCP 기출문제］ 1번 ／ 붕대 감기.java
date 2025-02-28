class Solution {
    static int HP;
    public int solution(int[] bandage, int health, int[][] attacks) {
        HP= health;
        int answer = 0;
        
        
        
        int time=0;
        
        int lastAttackTime = attacks[attacks.length-1][0];
        
        int s=0;
        
        int monsterIdx=0;
        int idx=0;
        
        for( time=1;time<=lastAttackTime;time++)
        {
            
            if(idx < attacks.length && time== attacks[idx][0])
            {
                health-=attacks[idx][1];
                if(health<=0)
                {
                    health=-1;
                    break;
                }
                s=0;
                idx++;
            }
            else{
                
                health += bandage[1];
                s+=1;
                if(s == bandage[0])
                {
                    s=0;
                    health += bandage[2];
                }
                
                if(health >= HP)
                {
                    health= HP;
                }
            }
        }
        
        return health;
    }
}