import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        int recordNum = record.length;
        HashMap<String, String> users = new HashMap<>();
        
        int cnt = 0;
        for(int i = 0; i < recordNum; i++) {
            String[] tmp = record[i].split(" ");
            
            if(tmp[0].equals("Leave"))
                continue;
            
            users.put(tmp[1], tmp[2]);
            
            if(tmp[0].equals("Change"))
                cnt++;
        }
        
        String[] results = new String[recordNum - cnt];
        int idx = 0;
        for(int i = 0; i < recordNum; i++) {
            String[] tmp = record[i].split(" ");
            if(tmp[0].equals("Change"))
                continue;
            
            StringBuilder sb = new StringBuilder();
            String id = tmp[1];
            String nickname = users.get(id);
            
            sb.append(nickname).append("님이 ");
            
            if(tmp[0].equals("Enter"))
                sb.append("들어왔습니다.");
            else
                sb.append("나갔습니다.");
            
            results[idx++] = sb.toString();
        }
        
        return results;
    }
}
