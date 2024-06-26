class Solution {
    public long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                result[i] = numbers[i] + 1;
            } else {
                String num = "0" + Long.toBinaryString(numbers[i]);
                StringBuilder sb = new StringBuilder(num);
                
                for (int j = sb.length() - 1; 0 < j; j--) {
                    if (sb.charAt(j) == '1' && sb.charAt(j - 1) == '0') {
                        sb.setCharAt(j, '0');
                        sb.setCharAt(j - 1, '1');
                        break;
                    }
                }
                
                result[i] = Long.parseLong(sb.toString(), 2);
            }
        }
        
        return result;
    }
}
