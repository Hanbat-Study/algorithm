import java.util.*;
import java.io.*;

class Solution {
    static int now, videoE, opS, opE;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        now = Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]);
        videoE = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        opS = Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]);
        opE = Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1]);
        
        isOpening();
        
        for (String com : commands) {
            if (com.equals("next")) {
                now += 10;
                now = Math.min(now, videoE);
                
                isOpening();
            } else {
                now -= 10;
                now = Math.max(now, 0);
                
                isOpening();
            }
        }
        
        int m = now / 60;
        int s = now % 60;
        String formattedTime = String.format("%02d:%02d", m, s);
        
        return formattedTime;
    }
    
    public static void isOpening() {
        if (opS <= now && now <= opE) {
            now = opE;
        }
    }
}
