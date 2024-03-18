
import java.util.*;
import java.io.*;
class Solution_스킬트리 {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for (String skill_tree : skill_trees) {
                boolean flag = true;
                int lastIdx = -1;
                for (int i = 0; i < skill_tree.length(); i++) {
                    int curIdx = skill.indexOf(skill_tree.charAt(i));

                    if (curIdx == -1) continue;

                    if (curIdx != lastIdx + 1) {
                        flag = false;
                        break;
                    }

                    lastIdx = curIdx;
                }

                if (flag) answer++;
            }

            return answer;
        }


}
