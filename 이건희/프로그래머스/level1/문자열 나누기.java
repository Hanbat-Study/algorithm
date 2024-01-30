class Solution {
    public int solution(String s) {
        int result = 0;
        int cnt = 1;
        int not = 0;
        char word = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            if (word == ' ') {
                word = s.charAt(i);
                cnt++;
            } else if (s.charAt(i) == word) {
                cnt++;
            } else if (s.charAt(i) != word) {
                not++;
            }
            if (cnt == not) {
                cnt = 0;
                not = 0;
                word = ' ';
                result++;
            }
        }
        if (word != ' ')
            result++;
        return result;
    }
}
