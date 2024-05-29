class Solution {
    public int solution(int n) {
        int result = 0;
        String bi1 = Integer.toBinaryString(n);
        int cnt1 = bi1.length() - bi1.replace("1", "").length();
        
        for (int i = n + 1; i < 10000000; i++) {
            String bi2 = Integer.toBinaryString(i);
            int cnt2 = bi2.length() - bi2.replace("1", "").length();
            
            if (cnt1 == cnt2) {
                result = i;
                break;
            }
        }
        return result;
    }
}
