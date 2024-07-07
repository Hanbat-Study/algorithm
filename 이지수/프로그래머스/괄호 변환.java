import java.util.*;

class Solution {
    
    public String solution(String p) {
        
        return process(p);
    }
    
    public static String process(String s) {
        if(s.length() == 0)
            return "";
        
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        
        int idx = split(s);
        u.append(s.substring(0, idx));
        v.append(s.substring(idx));
        
        if(check(u.toString())) {
            String b = process(v.toString());
            return u.toString() + b;
        } else {
            u.deleteCharAt(0);
            u.deleteCharAt(u.length() - 1);
            return "(" + process(v.toString()) + ")" + reverse(u.toString());
        }
    }
    
    public static String reverse(String s) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                result.append(")");
            else
                result.append("(");
        }
        
        return result.toString();
    }
    
    public static int split(String s) {
        int lCnt = 0;
        int rCnt = 0;
        int i = 0;
        for(; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == '(')
                lCnt++;
            else
                rCnt++;
            
            if(lCnt == rCnt && lCnt > 0)
                break;
        }
        
        return i + 1;
    }
    
    public static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            
            if(stack.peek() == '(') {
                if(s.charAt(i) == ')')
                    stack.pop();
                else
                    stack.push('(');
            } else 
                return false;
        }
        
        if(stack.isEmpty())
            return true;
        
        return false;
    }
}
