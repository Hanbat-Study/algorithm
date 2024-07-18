import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        HashMap<Character, Character> map = new HashMap<>();
        
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        
        Stack<Character> check = new Stack<>();
        
        for(int c = 0; c < s.length(); c++) {
            s = s.concat(String.valueOf(s.charAt(0)));
            s = s.substring(1);
            
            for(int i = 0; i < s.length(); i++) {
                if(!check.isEmpty()) {
                    char value = check.peek();
                    if(map.containsKey(value) && s.charAt(i) == map.get(value)) {
                        check.pop();
                    } else {
                        check.push(s.charAt(i));
                    }
                } else {
                    check.push(s.charAt(i));
                }
            }
            
            if(check.size() == 0) answer = answer + 1;
            check.clear();
        }
        
        return answer;
    }
}
