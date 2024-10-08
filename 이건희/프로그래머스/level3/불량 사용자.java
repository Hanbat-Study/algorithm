import java.util.*;

class Solution {
    static String[] arr;
    static int result;
    static int banLen;
    static int userLen;
    static boolean[] visited;
    static Set<Set<String>> set;
    
    public int solution(String[] user_id, String[] banned_id) {
        result = 0;
        banLen = banned_id.length;
        userLen = user_id.length;
        arr = new String[banLen];
        visited = new boolean[userLen];
        set = new HashSet<>();
        
        permutation(user_id, banned_id, 0);
        
        return set.size();
    }
    
     public static void check(String[] banned_id) {
        Set<String> matchedUsers = new HashSet<>();
        
        for (int i = 0; i < banLen; i++) {
            if (banned_id[i].length() != arr[i].length()) return;
            
            boolean match = true;
            
            for (int j = 0; j < banned_id[i].length(); j++) {
                if (banned_id[i].charAt(j) == '*') continue;
                else if (banned_id[i].charAt(j) != arr[i].charAt(j)) {
                    match = false;
                    break;
                }
            }
            
            if (!match) return;
            matchedUsers.add(arr[i]);
        }
        
        set.add(matchedUsers);
    }
    
    private static void permutation(String[] user_id, String[] banned_id, int cnt) {
        if (cnt == banLen) {
            check(banned_id);
            return;
        }
        for (int i = 0; i < userLen; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = user_id[i];
                permutation(user_id, banned_id, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
