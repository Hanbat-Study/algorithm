import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int time = 0;
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int a = 0;
        int cnt = 0;
        int now = health;
        
        for (int i = 0; i <= attacks[attacks.length - 1][0]; i++) {
            int[] attack = attacks[a];
            
            if (attack[0] == i) {
                now -= attack[1];
                cnt = 0;
                a += 1;
            } else {
                cnt += 1;
                now += x;
                
                if (cnt == t) {
                    now += y;
                    cnt = 0;
                }
                
                now = Math.min(health, now);
            }
            
            if (now <= 0) return -1;
        }
        
        
        return now;
    }
}
