import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        String[] str = s.toLowerCase().split("");
        String answer = "";
        boolean flag = true;

        for (int i = 0; i < str.length; i++) {
            if(flag) {
                str[i] = str[i].toUpperCase();
                flag = false;
            }
            if(str[i].equals(" ")) {
                flag = true;
            }
            else if("1234567890".contains(str[i])) {
                flag = false;
            }

            answer += str[i];
        }

        return answer;
    }
}