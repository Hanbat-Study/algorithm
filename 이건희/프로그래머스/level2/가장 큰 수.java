import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String result = "";
        String[][] s = new String[numbers.length][2];
        
        for (int i = 0; i < numbers.length; i++) {
            s[i][0] = String.valueOf(numbers[i]).repeat(4).substring(0, 4);
            s[i][1] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(s, (a, b) -> b[0].compareTo(a[0]));
        
        if (s[0][1].equals("0")) return "0";
        
        for (String[] st : s) {
            result += st[1];
        }
        
        return result;
    }
}
