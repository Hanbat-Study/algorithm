import java.util.*;
import java.lang.*;

class Solution {
    
    public int solution(int[] d, int budget) {
        int answer=0;
        Arrays.sort(d);
        int temp=0;
        for(int i=0;i<d.length;i++){
            temp+=d[i];
            if(budget<temp){
                break;
            }
            answer++;
        }
            
        return answer;
    }
}
