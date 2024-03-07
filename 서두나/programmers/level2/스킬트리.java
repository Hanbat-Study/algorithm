import java.util.*;

class Solution {
    static int[] level;
    
    public boolean isValid(String skill_tree){
        int k=1;
        
        for(int i =0;i<skill_tree.length();i++){
                if(level[skill_tree.charAt(i)-65]>k){
                    return false;
                }
                if(level[skill_tree.charAt(i)-65]>0){
                    k++;
                }
            }
        return true;
    }
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        level= new int[26];
        
        for(int i=0;i<skill.length();i++){
            level[skill.charAt(i)-65]=i+1;
        }
        
        for(String skill_tree: skill_trees){
            if(isValid(skill_tree)){
                answer++;
            }
        }
        return answer;
    }
}
