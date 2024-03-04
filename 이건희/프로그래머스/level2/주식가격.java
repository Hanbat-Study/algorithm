class Solution {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                result[i]++;
                if (prices[j] < prices[i]) {
                    break;
                }
            }
        }
        
        return result;
    }
}
