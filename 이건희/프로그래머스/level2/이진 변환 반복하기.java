class Solution {
    public int[] solution(String s) {
        int[] result = new int[2];
        int cnt = s.length();
        
        while (!s.equals("1")) {
            s = s.replace("0", "");
            result[1] += cnt - s.length();
            s = Integer.toBinaryString(s.length());
            cnt = s.length();
            result[0]++;
        }
        return result;
    }
}
