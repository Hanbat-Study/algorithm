class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String skillTree : skill_trees) {
            if(check(skillTree, skill))
                answer++;
        }
        
        return answer;
    }
    
    private boolean check(String skillTree, String skill) {
        int idx = 0;
        for(int c = 0; c < skillTree.length(); c++) {
            int cur = skill.indexOf(skillTree.charAt(c));
            
            if(cur == -1)
                continue;
            
            if(cur > idx)
                return false;
            
            idx++;
        }
        
        return true;
    }
}
