class Solution {
    public String solution(String s) {
        int num = s.length() / 2;
        return (s.length() % 2 == 0) ? s.substring(num - 1, num + 1) : s.substring(num, num + 1);
    }
}
