import java.io.*;
import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int result = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            StringBuilder sb = new StringBuilder();
            String[] sk = skill_trees[i].split("");
            
            for (int j = 0; j < sk.length; j++) {
                if (skill.contains(sk[j])) {
                    sb.append(sk[j]);
                }
            }
            
            if (skill.substring(0, sb.length()).equals(sb.toString())) result++;

        }
        
        return result;
    }
}
