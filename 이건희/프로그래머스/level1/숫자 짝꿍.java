class Solution {
    public String solution(String X, String Y) {
        String result = "";
        int[] arrX = new int[10];
        int[] arrY = new int[10];
        
        for (int i = 0; i < 10; i++) {
            String n = String.valueOf(i);
            for (int j = 0; j < X.length(); j++) {
                if (X.charAt(j) == (char)i) {
                    arrX[i]++;
                }
            }
            for (int j = 0; j < Y.length(); j++) {
                if (Y.charAt(j) == (char)i) {
                    arrY[i]++;
                }
            }
        } 
        
        for (int i = 9; 0 <= i; i--) {
            result += String.valueOf(i).repeat(Math.abs(arrX[i] - arrY[i]));
        }
        return result;
    }
}
