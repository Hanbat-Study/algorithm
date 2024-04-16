import java.util.*;
import java.lang.*;

class Solution {
    
    static int[] parents;
    
    public int solution(int n, int[][] costs) {
        int answer=0;
        
        Arrays.sort(costs,(o1,o2)->o1[2]-o2[2]);
        
        parents = new int[n];
        
        for(int i=0;i<n;i++){
            parents[i]=i;
        }

        for(int i=0;i<costs.length;i++){
            if(union(costs[i][0],costs[i][1])){
                answer+=costs[i][2];
            };
        }
        
        return answer;
    }
    
    boolean union(int a, int b){
        int p_a= find(a);
        int p_b=find(b);
        if(p_a==p_b){
            return false;
        }
        parents[p_b]=p_a;
        return true;
    }
    
    int find(int a){
        if(parents[a]==a){
            return a;
        }
        return parents[a]=find(parents[a]);
    }
}
