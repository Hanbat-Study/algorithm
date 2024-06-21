class Solution {
    public int solution(String word) {
        int result = 0;
        String words = "AEIOU";
        int[] num = {781, 156, 31, 6, 1};
             
        for (int i = 0; i < word.length(); i++) {
            String now = String.valueOf(word.charAt(i));
            result += num[i] * words.indexOf(now);
        }
        return result + word.length();
    }
}
