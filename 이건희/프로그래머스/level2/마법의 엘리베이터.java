class Solution {
    public int solution(int storey) {
        int result = 0;
        
        while (storey > 0) {
            int s = storey % 10;
            
            if (6 <= s || (s == 5 && 5 <= (storey / 10) % 10)) {
                result += 10 - s;
                storey += 10 - s;
            } else result += s;
            
            storey /= 10;
        }
        
        return result;
    }
}
