import java.util.Arrays;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] result = new int[photo.length];
        
        for (int i = 0; i < photo.length; i++) {
            int cnt = 0;
            
            for (int j = 0; j < photo[i].length; j++) {
                if (Arrays.asList(name).contains(photo[i][j]))
                    cnt += yearning[Arrays.asList(name).indexOf(photo[i][j])];
                else continue;
            }
            
            result[i] = cnt;
        }
        return result;
    }
}
