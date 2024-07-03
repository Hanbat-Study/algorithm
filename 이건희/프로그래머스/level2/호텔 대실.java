import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int result = 0;
        boolean check = false;
        int[][] list = new int[book_time.length][2];
        ArrayList<Integer> rooms = new ArrayList<>();
        
        for (int i = 0; i < book_time.length; i++) {
            String[] s = book_time[i][0].split(":");
            String[] e = book_time[i][1].split(":");
            
            list[i][0] = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            list[i][1] = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);
        }
        
        Arrays.sort(list, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        for (int[] time : list) {
            check = false;
            for (int i = 0; i < rooms.size(); i++) {
                if (rooms.get(i) <= time[0]) {
                    rooms.set(i, time[1] + 10);
                    check = true;
                    break;
                }
            }
            
            if (!check) {
                rooms.add(time[1] + 10);
            }
            
            rooms.sort(Comparator.naturalOrder());
        }
        
        return rooms.size();
    }
}
