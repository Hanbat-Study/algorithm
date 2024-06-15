import java.io.*;
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> s1 = new ArrayList<>();
        ArrayList<String> s2 = new ArrayList<>();
        int sum = 0;
        
        for (int i = 0; i < str1.length() - 1; i++) {
            if (Character.isLetter(str1.charAt(i)) && Character.isLetter(str1.charAt(i + 1))) {
                s1.add(str1.substring(i, i + 2).toLowerCase());
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            if (Character.isLetter(str2.charAt(i)) && Character.isLetter(str2.charAt(i + 1))) {
                s2.add(str2.substring(i, i + 2).toLowerCase());
            }
        }
        
        int iNum = s1.size() + s2.size();
        
        for (String s : s1) {
            if (s2.contains(s)) {
                sum++;
                s2.remove(s);
            }
        }
        
        iNum -= sum;

        if (iNum == 0) return 65536;
        else return (int)(((double)sum / iNum) * 65536);
    }
}
