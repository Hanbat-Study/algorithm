import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String skill, String[] skill_trees) {
       int answer = 0;
        
        Map<String, Integer> skillMap = new HashMap<>();
        String[] arr = skill.split("");
        for(int i = 0; i < arr.length; i++) {
        	skillMap.put(arr[i], i);
        }
        
        for(String tree : skill_trees) {
        	int curIdx = 0;
        	boolean flag = true;
        	for(String s : tree.split("")) {
        		if(!skillMap.containsKey(s)) continue;
        		if(curIdx != skillMap.get(s)) {
        			flag = false;
        			break; 
        		}
        		if(curIdx == skillMap.get(s)) curIdx++;
        	}
        	if(flag) 
        		answer++;
        }
        
        return answer;
    }
}